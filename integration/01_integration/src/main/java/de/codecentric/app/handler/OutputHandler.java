package de.codecentric.app.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessagingException;

// TODO
@Slf4j
public class OutputHandler {

    public void handleMessage(Message<?> message) throws MessagingException {
        log.info("Processed message: {}", message.getPayload());
    }

}
