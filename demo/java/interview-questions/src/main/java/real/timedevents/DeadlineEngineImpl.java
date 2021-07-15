package real.timedevents;


import java.util.UUID;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;


/**
 * Timer or Scheduled Executor service
 * Determine appropriate Identifier for deadlines
 * Producer - Consumer set up:
 * Two queues:
 * 1) A queue for requests
 * 2) A queue for deadlines
 *  - Queue should be ordered by deadline
 * - Determine how many threads will serve the queues
 * - Determine how to manage the queues to grow and shrink depending on demand
 *  > Potentially depending on expected requests
 * */
 class DeadlineEngineImpl implements DeadlineEngine {
    private final BlockingQueue<Deadline> deadlineQueue = new LinkedBlockingQueue<>();

    @Override
    public long schedule(long deadlineMs) {
        long id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        try {
            deadlineQueue.put(new Deadline(id,deadlineMs));
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return id;
    }

    @Override
    public int poll(long nowMs, Consumer<Long> handler, int maxPoll) {

        //Come back and deal with performance around limit
        //How do we know they were processed without exception

        BlockingQueue<Deadline> processed = deadlineQueue.parallelStream()
                .filter(deadline -> nowMs >= deadline.deadlineMs)
                .limit(maxPoll)
                .collect(Collectors.toCollection(LinkedBlockingQueue::new));

        int toProcess = processed.size();

        processed.parallelStream().forEach( item -> handler.accept(item.ID));
        return toProcess;
    }

    @Override
    public boolean cancel(long requestId) {

        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {

        return deadlineQueue.size();
    }

    private static class Deadline {
        private final long ID;
        private final long deadlineMs;

        private Deadline(long id, long deadlineMs) {
            ID = id;
            this.deadlineMs = deadlineMs;
        }

    }
}
