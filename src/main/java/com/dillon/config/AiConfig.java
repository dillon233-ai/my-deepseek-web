package com.dillon.config;

import com.dillon.interfaces.Assistant;
import com.dillon.tools.MyServiceTools;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiConfig {

    @Bean
    public Assistant assistant() {
        // 1. 初始化模型
        OpenAiChatModel model = OpenAiChatModel.builder()
                .apiKey(System.getenv("DEEPSEEK_API_KEY")) // 部署到 Render 时配置的环境变量
                .baseUrl("https://api.deepseek.com")
                .modelName("deepseek-chat")
                .temperature(0.0) // 设为 0 保证工具调用稳定
                .build();

        // 2. 构建 AI 服务
        return AiServices.builder(Assistant.class)
                .chatLanguageModel(model)
                .chatMemory(MessageWindowChatMemory.withMaxMessages(10)) // 让它记住你之前的 10 句话
                .tools(new MyServiceTools()) // 别忘了你的天气工具！
                .build();
    }
}