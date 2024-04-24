package cn.xiaofan.chatbot.domain.ai.model.vo;

public class Content_filter_results
{
    private Hate hate;

    private Self_harm self_harm;

    private Sexual sexual;

    private Violence violence;

    public void setHate(Hate hate){
        this.hate = hate;
    }
    public Hate getHate(){
        return this.hate;
    }
    public void setSelf_harm(Self_harm self_harm){
        this.self_harm = self_harm;
    }
    public Self_harm getSelf_harm(){
        return this.self_harm;
    }
    public void setSexual(Sexual sexual){
        this.sexual = sexual;
    }
    public Sexual getSexual(){
        return this.sexual;
    }
    public void setViolence(Violence violence){
        this.violence = violence;
    }
    public Violence getViolence(){
        return this.violence;
    }
}