package uz.najot.order.receiver;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;
import uz.najot.order.service.OrderService;

@Component
@RequiredArgsConstructor
public class Receiver {
    private final OrderService orderService;
    @RabbitListener(queues = "order",containerFactory = "rabbitListenerContainerFactory")
    public void getMessage(String message, Channel channel){
        orderService.pay(message);
    }
}
