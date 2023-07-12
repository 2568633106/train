package cn.itcast.mq.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class SpringRabbitLitener {
//        @RabbitListener(queues = "simple.queue")  //监听的队列名称
//        //发送的什么类型，就用什么类型的参数接受
//        public void listenSimpleQueueMessage(String msg) throws InterruptedException {
//            System.out.println("spring 消费者接收到消息 ：【" + msg + "】");
//    }

    @RabbitListener(queues = "simple.queue")
    public void listenSimpleQueueMessage(String msg) throws InterruptedException {
        System.out.println("spring 消费者1接收到消息：【" + msg + "】");
        Thread.sleep(25);
    }

    @RabbitListener(queues = "simple.queue")
    public void listenSimpleQueueMessage2(String msg) throws InterruptedException {
            System.err.println("spring 消费者2接收到消息：【" + msg + "】");
            Thread.sleep(100);
    }




    @RabbitListener(queues = "fanout.queue1")
    public void listenFanoutQueue1(String msg) {
        System.out.println("消费者1接收到Fanout消息：【" + msg + "】");
    }

    @RabbitListener(queues = "fanout.queue2")
    public void listenFanoutQueue2(String msg) {
        System.out.println("消费者2接收到Fanout消息：【" + msg + "】");
    }


}
