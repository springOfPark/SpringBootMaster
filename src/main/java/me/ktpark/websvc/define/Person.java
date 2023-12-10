package me.ktpark.websvc.define;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {

    private String realNumber;
    private String name;
    private Integer age;

    public String getRealNumber() {
        return realNumber;
    }

    public void setRealNumber(String realNumber) {
        this.realNumber = realNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
