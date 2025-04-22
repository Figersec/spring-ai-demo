package com.kailin.demo.controller;

import com.kailin.demo.service.ChatService;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @author 杨松
 */
@RestController
@RequestMapping("/chat")
public class ChatController {


    @Autowired
    private ChatService chatService;

    /**
     * 聊天接口
     *
     * @param message
     * @return
     */
    @GetMapping("/chat")
    public String generate(@RequestParam(value = "message") String message, @RequestParam(value = "userId") String userId) {
        return chatService.chat(message, userId);
    }

    /**
     * 流式聊天接口
     *
     * @param message
     * @return
     */
    @GetMapping("/chatFlux")
    public Flux<ChatResponse> chatFlux(@RequestParam(value = "message", defaultValue = "hello") String message) {
        return chatService.chatFlux(message);
    }


}