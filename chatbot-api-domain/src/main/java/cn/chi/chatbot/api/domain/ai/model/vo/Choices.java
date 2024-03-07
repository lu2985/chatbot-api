package cn.chi.chatbot.api.domain.ai.model.vo;

/**
 * @author chi
 * @version 1.0
 * @description 选择
 * @date 2024/3/6  11:43
 */
public class Choices {

    private Message message;

    private int index;

    private String logprobs;

    private String finish_reason;

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getLogprobs() {
        return logprobs;
    }

    public void setLogprobs(String logprobs) {
        this.logprobs = logprobs;
    }

    public String getFinish_reason() {
        return finish_reason;
    }

    public void setFinish_reason(String finish_reason) {
        this.finish_reason = finish_reason;
    }
}
