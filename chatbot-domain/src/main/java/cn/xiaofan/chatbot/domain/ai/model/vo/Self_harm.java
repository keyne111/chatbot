package cn.xiaofan.chatbot.domain.ai.model.vo;

public class Self_harm
{
    private boolean filtered;

    private String severity;

    public void setFiltered(boolean filtered){
        this.filtered = filtered;
    }
    public boolean getFiltered(){
        return this.filtered;
    }
    public void setSeverity(String severity){
        this.severity = severity;
    }
    public String getSeverity(){
        return this.severity;
    }
}