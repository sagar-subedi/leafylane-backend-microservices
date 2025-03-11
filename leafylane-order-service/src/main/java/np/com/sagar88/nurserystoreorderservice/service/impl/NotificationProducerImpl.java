package np.com.sagar88.leafylaneorderservice.service.impl;

import np.com.sagar88.leafylaneorderservice.service.NotificationService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NotificationProducerImpl implements NotificationService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.queue.name}")
    private String queueName;

    public void sendNotification(String message) {
        rabbitTemplate.convertAndSend(queueName, message);
        System.out.println("Sent message: " + message);
    }
}
