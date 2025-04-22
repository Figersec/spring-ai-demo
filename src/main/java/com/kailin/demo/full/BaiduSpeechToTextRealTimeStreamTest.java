package com.kailin.demo.full;


import com.kailin.demo.full.connection.Runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 百度语音实时识别测试
 *
 * @author 杨松
 */
public class BaiduSpeechToTextRealTimeStreamTest {

    public static final String FILENAME = "16k-0.pcm";

    /**
     * MODE_FILE_STREAM为非实时流，如文件流，数据已经完整地在流中
     * MODE_SIMULATE_REAL_TIME_STREAM 为非实时流，用来生成模拟实时流
     */
    private static final int MODE = Runner.MODE_REAL_TIME_STREAM;  // 或 MODE_SIMULATE_REAL_TIME_STREAM
    private static Logger logger = Logger.getLogger("Main");

    public static void main(String[] args) {
//        String accessToken = "";
//        try {
//            accessToken = BaiduAuthUtil.getAccessToken();
//        } catch (Exception e) {
//            logger.log(Level.INFO, "获取accessToken失败", e);
//        }
        String filename = FILENAME;
        if (args.length >= 1) {
            filename = args[0];
        }
        Locale.setDefault(Locale.ENGLISH);
        File file = new File(filename);
        InputStream inputStream;
        try {
            inputStream = new FileInputStream(file);
            logger.info("file total size: " + inputStream.available());
            (new Runner(inputStream, MODE)).run();
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
