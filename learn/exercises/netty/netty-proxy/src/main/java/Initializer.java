import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

public class Initializer extends ChannelInitializer<SocketChannel> {

        private final String remoteHost;
        private final int remotePort;

        public Initializer(String remoteHost, int remotePort) {
            this.remoteHost = remoteHost;
            this.remotePort = remotePort;
        }

        @Override
        public void initChannel(SocketChannel ch) {
            ch.pipeline().addLast(
                    new LoggingHandler(LogLevel.INFO),
                    new FrontendHandler(remoteHost, remotePort));
        }
}
