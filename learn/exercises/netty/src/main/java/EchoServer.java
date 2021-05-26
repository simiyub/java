public class EchoServer {
    private static int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println(String.format("Usage: %s %s <%s>", EchoServer.class.getSimpleName(), port));
        }
    }
}
