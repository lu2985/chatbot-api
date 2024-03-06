package cn.chi.chatbot.api.domain.zsxq.model.res;

import sun.nio.cs.ext.MacSymbol;

/**
 * @author chi
 * @version 1.0
 * @description 请求问答接口的结果(回答是否成功)
 * @date 2024/3/6  9:13
 */
public class AnswerRes {

    private boolean succeeded;

    public boolean isSucceeded() {
        return succeeded;
    }

    public void setSucceeded(boolean succeeded) {
        this.succeeded = succeeded;
    }
}
