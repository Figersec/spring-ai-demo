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

/**
 * @author 杨松
 */
@Service
@Slf4j
public class BaiduServiceImpl implements BaiduService {

    private static final int MODE = Runner.MODE_REAL_TIME_STREAM;


    @Override
    public boolean speechToText(MultipartFile multipartFile) {
        // 创建临时文件（自动添加扩展名）
        String tempName = "upload" + "." + getExtension(multipartFile.getOriginalFilename());
        File file = FileUtil.createTempFile(tempName, true);

        // 转换成pcm
        byte[] bytes;
        try {
            bytes = AudioToPcmUtil.wavToPcm(file, null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 将文件通过websocket转发给百度
        InputStream inputStream;
        try {
            inputStream = new ByteArrayInputStream(bytes);
            (new Runner(inputStream, MODE)).run();
        } catch (IOException ignored) {

        }
        FileUtil.del(file);
        return true;
    }


    /**
     * 获取文件扩展名（如".txt", ".jpg"）
     */
    private static String getExtension(String filename) {
        if (filename == null) {
            return "";
        }
        int lastDotIndex = filename.lastIndexOf('.');
        return (lastDotIndex == -1) ? "" : filename.substring(lastDotIndex);
    }
}
