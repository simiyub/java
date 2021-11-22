import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class TimeServerHandler  extends ChannelInboundHandlerAdapter {

    /*
    * channelActive is invoked when a connection is established
    * and ready to generate traffic
    * */
    @Override
    public void channelActive(final ChannelHandlerContext context){

        //To send a new message, we need to allocate a new buffer which contains the message
        //This is a 32 bit integer, so we need a buffer that is at least 4 bytes.
        //We get the current ByteBuffAllocator via the context alloc and allocate the buffer
//        final ByteBuf time = context.alloc().buffer(4);
//
//        //ByteBuf has two pointers: one for read and another for write operations
//        time.writeInt((int) (System.currentTimeMillis()/1000L +220898800L));
//
//        //The write and write and flush return a channel future
//        // which represents an IO operation which has not occurred
//        //The requested operation may not have occurred because all operations are asynchronous in Netty
//        // so we close the connection only after the channel future is complete
//        final ChannelFuture future = context.writeAndFlush(time);
//
//        //The channel future listener is added to notify us when when the write request is finished.
//        future.addListener(new ChannelFutureListener() {
//            @Override
//            public void operationComplete(ChannelFuture f) throws Exception {
//
//                //we close the connection only after
//                // the channel future is complete from the write and flush operation
//                //And the close might not close the connection immediately
//                assert future == f;
//                context.close();
//            }
//        });

        //Refactored to use UnixTime

        //final ChannelFuture  future = context.writeAndFlush(new UnixTime());
        //future.addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext context, Throwable cause){
        cause.printStackTrace();
        context.close();
    }
}
