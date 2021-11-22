package real.timedevents;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.*;
import java.util.function.Consumer;

import static java.util.stream.Collectors.*;


/**
 * One map for id: deadlines populated on schedule
 *  and deadline events removed through poll
 *  cancel and size available too.
 * */
 class DeadlineEngineImpl implements DeadlineEngine {

    private final ConcurrentMap<Long,Long> deadlineMap = new ConcurrentHashMap<>();


    @Override
    public long schedule(long deadlineMs) {
        long id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        try {
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

            ConcurrentMap<Long, Long> toProcess = deadlineMap.entrySet().stream()
                    .filter(entry -> nowMs > entry.getValue())
                    .limit(maxPoll)
                    .collect(toConcurrentMap(Map.Entry::getKey, Map.Entry::getValue));

            toProcessCount = toProcess.size();
            System.out.println(toProcessCount + " deadlines identified.");

            toProcess.entrySet().forEach(item -> deadlineHandler(item, handler));
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
        return toProcessCount;
    }

    private void deadlineHandler(Map.Entry<Long,Long> entry,Consumer<Long> handler){

        handler.accept(entry.getKey());

        deadlineMap.remove(entry.getKey(), entry.getValue());
    }

    @Override
    public boolean cancel(long requestId) {

        //return deadlineQueue.remove(requestId);
        return deadlineMap.remove(requestId, deadlineMap.get(requestId));
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
