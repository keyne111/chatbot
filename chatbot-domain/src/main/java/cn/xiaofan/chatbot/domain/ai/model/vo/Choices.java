package cn.xiaofan.chatbot.domain.ai.model.vo;

public class Choices
{
    private Content_filter_results content_filter_results;

    private String finish_reason;

    private int index;

    private String logprobs;

    private Message message;

    public void setContent_filter_results(Content_filter_results content_filter_results){
        this.content_filter_results = content_filter_results;
    }
    public Content_filter_results getContent_filter_results(){
        return this.content_filter_results;
    }
    public void setFinish_reason(String finish_reason){
        this.finish_reason = finish_reason;
    }
    public String getFinish_reason(){
        return this.finish_reason;
    }
    public void setIndex(int index){
        this.index = index;
    }
    public int getIndex(){
        return this.index;
    }
    public void setLogprobs(String logprobs){
        this.logprobs = logprobs;
    }
    public String getLogprobs(){
        return this.logprobs;
    }
    public void setMessage(Message message){
        this.message = message;
    }
    public Message getMessage(){
        return this.message;
    }
}