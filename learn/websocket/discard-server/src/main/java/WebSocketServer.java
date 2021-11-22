import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class WebSocketServer {

    private final int port;

    public WebSocketServer(int port) {
        this.port = port;
    }

    public static void main(String[] args) throws Exception {
        int port = 8080;
        if(args.length > 0){
            port = Integer.parseInt(args[0]);
                    }
        new WebSocketServer(port).run();
    }

    public void run() throws Exception{

        /*
         * NioEventLoopGroup is a multithreaded event loop that handles I/O operation.
         * Netty provides various EventLoopGroup implementations for different kind of transports.
         * We are implementing a server-side application in this example, and therefore two NioEventLoopGroup
         * will be used. The first one, often called 'boss', accepts an incoming connection.
         * The second one, often called 'worker', handles the traffic of the accepted connection once the boss
         * accepts the connection and registers the accepted connection to the worker.
         * How many Threads are used and how they are mapped to the created Channels depends on the
         * EventLoopGroup implementation and may be even configurable via a constructor.
         * */
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {

            /*
             * ServerBootstrap is a helper class that sets up a server.
             * */
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup,workerGroup)

                    //We specify to use the NioServerSocketChannel class which is used to instantiate a
                    // new Channel to accept incoming connections.
                    .channel(NioServerSocketChannel.class)

                    //The handler specified here will always be evaluated by a newly accepted Channel.
                    // The ChannelInitializer is a special handler that is purposed to help a user
                    // configure a new Channel. It is most likely that you want to configure the
                    // ChannelPipeline of the new Channel by adding some handlers such as
                    // DiscardServerHandler to implement your network application.
                    // As the application gets complicated, it is likely that you will add more
                    // handlers to the pipeline and extract this anonymous class into a top-level
                    // class eventually.
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        protected void initChannel(SocketChannel ch) throws Exception {
                           // ch.pipeline().addLast(new DiscardServerHandler());
                            ch.pipeline().addLast(new EchoServerHandler());
                           // ch.pipeline().addLast(new TimeEncoder(),new TimeServerHandler());
                        }
                    })

                    //You can also set the parameters which are specific to the Channel implementation.
                    // We are writing a TCP/IP server, so we are allowed to set the socket options
                    // such as tcpNoDelay and keepAlive.
                    // Please refer to the apidocs of ChannelOption and the specific ChannelConfig
                    // implementations to get an overview about the supported ChannelOptions.

                    //option() is for the NioServerSocketChannel that accepts incoming connections.
                    // childOption() is for the Channels accepted by the parent ServerChannel,
                    // which is NioSocketChannel in this case.

                    //The parameters that we set using ServerBootStrap.option apply to the ChannelConfig
                    // of a newly created ServerChannel, i.e., the server socket which listens for and
                    // accepts the client connections. These options will be set on the Server Channel when
                    // bind() or connect() method is called. This channel is one per server.
                    //
                    //And the ServerBootStrap.childOption applies to to a channel's channelConfig which
                    // gets created once the serverChannel accepts a client connection.
                    // This channel is per client (or per client socket).
                    //
                    //So ServerBootStrap.option parameters apply to the server socket (Server channel)
                    // that is listening for connections and ServerBootStrap.childOption parameters apply
                    // to the socket that gets created once the connection is accepted by the server socket.
                    //
                    //The same can be extended to attr vs childAttr and handler vs childHandler methods in the
                    // ServerBootstrap class.
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);

            //We are ready to go now.
            // What's left is to bind to the port and to start the server.
            // Here, we bind to the port 8080 of all NICs (network interface cards) in the machine.
            // You can now call the bind() method as many times as you want (with different bind addresses.)
            ChannelFuture future = bootstrap.bind(port).sync();

            // Wait until the server socket is closed.
            // In this example, this does not happen, but you can do that to gracefully
            // shut down your server.
            future.channel().closeFuture().sync();

        }
        finally {

            ///Shutting down a Netty application is usually as simple as shutting down all
            // EventLoopGroups you created via shutdownGracefully().
            // It returns a Future that notifies you when the EventLoopGroup
            // has been terminated completely and all Channels that belong to the group have been closed.

            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }

    }

}
