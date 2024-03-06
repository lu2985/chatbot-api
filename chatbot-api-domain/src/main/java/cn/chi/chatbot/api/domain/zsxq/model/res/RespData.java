package cn.chi.chatbot.api.domain.zsxq.model.res;

import cn.chi.chatbot.api.domain.zsxq.model.vo.Topics;

import java.util.List;

/**
 * @author chi
 * @version 1.0
 * @description
 * @date 2024/3/6  8:49
 */
public class RespData {

    private List<Topics> topics;

    public List<Topics> getTopics() {
        return topics;
    }

    public void setTopics(List<Topics> topics) {
        this.topics = topics;
    }

}
