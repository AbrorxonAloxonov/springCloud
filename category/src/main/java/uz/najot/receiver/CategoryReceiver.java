//package uz.najot.receiver;
//
//import com.rabbitmq.client.Channel;
//import lombok.RequiredArgsConstructor;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.amqp.support.AmqpHeaders;
//import org.springframework.messaging.handler.annotation.Header;
//import org.springframework.stereotype.Component;
//
//@Component
//@RequiredArgsConstructor
//public class CategoryReceiver {
//    @RabbitListener(queues = "category",containerFactory = "prefetchTenRabbitListenerContainerFactory")
//    public void getMessage(String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws Exception {
//        System.out.println(message);
//    }
//}
