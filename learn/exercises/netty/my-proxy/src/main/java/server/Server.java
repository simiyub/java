package server;

import clients.ClientSubscriptionServerInitializer;
import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.SelfSignedCertificate;

import javax.net.ssl.SSLException;
import java.net.InetSocketAddress;
import java.security.cert.CertificateException;

/**
 * Manages connection requests from clients
 * ----------------------------------------
 *  1. Receive handshake request
 *  2. Set up connection with B2C2
 *  3. Reject connection request if cannot connect to B2C2
 *  4. Accept connection with client
 *  5. Set up client:instrument mapping when connected to client to manage and track instrument for client
 *  6. Set up instrument: client mapping on connection to B2C2 to track updates to client when we receive quote.
 *
 *  Tests
 *   - Can connect to client
 *   - Can reject request from client
 *   - Can connect to B2C2
 *   - Can set up client: instrument mapping
 *   - Can set up instrument : client mapping
 *
 *   Manages quotes received from B2C2
 *   ---------------------------------
 *   1. Receive quote
 *   2. Store quote??
 *   3. Add markup on quote??
 *   4. Look up client for instrument
 *   5. Send quote to client
 *
 *   Tests
 *    - Can accept quote
 *    - Can match quote to mapping
 *    - Can send quote to client
 *
 *   Manages unsubscribe requests from client
 *   ----------------------------------------
 *   1. Remove from Instrument-Client mapping
 *   2. If the only client in mapping, remove mapping
 *   3. Disconnect from B2C2 for CCY
 *
 *   Tests
 *   - Can remove client from mapping
 *   - Can remove mapping
 *   - Can disconnect from B2C2
 *
 * --> More in B2C2 Readme
 * */

public class Server {
    static final boolean SSL = System.getProperty("ssl") !=null ;
    private static final int PORT = Integer.parseInt(System.getProperty("port", SSL? "8443":"8080"));

    public static void main(String[] args){
        Server server = new Server();
       // server.init();

    }

//    private void init2() {
//
//        try {
//            final SslContext sslContext;
//            SelfSignedCertificate selfSignedCertificate = null;
//            if (SSL) {
//
//
//                selfSignedCertificate = new SelfSignedCertificate();
//
//                sslContext = SslContextBuilder.
//                        forServer(selfSignedCertificate.certificate(), selfSignedCertificate.privateKey())
//                        .build();
//            }
//            else{
//                sslContext = null;
//            }
//
//            ServerBootstrap bootstrap = new ServerBootstrap();
//            bootstrap.group(new NioEventLoopGroup(), new NioEventLoopGroup())
//                    .channel(NioServerSocketChannel.class)
//                    .childHandler(
//                            new SimpleChannelInboundHandler<ByteBuf>() {
//                                ChannelFuture connectFuture;
//
//                                //@Override
//                                protected void channelActive(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
//                                    Bootstrap remoteBootstrap = new Bootstrap();
//                                    remoteBootstrap.channel(NioSocketChannel.class).handler(
//                                            new SimpleChannelInboundHandler<ByteBuf>() {
//
//                                                @Override
//                                                protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
//                                                    System.out.println("Received data");
//                                                }
//                                            }
//                                    );
//                                    remoteBootstrap.group(channelHandlerContext.channel().eventLoop());
//                                    connectFuture = remoteBootstrap.connect(new InetSocketAddress("wss://socket.uat.b2c2.net/quotes", 80));
//                                }
//
//                                @Override
//                                protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
//                                    if (connectFuture.isDone()) {
//                                        System.out.println("done");
//                                    }
//                                }
//                            });
//                                ChannelFuture future = bootstrap.bind(new InetSocketAddress(8080));
//                                future.addListener(new ChannelFutureListener() {
//                                    @Override
//                                    public void operationComplete(ChannelFuture channelFuture) throws Exception {
//                                        if(channelFuture.isSuccess()){
//                                            System.out.println("server bound");
//                                    }
//                                        else{
//                                            System.out.println("bind failed");
//                                            channelFuture.cause().printStackTrace();
//                                        }
//                                }}
//                                );
//
//
//        } catch (CertificateException e) {
//            e.printStackTrace();
//        } catch (SSLException e) {
//            e.printStackTrace();
//        }
//    }

//    private void init() {
//
//        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
//        EventLoopGroup workerGroup = new NioEventLoopGroup();
//
//        try {
//            final SslContext sslContext;
//            if (SSL) {
//                SelfSignedCertificate selfSignedCertificate = new SelfSignedCertificate();
//                sslContext = SslContextBuilder.
//                        forServer(selfSignedCertificate.certificate(), selfSignedCertificate.privateKey())
//                        .build();
//            } else {
//                sslContext = null;
//            }
//
//            ServerBootstrap server = new ServerBootstrap();
//            server.group(bossGroup, workerGroup)
//                    .channel(NioServerSocketChannel.class)
//                    .childHandler(new ClientSubscriptionServerInitializer(sslContext));
//
//            Channel channel = server.bind(PORT).c.sync().channel();
//
//            channel.closeFuture().sync();
//            channel.eventLoop().sc
//        } catch (CertificateException | InterruptedException | SSLException e) {
//            e.printStackTrace();
//        } finally {
//            bossGroup.shutdownGracefully();
//            workerGroup.shutdownGracefully();
//        }
//
//
//    }



    private void init3() {

        try {
            final SslContext sslContext;
            SelfSignedCertificate selfSignedCertificate = null;
            if (SSL) {


                selfSignedCertificate = new SelfSignedCertificate();

                sslContext = SslContextBuilder.
                        forServer(selfSignedCertificate.certificate(), selfSignedCertificate.privateKey())
                        .build();
            }
            else{
                sslContext = null;
            }

            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(new NioEventLoopGroup(), new NioEventLoopGroup())
                    .channel(NioServerSocketChannel.class)
                    .childHandler(
                            new SimpleChannelInboundHandler<ByteBuf>() {
                                ChannelFuture connectFuture;

                                //@Override
                                protected void channelActive(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
                                    Bootstrap remoteBootstrap = new Bootstrap();
                                    remoteBootstrap.channel(NioSocketChannel.class).handler(
                                            new SimpleChannelInboundHandler<ByteBuf>() {

                                                @Override
                                                protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
                                                    System.out.println("Received data");
                                                }
                                            }
                                    );
                                    remoteBootstrap.group(channelHandlerContext.channel().eventLoop());
                                    connectFuture = remoteBootstrap.connect(new InetSocketAddress("wss://socket.uat.b2c2.net/quotes", 80));
                                }

                                @Override
                                protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
                                    if (connectFuture.isDone()) {
                                        System.out.println("connection future done");
                                    }
                                }
                            });
            ChannelFuture future = bootstrap.bind(new InetSocketAddress(8080));
            future.addListener((ChannelFutureListener) channelFuture -> {
                if(channelFuture.isSuccess()){
                    System.out.println("server bound");
                    channelFuture.channel().writeAndFlush("test");
                }
                else{
                    System.out.println("bind failed");
                    channelFuture.cause().printStackTrace();
                }
            }
            );


        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (SSLException e) {
            e.printStackTrace();
        }
    }

}
