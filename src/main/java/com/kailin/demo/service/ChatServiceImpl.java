package com.kailin.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 * @author 杨松
 */
@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {


    private final OpenAiChatModel chatModel;
    private final ChatClient client;
    private final ChatMemory chatMemory = new InMemoryChatMemory();


    @Autowired
    public ChatServiceImpl(ChatClient.Builder client, OpenAiChatModel chatModel) {
        this.client = client.build();
        this.chatModel = chatModel;
    }

    @Override
    public String chat(String message, String userId) {
        return this.client.prompt()
                .user(message)
                .advisors(new MessageChatMemoryAdvisor(chatMemory, userId, 10))
                .call()
                .content();
    }

    @Override
    public Flux<ChatResponse> chatFlux(String message) {
        Prompt prompt = new Prompt(new UserMessage(message));
        return this.chatModel.stream(prompt);
    }

}
