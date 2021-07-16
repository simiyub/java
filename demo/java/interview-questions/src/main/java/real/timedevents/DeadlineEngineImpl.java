package real.timedevents;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.*;
import java.util.function.Consumer;

import static java.util.stream.Collectors.*;


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
   // private final BlockingQueue<Deadline> deadlineQueue = new LinkedBlockingQueue<>();
    private final ConcurrentMap<Long,Long> deadlineMap = new ConcurrentHashMap<>();


    @Override
    public long schedule(long deadlineMs) {
        long id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        try {
            //deadlineQueue.put(new Deadline(id,deadlineMs));
            deadlineMap.put(id, deadlineMs);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return id;
    }

    @Override
    public int poll(long nowMs, Consumer<Long> handler, int maxPoll) {

        //Come back and deal with performance around limit
        //How do we know they were processed without exception
        int toProcessCount =0;

        try {

//        BlockingQueue<Deadline> toProcess = deadlineQueue.stream()
//                .filter(deadline -> nowMs > deadline.deadlineMs)
//                .limit(maxPoll)
//                .collect(Collectors.toCollection(LinkedBlockingQueue::new));
//
//
//        int toProcessCount = toProcess.size();
//        System.out.println(toProcessCount+ " deadlines identified.");
//
//        //Deal with data losses
//        //Only record those that
//        toProcess.stream().forEach( item -> handler.accept(item.ID));
//        toProcess.parallelStream().forEach( deadlineQueue::remove);
//        return toProcessCount;

            ConcurrentMap<Long, Long> toProcess = deadlineMap.entrySet().stream()
                    .filter(entry -> nowMs > entry.getValue())
                    .limit(maxPoll)
                    .collect(toConcurrentMap(Map.Entry::getKey, Map.Entry::getValue));

            toProcessCount = toProcess.size();
            System.out.println(toProcessCount + " deadlines identified.");

            //Deal with data losses
            //Only record those that
            toProcess.entrySet().stream().forEach(item -> deadlineHandler(item, handler));
            //  toProcess.entrySet().stream().forEach( item ->  deadlineMap.remove(item));
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
        return toProcessCount;
    }

    private boolean deadlineHandler(Map.Entry<Long,Long> entry,Consumer<Long> handler){

        handler.accept(entry.getKey());

        return deadlineMap.remove(entry.getKey(), entry.getValue());
    }

    @Override
    public boolean cancel(long requestId) {

        //return deadlineQueue.remove(requestId);
        return !deadlineMap.remove(requestId).equals(null);
    }

    @Override
    public int size() {

        //return deadlineQueue.size();
        return deadlineMap.size();
    }

//    private static class Deadline {
//        private final long ID;
//        private final long deadlineMs;
//
//        private Deadline(long id, long deadlineMs) {
//            ID = id;
//            this.deadlineMs = deadlineMs;
//        }
//
//    }
}
