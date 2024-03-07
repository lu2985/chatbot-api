package cn.chi.chatbot.api.domain.ai;

import java.io.IOException;

/**
 * @author chi
 * @version 1.0
 * @description chatgpt open Ai接口
 * @date 2024/3/6  11:39
 */
public interface IOpenAI {

    String doChatGPT(String question) throws IOException;

}

