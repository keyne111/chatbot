package cn.xiaofan.chatbot.domain.ai.model.aggregates;

import cn.xiaofan.chatbot.domain.ai.model.vo.Choices;
import cn.xiaofan.chatbot.domain.ai.model.vo.Prompt_filter_results;
import cn.xiaofan.chatbot.domain.ai.model.vo.Usage;

import java.util.ArrayList;
import java.util.List;
public class AIAnswer
{
    private List<Choices> choices;

    private int created;

    private String id;

    private String model;

    private String object;

    private List<Prompt_filter_results> prompt_filter_results;

    private String system_fingerprint;

    private Usage usage;

    public void setChoices(List<Choices> choices){
        this.choices = choices;
    }
    public List<Choices> getChoices(){
        return this.choices;
    }
    public void setCreated(int created){
        this.created = created;
    }
    public int getCreated(){
        return this.created;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public void setModel(String model){
        this.model = model;
    }
    public String getModel(){
        return this.model;
    }
    public void setObject(String object){
        this.object = object;
    }
    public String getObject(){
        return this.object;
    }
    public void setPrompt_filter_results(List<Prompt_filter_results> prompt_filter_results){
        this.prompt_filter_results = prompt_filter_results;
    }
    public List<Prompt_filter_results> getPrompt_filter_results(){
        return this.prompt_filter_results;
    }
    public void setSystem_fingerprint(String system_fingerprint){
        this.system_fingerprint = system_fingerprint;
    }
    public String getSystem_fingerprint(){
        return this.system_fingerprint;
    }
    public void setUsage(Usage usage){
        this.usage = usage;
    }
    public Usage getUsage(){
        return this.usage;
    }

    @Override
    public String toString() {
        return "AIAnswer{" +
                "choices=" + choices +
                ", created=" + created +
                ", id='" + id + '\'' +
                ", model='" + model + '\'' +
                ", object='" + object + '\'' +
                ", prompt_filter_results=" + prompt_filter_results +
                ", system_fingerprint='" + system_fingerprint + '\'' +
                ", usage=" + usage +
                '}';
    }
}