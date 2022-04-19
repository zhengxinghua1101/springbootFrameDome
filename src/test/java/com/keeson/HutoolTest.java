package com.keeson;

import cn.hutool.http.HttpRequest;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class HutoolTest {


    @Test
    void test1(){

        String url = "https://apitest.smartbed.ink/api/v2/user/bed/recordDeviceTest";
        Map<String,Object> form = new HashMap<>();
        form.put("device_id","KSWF12S000003986");
        form.put("left_sensor_state",2);
        String result = HttpRequest.post(url)
                .header("Authorization", "hz9bpM8f9GKVfODz4Ad37dO23R0KEu2v")
                .form(form)
                .timeout(20000)
                .execute().body();
        System.out.println("我执行结束==》");
        System.out.println(result);
        System.out.println("《===结果");

    }
}
