package com.kailin.demo.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author 杨松
 */
public interface BaiduService {

    /**
     * 百度实时语音转文字识别 websocket api
     * @param file
     * @return
     */
    boolean speechToText(MultipartFile file);


}
