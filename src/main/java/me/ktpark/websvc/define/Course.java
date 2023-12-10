package me.ktpark.websvc.define;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Course {
    private String title;
    private String shortTitle;
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
