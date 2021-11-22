import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

public class TimeEncoder extends ChannelOutboundHandlerAdapter {

    @Override
    public void write(ChannelHandlerContext channelHandlerContext, Object message, ChannelPromise channelPromise){
        UnixTime m = (UnixTime)message;
        ByteBuf encoded = channelHandlerContext.alloc().buffer(4);
        encoded.writeInt((int)m.value());
        channelHandlerContext.write(encoded, channelPromise);


    }

}
