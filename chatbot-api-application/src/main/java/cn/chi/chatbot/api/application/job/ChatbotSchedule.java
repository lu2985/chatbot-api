package cn.chi.chatbot.api.application.job;

import cn.chi.chatbot.api.domain.ai.IOpenAI;
import cn.chi.chatbot.api.domain.zsxq.IZsxqApi;
import cn.chi.chatbot.api.domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;
import cn.chi.chatbot.api.domain.zsxq.model.vo.Topics;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

/**
 * @author chi
 * @version 1.0
 * @description  回答问题任务
 * @date 2024/3/7  14:22
 */

@EnableScheduling
@Configuration
public class ChatbotSchedule {
    private Logger logger = LoggerFactory.getLogger(ChatbotSchedule.class);


    @Value("${chatbot-api.groupId}")
    private String groupId;
    @Value("${chatbot-api.cookie}")
    private String cookie;

    @Resource
    private IZsxqApi zsxqApi;
    @Resource
    private IOpenAI openAI;

    // 表达式：cron.qqe2.com
    // 注解：表示每5秒调一次该函数
    @Scheduled(cron = "0/5 * * * * ?")
    public void run() {
        try {
            // 让调用时间变得不规律，防止被风控抓到
            if(new Random().nextBoolean()) {
                logger.info("随机打烊中...");
                return;
            }

            // 设置晚间不回答
            GregorianCalendar calendar = new GregorianCalendar();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            if(hour > 22 && hour < 6) {
                logger.info("晚间ai不工作了....");
                return;
            }


            //1.检索问题
            UnAnsweredQuestionsAggregates unAnsweredQuestionsAggregates = zsxqApi.queryUnAnsweredQuestionsTopicId(groupId, cookie);
            logger.info("检索结果：{}", JSON.toJSONString(unAnsweredQuestionsAggregates));
            List<Topics> topics = unAnsweredQuestionsAggregates.getResp_data().getTopics();
            if(topics == null || topics.isEmpty()){
                logger.info("本次检索未查找到问题......");
                return;
            }

            //2. AI回答
            Topics topic = topics.get(0);
            String answer = openAI.doChatGPT(topic.getQuestion().getText().trim());
            //3.问题回复
            boolean status = zsxqApi.answer(groupId, cookie, topic.getTopic_id(), answer, false);
            logger.info("编号：{} 问题：{} 回答：{} 状态：{} ", groupId, topic.getQuestion().getText(), answer, status);

        } catch (IOException e) {
            logger.error("自动回答异常", e);
        }
    }


}
