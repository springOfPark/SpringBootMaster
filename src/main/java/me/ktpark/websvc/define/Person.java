package me.ktpark.websvc.define;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(realNumber, person.realNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(realNumber);
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
