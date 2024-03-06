package cn.chi.chatbot.api;



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


import javax.swing.text.html.parser.Entity;
import java.io.IOException;

/**
 * @author chi
 * @version 1.0
 * @description  单元测试
 * @date 2024/3/4  20:14
 */
public class ApiTest {

    @Test
    public void query_unanswerde_questions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/28885122821821/topics?scope=unanswered_questions&count=20");
        get.addHeader("cookie", "zsxq_access_token=26715899-EE32-586E-9280-2285B61C487F_E34D8DFA00329707; zsxqsessionid=f85525edad5c98e6a9caaa2514801d00; abtest_env=product");
        // 这里小付哥是Content-Type
        get.addHeader("Content-Type", "application/json;charset=utf8");
        CloseableHttpResponse response = httpClient.execute(get);
        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }

    }

    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/5122151821522254/answer");
        post.addHeader("cookie", "zsxq_access_token=26715899-EE32-586E-9280-2285B61C487F_E34D8DFA00329707; abtest_env=product; zsxqsessionid=dd02fdedecdea636d14ba6b1bc94924d");
        post.addHeader("Content-Type", "application/json;charset=utf8");

        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"睡觉就行了\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"silenced\": false\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);

        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

}
