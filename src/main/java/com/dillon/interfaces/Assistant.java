package com.dillon.interfaces;

import dev.langchain4j.service.SystemMessage;

public interface Assistant {
    // 加上系统提示词，让 AI 更有“助手”的样子
    @SystemMessage("你是一个专业的个人 AI 助手。如果用户询问天气，请务必使用工具查询。")
    String chat(String message); 
    // 注意：部署到网页版初学者建议先用 String（同步模式），更稳健
}