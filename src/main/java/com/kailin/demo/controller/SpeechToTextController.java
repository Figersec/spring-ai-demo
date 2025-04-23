package com.kailin.demo.controller;

import com.kailin.demo.service.BaiduService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/speech")
public class SpeechToTextController {


    @Autowired
    private BaiduService baiduSpeechService;

    /**
     * 实时流式语音转文字
     *
     * @param file
     * @return
     */
    @PostMapping("/realTimeStreamSpeechToText")
    public Boolean realTimeStreamSpeechToText(@RequestParam("file") MultipartFile audio) {
        return baiduSpeechService.speechToText(audio);
    }

}




