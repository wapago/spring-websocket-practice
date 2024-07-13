package com.github.springwebsocketpractice;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        System.out.println("message.getName() = " + message.getName());

        Thread.sleep(500); // simulated delay 0.5seconds

        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()));
    }
}
