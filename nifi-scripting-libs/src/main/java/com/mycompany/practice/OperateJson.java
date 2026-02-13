package com.mycompany.practice;

import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;

public class OperateJson {
    final private static ObjectMapper objectMapper = new ObjectMapper();

    public String judgeAdult(String parsonalInfo) throws Exception {

        Map<String, Object> data = objectMapper.readValue(parsonalInfo, Map.class);

        int age = Integer.parseInt(data.get("age").toString());
        boolean is_Adult = false;

        if (age >= 20) {
            is_Adult = true;
        }

        data.put("is_Adult", is_Adult);

        String convertData = objectMapper.writeValueAsString(data);
        return convertData;
    }
}
