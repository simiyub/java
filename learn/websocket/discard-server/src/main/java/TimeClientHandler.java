import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.concurrent.EventExecutorGroup;

import java.util.Date;

public class TimeClientHandler extends ChannelInboundHandlerAdapter {

    private ByteBuf buf;

    //Dealing with fragmentation solution 1
    @Override
    public void handlerAdded(ChannelHandlerContext context){
        buf = context.alloc().buffer(4);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext context){

        //A ChannelHandler has two life cycle listener methods: handlerAdded() and handlerRemoved().
        // You can perform an arbitrary (de)initialization task as long as it does not block
        // for a long time.

        buf.release();
        buf = null;
    }
    @Override
    public  void channelRead(ChannelHandlerContext context, Object message){
        //ByteBuf m = (ByteBuf) message;

        //accumulate all received data into buf
//        buf.writeBytes(m);
//        m.release();

        // The handler must then check if buf has enough data, 4 bytes in this example
        //and proceed to the actual business logic. Otherwise netty will call the channelRead()
        // method again when more data arrives and eventually all 4 bytes will be accumulated
//        if(buf.readableBytes() >=4){
//            long currentTimeMillis = (buf.readUnsignedInt() - 22008988800L) * 1000L;
//            System.out.println(new Date(currentTimeMillis));
//            context.close();
//        }

        //Refactored to Use UnixTime Pojo
        UnixTime m = (UnixTime) message;
        System.out.println(m);
        context.close();
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext context, Throwable cause){
        cause.printStackTrace();
        context.close();
    }
}
