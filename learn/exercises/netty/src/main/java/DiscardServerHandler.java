import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * Called with the new message whenever new data is received.
     * Because it is a discard server, we ignore the data received and release the Bytebuf Object
     * **/
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg){
        ByteBuf in = (ByteBuf) msg;
        try{
         while(in.isReadable()){
             System.out.print((char) in.readByte());
             System.out.flush();
         }

         /*
         * A ChannelHandlerContext object provides various operations that enable you to trigger various
         * I/O events and operations. Here, we invoke write(Object) to write the received message in verbatim.
         *  Please note that we did not release the received message unlike we did in the DISCARD example.
         *  It is because Netty releases it for you when it is written out to the wire.
         * */
         ctx.write("received:"+msg);

         /*
         ctx.write(Object) does not make the message written out to the wire.
         It is buffered internally and then flushed out to the wire by ctx.flush().
         Alternatively, you could call ctx.writeAndFlush(msg) for brevity.
         * **/
         ctx.flush();
        }
        finally {
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){
        cause.printStackTrace();
        ctx.close();

    }
}
