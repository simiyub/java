package real.timedevents;

import java.util.function.Consumer;

/**
 * Manages an active set of deadlines to be raised whenever they expire.
 */
public interface DeadlineEngine {
    /**
     * Request a new deadline be added to the engine.  The deadline is in millis offset from
     * unix epoch. https://en.wikipedia.org/wiki/Unix_time
     * The engine will raise an event whenever a deadline (usually now in millis) supplied in the poll method
     * exceeds the request deadline.
     * @param deadlineMs the millis
     * @return An identifier for the scheduled deadline.
     */
    long schedule(long deadlineMs);

    /**
     * Remove the scheduled event using the identifier returned when the deadline was scheduled.
     * @param requestId identifier to cancel.
     * @return true if canceled.
     */
    boolean cancel(long requestId);

    /**
     * Supplies a deadline in millis to check against scheduled deadlines.  If any deadlines are triggered the
     * supplied handler is called with the identifier of the expired deadline.
     * To avoid a system flood and manage how many expired events we can handle we also pass in the maximum number of
     * expired deadlines to fire.  Those expired deadlines that weren't raised will be available in the next poll.
     * There is no need for the triggered deadlines to fire in order.
     * @param nowMs time in millis since epoch to check deadlines against.
     * @param handler to call with identifier of expired deadlines.
     * @param maxPoll count of maximum number of expired deadlines to process.
     * @return number of expired deadlines that fired successfully.
     */
    int poll(long nowMs, Consumer<Long> handler, int maxPoll);

    /**
     *
     * @return the number of registered deadlines.
     */
    int size();
}