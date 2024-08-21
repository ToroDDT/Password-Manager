package dev.david.OnePassword.controller;

import dev.david.OnePassword.websocket.Greeting;
import dev.david.OnePassword.websocket.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.util.HtmlUtils;
import org.unbescape.html.HtmlEscape;

@Controller
public class MessageController {
    @MessageMapping("/messages")
    @SendTo("/tool/messaging")
    public Message messenger (Message message) throws Exception {
        Thread.sleep(1000);
        return new Message(HtmlUtils.htmlEscape(message.getMessage()), message.getUserId());
    }
    @GetMapping("tools/messenger")
    public String displayMessenger() {
        return "messenger";
    }
}
