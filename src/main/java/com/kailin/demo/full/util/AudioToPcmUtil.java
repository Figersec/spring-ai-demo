package com.kailin.demo.full.util;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * 转成PCM音频文件
 *
 * @author 杨松
 */
public class AudioToPcmUtil {

    /**
     * 将WAV文件转换为PCM格式
     *
     * @param inputWavFile  输入的WAV文件
     * @param outputPcmFile 输出的PCM文件路径（可选）
     * @return 转换后的PCM字节数组
     */
    public static byte[] wavToPcm(File inputWavFile, File outputPcmFile) throws Exception {
        // 读取WAV文件
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(inputWavFile);
        AudioFormat audioFormat = audioInputStream.getFormat();

        // 设置目标格式为PCM（16位，单声道/立体声根据输入文件）
        AudioFormat targetFormat = new AudioFormat(
                AudioFormat.Encoding.PCM_SIGNED,
                audioFormat.getSampleRate(),
                16, // 16位深度
                audioFormat.getChannels(),
                audioFormat.getChannels() * 2, // 每帧字节数（通道数 × 位数/8）
                audioFormat.getSampleRate(),
                false // 是否大端序
        );

        // 转换音频流
        AudioInputStream pcmAudioInputStream = AudioSystem.getAudioInputStream(targetFormat, audioInputStream);

        // 读取PCM数据到字节数组
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = pcmAudioInputStream.read(buffer)) != -1) {
            byteArrayOutputStream.write(buffer, 0, bytesRead);
        }
        byte[] pcmData = byteArrayOutputStream.toByteArray();

        // 可选：保存为文件
        if (outputPcmFile != null) {
            try (FileOutputStream fos = new FileOutputStream(outputPcmFile)) {
                fos.write(pcmData);
            }
        }

        return pcmData;
    }

}
