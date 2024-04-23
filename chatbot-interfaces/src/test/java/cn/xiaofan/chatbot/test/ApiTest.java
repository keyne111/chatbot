package cn.xiaofan.chatbot.test;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

public class ApiTest {

    @Test
    public void query() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get=new HttpGet("https://api.zsxq.com/v2/groups/28888818455441/topics?scope=unanswered_questions&count=20");

        get.addHeader("cookie","zsxq_access_token=7E48990D-9791-0D5F-78B6-EDBA4C3846ED_499C9A1E09626DA7; zsxqsessionid=ac4bc557e77bf7445ba7ddc0bd1f7756; abtest_env=product; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%2218f0a2c887b48a-00963a93117cf1e-4c657b58-1327104-18f0a2c887c906%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThmMGEyYzg4N2I0OGEtMDA5NjNhOTMxMTdjZjFlLTRjNjU3YjU4LTEzMjcxMDQtMThmMGEyYzg4N2M5MDYifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%22%2C%22value%22%3A%22%22%7D%2C%22%24device_id%22%3A%2218f0a2c887b48a-00963a93117cf1e-4c657b58-1327104-18f0a2c887c906%22%7D; sajssdk_2015_cross_new_user=1");
        get.addHeader("Content-Type","application/json;charset=utf8");

        CloseableHttpResponse response = httpClient.execute(get);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {//请求成功执行
            HttpEntity entity = response.getEntity();//获取返回的数据
            String s = EntityUtils.toString(entity);//转换成字符串
            System.out.println(s);
            JSONObject datas = JSONObject.parseObject(s);//转换成JSON格式
            System.out.println(datas);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }


    }

    @Test
    public void answer() throws IOException {

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/8855284542444242/answer");
        post.addHeader("cookie","zsxq_access_token=7E48990D-9791-0D5F-78B6-EDBA4C3846ED_499C9A1E09626DA7; zsxqsessionid=ac4bc557e77bf7445ba7ddc0bd1f7756; abtest_env=product; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%2218f0a2c887b48a-00963a93117cf1e-4c657b58-1327104-18f0a2c887c906%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThmMGEyYzg4N2I0OGEtMDA5NjNhOTMxMTdjZjFlLTRjNjU3YjU4LTEzMjcxMDQtMThmMGEyYzg4N2M5MDYifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%22%2C%22value%22%3A%22%22%7D%2C%22%24device_id%22%3A%2218f0a2c887b48a-00963a93117cf1e-4c657b58-1327104-18f0a2c887c906%22%7D; sajssdk_2015_cross_new_user=1");
        post.addHeader("Content-Type","application/json;charset=utf8");

        String paramJson="{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"百度百度！！\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"silenced\": false\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {//请求成功执行
            HttpEntity entity = response.getEntity();//获取返回的数据
            String s = EntityUtils.toString(entity);//转换成字符串
            System.out.println(s);
            JSONObject datas = JSONObject.parseObject(s);//转换成JSON格式
            System.out.println(datas);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

}
