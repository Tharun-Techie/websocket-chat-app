package com.tharun.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebsocketController {
    private final SimpMessagingTemplate messagingTemplate;


    @Autowired
    public WebsocketController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;

    }


    @MessageMapping("/message")
    public void handelMessage(Message message) {
        System.out.println("Received from user: " + message.getUser() + ":" + message.getMessage());
        messagingTemplate.convertAndSend("/topic/message", message);
        System.out.println("Sent message to /topic/message: " + message.getUser()+ ": "+message.getMessage());
    }
}
