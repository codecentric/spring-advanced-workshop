package de.codecentric.app.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

// Lösung 1.4
@Slf4j
public class OutputHandler implements MessageHandler {

    @Override
    public void handleMessage(Message<?> message) throws MessagingException {
        log.info("Processed message: {}", message.getPayload());
    }

}
