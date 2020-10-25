package com.weiyi.pojo;

import org.springframework.beans.factory.annotation.Value;

public class Person {
    @Value("李四")//1。基本数值，2，SpEl；#{}. 3,${},取配置文件中的值
    private String name ;
    @Value("#{20-4}")
    private String age;
    @Value("${person.sex}")
    private String sex;
    public String getName() {
        return name;
    }

    public Person() {
    }

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
