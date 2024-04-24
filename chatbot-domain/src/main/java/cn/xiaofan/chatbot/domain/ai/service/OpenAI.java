package cn.xiaofan.chatbot.domain.ai.service;


import cn.xiaofan.chatbot.domain.ai.IOpenAI;
import cn.xiaofan.chatbot.domain.ai.model.aggregates.AIAnswer;
import cn.xiaofan.chatbot.domain.ai.model.vo.Choices;
import com.alibaba.fastjson.JSON;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @author 小傅哥，微信：fustack
 * @description
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
@Service
public class OpenAI implements IOpenAI {

    private Logger logger = LoggerFactory.getLogger(OpenAI.class);

    @Override
    public String doChatGPT(String openAiKey, String question) throws IOException {

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 代理地址；open.aiproxy.xyz、open2.aiproxy.xyz
        HttpPost post = new HttpPost("https://api.aiskt.com/v1/chat/completions");
        post.addHeader("Content-Type", "application/json");
        post.addHeader("Authorization", "Bearer " + openAiKey);

//        String paramJson = "{\"model\": \"text-davinci-003\", \"prompt\": \"" + question + "\", \"temperature\": 0, \"max_tokens\": 1024}";
        String paramJson = "{\n" +
                "        \"model\": \"gpt-3.5-turbo\",\n" +
                "         \"messages\": [\n" +
                "           {\n" +
                "              \"role\": \"user\",\n" +
                "              \"content\": \"" + question.replace("\"", "\\\"") + "\"\n" + // 替换question中的双引号
                "            }\n" +
                "          ]\n" +
                "         }";



        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String jsonStr = EntityUtils.toString(response.getEntity());
            AIAnswer aiAnswer = JSON.parseObject(jsonStr, AIAnswer.class);
            StringBuilder answers = new StringBuilder();
            List<Choices> choices = aiAnswer.getChoices();
            for (Choices choice : choices) {
                answers.append(choice.getMessage());
            }
            return answers.toString();
//            String res = EntityUtils.toString(response.getEntity());
//            return res;
        } else {
            throw new RuntimeException("api.openai.com Err Code is " + response.getStatusLine().getStatusCode());
        }
    }

}