package cn.xiaofan.chatbot.domain.zsxq;

import cn.xiaofan.chatbot.domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;


import java.io.IOException;

public interface IZsxqApi {


    UnAnsweredQuestionsAggregates queryUnAnsweredQuestionTopicId(String groupId, String cookie)throws IOException;

    boolean answer(String groupId, String cookie, String topicId, String text, boolean silenced) throws IOException;
}
