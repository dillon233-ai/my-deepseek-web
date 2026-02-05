package com.dillon.tools;

import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;

public class MyServiceTools {

//    @Tool("获取指定城市的当前气温")
//    public String getSchemaWeather(String city) {
//        System.out.println("--- 触发本地调用：查询 " + city + " 的天气 ---");
//        // 这里通常是调用第三方 API 或查数据库
//        if (city.contains("北京")) return "25°C，晴";
//        if (city.contains("上海")) return "22°C，多云";
//        return "未知地区，气温 20°C";
//    }
    @Tool("获取指定城市的当前气温")
    public String getSchemaWeather(@P("城市") String city) {
        System.out.println("--- 网页请求触发了工具调用，城市: " + city + " ---");
        return city + "的天气是晴天，25摄氏度。";
    }
}
