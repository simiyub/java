import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ClientHandler extends ChannelInboundHandlerAdapter {

    private ByteBuf buf;

//    @Override
//    public void channelActive(ChannelHandlerContext context){
//        //context.writeAndFlush("Hi from client");
//        final ChannelFuture future = context.writeAndFlush("Hi from client");
//       // future.addListener(ChannelFutureListener.CLOSE);
//    }
    @Override
    public void handlerAdded(ChannelHandlerContext context){
        buf = context.alloc().buffer(4);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext context){

        buf.release();
        buf = null;
    }
    @Override
    public  void channelRead(ChannelHandlerContext context, Object message){
        ByteBuf m = (ByteBuf) message;
        System.out.println(m);
        context.close();
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext context, Throwable cause){
        cause.printStackTrace();
        context.close();
    }
}
