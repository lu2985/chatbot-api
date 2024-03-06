package cn.chi.chatbot.api.domain.zsxq.model.req;

/**
 * @author chi
 * @version 1.0
 * @description 请求回答接口信息
 * @date 2024/3/6  9:11
 */
public class AnswerReq {

    private ReqData req_data;

    public AnswerReq(ReqData req_data) {
        this.req_data = req_data;
    }

    public ReqData getReq_data() {
        return req_data;
    }

    public void setReq_data(ReqData req_data) {
        this.req_data = req_data;
    }
}
