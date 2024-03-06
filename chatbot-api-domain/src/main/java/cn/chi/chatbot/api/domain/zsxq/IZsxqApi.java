package cn.chi.chatbot.api.domain.zsxq;

import cn.chi.chatbot.api.domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;

import java.io.IOException;

/**
 * @author chi
 * @version 1.0
 * @description 知识星球API接口
 * @date 2024/3/6  8:24
 */
public interface IZsxqApi {

    UnAnsweredQuestionsAggregates queryUnAnsweredQuestionsTopicId(String groupId, String cookie) throws IOException;


    boolean answer(String groupId, String cookie, String topicId, String text, boolean silenced) throws IOException;
}
