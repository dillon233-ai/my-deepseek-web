package com.dillon.controller;


import com.dillon.interfaces.Assistant;
import com.dillon.tools.MyServiceTools;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api")
@CrossOrigin // 允许跨域访问
public class ChatController {

    @Resource
    private Assistant assistant; // 自动获取上面配置好的 AI 对象

    @GetMapping("/chat")
    public String chat(@RequestParam String message) {
        try {
            return assistant.chat(message);
        } catch (Exception e) {
            e.printStackTrace();
            return "AI 出了点小差: " + e.getMessage();
        }
    }

}
