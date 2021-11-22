import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;


/**|Same config as Discard server handler except echos message back
 * DiscardServerHandler extends ChannelInboundHandlerAdapter, which is an implementation of ChannelInboundHandler.
 * ChannelInboundHandler provides various event handler methods that you can override.
 * */
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * We override the channelRead() event handler method here.
     * This method is called with the received message, whenever new data is received from a client
     * ByteBuf is a reference-counted object which has to be released explicitly via the release() method.
     * Please keep in mind that it is the handler's responsibility to release any reference-counted object passed to the handler.
     * */
    @Override
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object message){
        ByteBuf in = (ByteBuf) message;

        /*
        1) Here, we invoke write(Object) to write the received message in verbatim.
        Please note that we did not release the received message unlike we did in the DISCARD example.
        It is because Netty releases it for you when it is written out to the wire.

        2) The message written out to the wire. It is buffered internally and
        then flushed out to the wire by ctx.flush(). Alternatively,
        you could call ctx.writeAndFlush(msg) for brevity.
         */

            if (in.isReadable()){
                byte[] req = new byte[in.readableBytes()];
                in.readBytes(req);
                String body = new String(req, CharsetUtil.UTF_8)    ;
                System.out.println("Echo server:"+body);
                channelHandlerContext.write(message+"echo.");//1
                channelHandlerContext.flush(); //2
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
