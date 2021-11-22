import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class TimeClient {
    public static void main(String[] args) throws Exception {
        String host = "localhost";
        int port = 8080;
        if(args.length>0){
            host = args[0];
            port = Integer.parseInt(args[1]);
        }

        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try{
            //Bootstrap is similar to the ServerBootstrap
            // except that it's for non-server channels
            // such as client side or connectionless channels
            Bootstrap clientBootstrap = new Bootstrap();

            //If you specify one EventLoopGroup,
            // it will be used both as the boss group and worker group.
            // The boss group is not used for the client though.
            clientBootstrap.group(workerGroup);

            //NioSocketChannel is used to create a client side
            // channel instead of NioServerSocketChannel
            clientBootstrap.channel(NioSocketChannel.class);

            //We do not use the childoptions
            // because SocketChannel does not have children
            clientBootstrap.option(ChannelOption.SO_KEEPALIVE,true);
            clientBootstrap.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new TimeDecoder(), new TimeClientHandler());
                    }
            });

            ChannelFuture future = clientBootstrap.connect(host, port).sync();
            future.channel().closeFuture().sync();


        }
        finally {
            workerGroup.shutdownGracefully();
        }

    }
}
