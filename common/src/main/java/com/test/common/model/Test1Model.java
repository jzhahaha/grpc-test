package com.test.common.model;

public class Test1Model {

    private int id;
    private String username;
    private int age;
    private String area;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString(){
        return "Test1Model:{ id:"+id+
                ",username:"+username+
                ",age:"+age+
                ",area:"+area+
                "}";
    }
}
