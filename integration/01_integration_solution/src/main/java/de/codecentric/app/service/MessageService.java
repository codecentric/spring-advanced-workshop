package de.codecentric.app.service;

import org.springframework.stereotype.Service;


@Service
public class MessageService {

    // Lösung 1.2
    public String processMessage(String message) {
        return message.toUpperCase();
    }
}
