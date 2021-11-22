import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;


/**
 * DiscardServerHandler extends ChannelInboundHandlerAdapter, which is an implementation of ChannelInboundHandler.
 * ChannelInboundHandler provides various event handler methods that you can override.
 * */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

    /**Same config as echo server handler, just discards the message.
     * We override the channelRead() event handler method here.
     * This method is called with the received message, whenever new data is received from a client
     * ByteBuf is a reference-counted object which has to be released explicitly via the release() method.
     * Please keep in mind that it is the handler's responsibility to release any reference-counted object passed to the handler.
     * */
    @Override
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object message){
        ByteBuf in = (ByteBuf) message;
        try{
            if (in.isReadable()){
                System.out.println(in.toString(io.netty.util.CharsetUtil.US_ASCII));
                System.out.flush();
            }

        }
        finally {
            ReferenceCountUtil.release(message);
        }
    }

    /**
     * The exceptionCaught() event handler method is called with a Throwable
     * when an exception was raised by Netty due to an I/O error or by a handler implementation
     * due to the exception thrown while processing events.
     * In most cases, the caught exception should be logged and
     * its associated channel should be closed here,
     * although the implementation of this method can be different depending on
     * what you want to do to deal with an exceptional situation.
     * For example, you might want to send a response message with an error code
     * before closing the connection.
     * */
    @Override
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable cause){
        cause.printStackTrace();
        channelHandlerContext.close();
    }
}
