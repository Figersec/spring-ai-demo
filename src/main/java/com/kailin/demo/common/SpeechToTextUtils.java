//package com.kailin.demo.common;
//
//import com.google.cloud.speech.v1.*;
//import com.google.protobuf.ByteString;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.util.EntityUtils;
//
//import java.io.IOException;
//import java.util.List;
//
///**
// * @author 杨松
// */
//public class SpeechToTextUtils {
//
//    public static String speechToText(String filePath) throws IOException {
//        // 读取音频文件
////        Path audioPath = Paths.get("path/to/audio/file.wav");
////        byte[] audioData = Files.readAllBytes(audioPath);
//        byte[] audioData = new byte[0];
//
//        try {
//            audioData = downloadUrlAsByteArray("https://obs-outbound.kailinjt.com/callRecording/20250418/1695005791393700040-5cb0b51c7a6b9f57c653622f05f4e0ce-1744965604365JAWzvq.mp3");
//        } catch (Exception e) {
//            System.out.println("e = " + e);
//        }
//        // 创建SpeechClient
//        try (SpeechClient speechClient = SpeechClient.create()) {
//            // 构建RecognitionAudio对象
//            RecognitionAudio recognitionAudio = RecognitionAudio.newBuilder()
//                    .setContent(ByteString.copyFrom(audioData))
//                    .build();
//
//            // 构建RecognitionConfig对象
//            RecognitionConfig recognitionConfig = RecognitionConfig.newBuilder()
//                    .setEncoding(RecognitionConfig.AudioEncoding.LINEAR16)
//                    .setSampleRateHertz(16000)
//                    .setLanguageCode("en-US")
//                    .setUseEnhanced(true)
//                    .setModel("default")
//                    .setEnableAutomaticPunctuation(true)
//                    .setEnableWordTimeOffsets(true)
//                    .setEnableWordConfidence(true)
//                    .build();
//
//            // 构建RecognizeRequest对象
//            RecognizeRequest recognizeRequest = RecognizeRequest.newBuilder()
//                    .setAudio(recognitionAudio)
//                    .setConfig(recognitionConfig)
//                    .build();
//
//            // 发送RecognizeRequest请求
//            RecognizeResponse recognizeResponse = speechClient.recognize(recognizeRequest);
//
//            // 处理RecognizeResponse结果
//            List<SpeechRecognitionResult> results = recognizeResponse.getResultsList();
//            for (SpeechRecognitionResult result : results) {
//                List<SpeechRecognitionAlternative> alternatives = result.getAlternativesList();
//                for (SpeechRecognitionAlternative alternative : alternatives) {
//                    System.out.println("识别结果: " + alternative.getTranscript());
//                }
//            }
//        }
//        return filePath;
//    }
//
//    public static byte[] downloadUrlAsByteArray(String urlString) throws Exception {
//        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
//            HttpGet request = new HttpGet(urlString);
//            try (CloseableHttpResponse response = httpClient.execute(request)) {
//                if (response.getStatusLine().getStatusCode() != 200) {
//                    throw new RuntimeException("HTTP Error: " + response.getStatusLine());
//                }
//                return EntityUtils.toByteArray(response.getEntity());
//            }
//        }
//    }
//
//}
