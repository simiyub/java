import clients.ClientSubscriptionServerInitializer;
import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import util.Util;

import java.net.InetSocketAddress;

public final class Server {




    public static void main(String[] args) throws Exception {
        //init();
        startServer();
    }

    private static void startServer() throws InterruptedException {
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(new NioEventLoopGroup(), new NioEventLoopGroup())
                .channel(NioServerSocketChannel.class)
                .handler(new LoggingHandler(LogLevel.INFO))
                //.childHandler(new ClientSubscriptionServerInitializer())
                .childOption(ChannelOption.AUTO_READ, false)
             //   .childHandler(new ClientSubscriptionServerInitializer())
//                .childHandler(
//                        new SimpleChannelInboundHandler<WebSocketFrame>() {
//                            ChannelFuture channelFuture;
//
//                            @Override
//                            public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception{
//                                Bootstrap remoteBootstrap = new Bootstrap();
//                                remoteBootstrap.channel(NioSocketChannel.class).handler(
//                                        new SimpleChannelInboundHandler<WebSocketFrame>() {
//                                            @Override
//                                            protected void channelRead0(ChannelHandlerContext ctx, WebSocketFrame msg) throws Exception {
//                                                System.out.println("Received data from remote server.");
//                                            }
//                                        }
//                                );
//                                remoteBootstrap.group(channelHandlerContext.channel().eventLoop());
//                                channelFuture = remoteBootstrap.bind(new InetSocketAddress(Util.getRemoteURI().getHost(),Util.getRemoteURI().getPort()));
//                            }
//
//                            @Override
//                            protected void channelRead0(ChannelHandlerContext ctx, WebSocketFrame msg) throws Exception {
//                                if(channelFuture.isDone()) System.out.println("Channel read is done.");
//
//                            }
//
//                        }
                .bind(Util.getLocalPort()).sync().channel().closeFuture().sync();

        ChannelFuture future = bootstrap.bind(Util.getLocalPort()).channel().closeFuture();
        future.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                if(future.isSuccess()) System.out.println("Bound.");
                else {
                    future.cause().printStackTrace();
                    System.out.println("Bind attempt failed.");
                }
            }
        });
    }

//    private static void init(){
//        System.err.println("Proxying *:" + Util.getLocalPort() + " to " + Util.getRemoteURI().getHost() + ':' + Util.getRemoteURI().getPort() + " ...");
//
//        // Configure the bootstrap.
//        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
//        EventLoopGroup workerGroup = new NioEventLoopGroup();
//        try {
//            new ServerBootstrap().group(bossGroup, workerGroup)
//                    .channel(NioServerSocketChannel.class)
//                    .handler(new LoggingHandler(LogLevel.INFO))
//                    .childHandler(new ClientSubscriptionServerInitializer())
//                    .childOption(ChannelOption.AUTO_READ, false)
//                    .bind(Util.getLocalPort()).sync().channel().closeFuture().sync();
//        }
//        catch(InterruptedException exception){
//            exception.printStackTrace();
//        }
//            finally
//         {
//            bossGroup.shutdownGracefully();
//            workerGroup.shutdownGracefully();
//        }
//    }

}
