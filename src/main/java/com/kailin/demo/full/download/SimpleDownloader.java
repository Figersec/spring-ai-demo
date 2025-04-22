package com.kailin.demo.full.download;


import com.kailin.demo.full.util.Stat;

import java.util.logging.Logger;

/**
 * STEP 2.3 库接收识别结果
 * @author 杨松
 */
public class SimpleDownloader {
    private static Logger logger = Logger.getLogger("SimpleDownloader");

    public void onMessage(Result result) {
        if (!result.isHeartBeat()) {
            logger.fine(Stat.formatResult(result).toString());
        }
    }
}
