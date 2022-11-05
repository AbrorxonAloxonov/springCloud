package com.example.history.receiver;

import com.example.history.service.HistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import com.rabbitmq.client.Channel;

@Component
@RequiredArgsConstructor
public class Receiver {
    private final HistoryService historyService;
    @RabbitListener(queues = "history", containerFactory = "rabbitListenerContainerFactory")
    public void getMessage(String message,Channel channel){
        historyService.saveHistory(message);
    }

}
