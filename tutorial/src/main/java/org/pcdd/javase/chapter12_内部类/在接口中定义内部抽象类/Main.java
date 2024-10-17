package org.pcdd.javase.chapter12_内部类.在接口中定义内部抽象类;

interface IChannel2 {
    void send();

    abstract class AbstractMessage {
        abstract String getContent();
    }

}

class Channel2Impl implements IChannel2 {
    @Override
    public void send() {
        AbstractMessage msg = new MessageImpl();
        System.out.println(msg.getContent());
    }

    class MessageImpl extends AbstractMessage {
        @Override
        public String getContent() {
            return "pcdd.work";
        }
    }
}


public class Main {
    public static void main(String[] args) {
        IChannel2 channel2 = new Channel2Impl();
        channel2.send();
    }
}
