package com.kailin.demo.service;

import org.springframework.ai.chat.model.ChatResponse;
import reactor.core.publisher.Flux;

/**
 * @author 杨松
 */
public interface ChatService {

    /**
     * DeepSeek聊天普通接口
     *
     * @param message
     * @return
     */
    String chat(String message, String userId);

    /**
     * DeepSeek流式聊天接口
     *
     * @param message
     * @return
     */
    Flux<ChatResponse> chatFlux(String message);


}
