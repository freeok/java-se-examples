package org.pcdd.javase.chapter12_内部类.定义内部接口;

/**
 * 定义内部接口
 */
interface IChannel {
    void send(IMessage msg);

    interface IMessage {
        String getContent();
    }
}

class ChannelImpl implements IChannel {
    @Override
    public void send(IMessage msg) {
        System.out.println(msg.getContent());
    }

    class MessageImpl implements IMessage {
        @Override
        public String getContent() {
            return "pcdd.work";
        }
    }
}

public class Main {
    public static void main(String[] args) {
        IChannel channel = new ChannelImpl();
        // IChannel.IMessage message = new ChannelImpl().new MessageImpl();
        channel.send(new ChannelImpl().new MessageImpl());

    }
}
