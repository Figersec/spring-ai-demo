package com.kailin.demo.full.util;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author 杨松
 *
/**
 *      语音识别 appid 118591805
 *     语音识别 appkey esHMRxeE9gV6gzqwuOyHFrII
 *     语音识别 secretKey q2D1whdnIkptjow3QW7rc4K3yU8ISvOc
 */

public class BaiduAuthUtil {
    private static final String API_KEY = "esHMRxeE9gV6gzqwuOyHFrII";
    private static final String SECRET_KEY = "q2D1whdnIkptjow3QW7rc4K3yU8ISvOc";

    public static String getAccessToken() throws Exception {
        String authUrl = "https://openapi.baidu.com/oauth/2.0/token";
        String params = "grant_type=client_credentials&client_id=" + API_KEY + "&client_secret=" + SECRET_KEY;

        URL url = new URL(authUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);

        try (DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
            wr.writeBytes(params);
        }

        StringBuilder response = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            String line;
            while ((line = br.readLine()) != null) {
                response.append(line);
            }
        }

        JSONObject jsonObject = JSON.parseObject(response.toString());

        return (String) jsonObject.get("access_token");
    }
}
