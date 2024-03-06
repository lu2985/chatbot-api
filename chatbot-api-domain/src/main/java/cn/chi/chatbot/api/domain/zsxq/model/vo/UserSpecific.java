package cn.chi.chatbot.api.domain.zsxq.model.vo;

/**
 * @author chi
 * @version 1.0
 * @description
 * @date 2024/3/6  8:34
 */
public class UserSpecific {

    private boolean liked;

    private boolean subscribed;

    public void setLiked(boolean liked){
        this.liked = liked;
    }
    public boolean getLiked(){
        return this.liked;
    }
    public void setSubscribed(boolean subscribed){
        this.subscribed = subscribed;
    }
    public boolean getSubscribed(){
        return this.subscribed;
    }

}