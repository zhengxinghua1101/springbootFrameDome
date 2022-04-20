package com.keeson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import okhttp3.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;


public class OkHttpTest {


    /**
     * get
     *
     * @throws IOException
     */
    @Test
    void TestGet() throws IOException {

        OkHttpClient client = new OkHttpClient();
        String url = "http://httpbin.org/get";

        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        System.out.println(response);
        if (response.isSuccessful()) {
            System.out.println(response.body().string());
        }
    }


    /**
     * form表单 post
     *
     * @throws IOException
     */
    @Test
    void TestPost() throws IOException {
        OkHttpClient client = new OkHttpClient();

        // 提交FormData
        FormBody.Builder form = new FormBody.Builder();
        form.add("name", "Tom");
        form.add("age", "23");

        Request request = new Request.Builder()
                .url("http://httpbin.org/post")
                .post(form.build())
                .build();

        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());

    }

    /**
     * json post
     *
     * @throws IOException
     */
    @Test
    void TestPostJson() throws IOException {

        OkHttpClient client = new OkHttpClient();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Tom");
        jsonObject.put("age", 23);
        String data = JSON.toJSONString(jsonObject);

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), data);

        Request request = new Request.Builder()
                .url("http://httpbin.org/post")
                .post(requestBody)
                .build();

        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());

    }


}
