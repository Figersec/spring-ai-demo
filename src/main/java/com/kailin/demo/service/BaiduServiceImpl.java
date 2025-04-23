package com.kailin.demo.service;


import cn.hutool.core.io.FileUtil;
import com.kailin.demo.full.connection.Runner;
import com.kailin.demo.full.util.AudioToPcmUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

/**
 * @author 杨松
 */
@Service
@Slf4j
public class BaiduServiceImpl implements BaiduService {

    private static final int MODE = Runner.MODE_REAL_TIME_STREAM;


    @Override
    public boolean speechToText(MultipartFile multipartFile) {
        String originalFilename = multipartFile.getOriginalFilename();
        try {
            File tempFile = File.createTempFile("input", ".wav");
            multipartFile.transferTo(tempFile);
            File pcmFile = new File(tempFile.getParentFile(), originalFilename + ".pcm");
            AudioToPcmUtil.executeFFmpeg(tempFile, pcmFile);
            FileUtil.del(tempFile);
            // 将文件通过websocket转发给百度
            InputStream inputStream;
            try {
                inputStream = new ByteArrayInputStream(Files.readAllBytes(pcmFile.toPath()));
                (new Runner(inputStream, MODE)).run();
            } catch (IOException ignored) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }


}
