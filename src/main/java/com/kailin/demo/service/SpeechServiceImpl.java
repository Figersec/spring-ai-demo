package com.kailin.demo.service;


import cn.hutool.http.HttpRequest;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.SignatureException;

/**
 * @author 杨松
 */
@Service
public class SpeechServiceImpl implements SpeechService {


    @Override
    public String speechToText() {
        String url = "https://obs-outbound.kailinjt.com/callRecording/20250418/1695005791393700040-5cb0b51c7a6b9f57c653622f05f4e0ce-1744965604365JAWzvq.mp3";

        return null;
    }


    public byte[] downloadUrlAsByteArray(String url) {
        String body = HttpRequest.get(url).execute().body();
        return body.getBytes(StandardCharsets.UTF_8);
    }

    public String downloadUrlAsString(String url) {
        return HttpRequest.get(url).execute().body();
    }

}
