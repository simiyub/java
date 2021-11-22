import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

public class Client {

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap  bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .handler(new SimpleChannelInboundHandler<ByteBuf>() {

                    @Override
                    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
                        String message = ((ByteBuf) msg).toString();
                        System.out.println("Received from server:"+message);
                    }
                });

        ChannelFuture channelFuture = bootstrap.connect(
                new InetSocketAddress("127.0.0.1",8082));

        channelFuture.addListener(new ChannelFutureListener() {
                    @Override
                    public void operationComplete(ChannelFuture future) throws Exception {
                        if(channelFuture.isSuccess()){
                            System.out.println("Connection established");
                        }
                        else{
                            System.err.println("Connection attempt failed.");
                            channelFuture.cause().printStackTrace();
                        }
                    }
                });

        channelFuture.channel().writeAndFlush("Hello");


    }
}
