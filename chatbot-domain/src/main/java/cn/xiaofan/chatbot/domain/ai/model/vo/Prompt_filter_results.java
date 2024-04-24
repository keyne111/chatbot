package cn.xiaofan.chatbot.domain.ai.model.vo;

public class Prompt_filter_results
{
    private int prompt_index;

    private Content_filter_results content_filter_results;

    public void setPrompt_index(int prompt_index){
        this.prompt_index = prompt_index;
    }
    public int getPrompt_index(){
        return this.prompt_index;
    }
    public void setContent_filter_results(Content_filter_results content_filter_results){
        this.content_filter_results = content_filter_results;
    }
    public Content_filter_results getContent_filter_results(){
        return this.content_filter_results;
    }
}