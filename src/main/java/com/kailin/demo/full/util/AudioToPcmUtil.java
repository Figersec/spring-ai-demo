package com.kailin.demo.full.util;

import java.io.File;

/**
 * 转成PCM音频文件
 *
 * @author 杨松
 */
public class AudioToPcmUtil {

    public static void executeFFmpeg(File input, File output) throws Exception {
        String[] command = {
                "D:\\software\\ffmpeg\\bin\\ffmpeg.exe",
                "-y",
                "-i", input.getAbsolutePath(),
                "-acodec", "pcm_s16le",
                "-f", "s16le",
                "-ar", "16000",
                "-ac", "1",
                output.getAbsolutePath()
        };
        Process process = new ProcessBuilder(command).start();
        if (process.waitFor() != 0) {
            throw new RuntimeException("FFmpeg执行失败");
        }
    }


}
