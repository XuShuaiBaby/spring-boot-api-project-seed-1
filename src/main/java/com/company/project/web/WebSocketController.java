package com.company.project.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat-room")
public class WebSocketController {

    @GetMapping("/chatroom")
    public String chatroom() {
        return "index";
    }

}
