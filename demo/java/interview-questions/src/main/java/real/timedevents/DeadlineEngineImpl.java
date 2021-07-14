package real.timedevents;

import java.util.function.Consumer;

public class DeadlineEngineImpl implements DeadlineEngine {
    @Override
    public long schedule(long deadlineMs) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean cancel(long requestId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int poll(long nowMs, Consumer<Long> handler, int maxPoll) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException();
    }
}
