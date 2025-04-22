package com.kailin.demo.service;

import java.io.IOException;
import java.security.SignatureException;

public interface SpeechService {


    String speechToText() throws IOException, SignatureException, InterruptedException;
}
