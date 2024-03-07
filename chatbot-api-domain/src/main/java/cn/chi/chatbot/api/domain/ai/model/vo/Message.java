package cn.chi.chatbot.api.domain.ai.model.vo;

/**
 * @author chi
 * @version 1.0
 * @description
 * @date 2024/3/7  14:09
 */
public class Message {
    private String role;

    private String content;

    public void setRole(String role){
        this.role = role;
    }
    public String getRole(){
        return this.role;
    }
    public void setContent(String content){
        this.content = content;
    }
    public String getContent(){
        return this.content;
    }
}
