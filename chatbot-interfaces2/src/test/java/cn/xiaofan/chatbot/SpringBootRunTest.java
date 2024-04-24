package cn.xiaofan.chatbot;

import cn.xiaofan.chatbot.domain.ai.IOpenAI;
import cn.xiaofan.chatbot.domain.zsxq.IZsxqApi;
import cn.xiaofan.chatbot.domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;
import cn.xiaofan.chatbot.domain.zsxq.model.vo.Topics;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

/**
 * @author 小傅哥，微信：fustack
 * @description
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRunTest {

    private Logger logger = LoggerFactory.getLogger(SpringBootRunTest.class);

    @Value("${chatbot.groupId}")
    private String groupId;
    @Value("${chatbot.cookie}")
    private String cookie;

    @Value("${chatbot.openAiKey}")
    private String openAiKey;

    @Autowired
    private IZsxqApi zsxqApi;

    @Autowired
    private IOpenAI openAI;

    @Test
    public void test_zsxqApi() throws IOException {
        UnAnsweredQuestionsAggregates unAnsweredQuestionsAggregates = zsxqApi.queryUnAnsweredQuestionTopicId(groupId, cookie);
        logger.info("测试结果：{}", JSON.toJSONString(unAnsweredQuestionsAggregates));

        List<Topics> topics = unAnsweredQuestionsAggregates.getResp_data().getTopics();
        for (Topics topic : topics) {
            String topicId = topic.getTopic_id();
            String text = topic.getQuestion().getText();
            logger.info("topicId：{} text：{}", topicId, text);

            // 回答问题
            zsxqApi.answer(groupId, cookie, topicId, text, false);
        }
    }

    @Test
    public void test_openAi() throws IOException {
        String response = openAI.doChatGPT(openAiKey, "请你帮我写一个Java冒泡排序");
        logger.info("测试结果：{}", response);
    }



}