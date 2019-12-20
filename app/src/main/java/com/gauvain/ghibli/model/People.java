package com.gauvain.ghibli.model;

public class People {

    private String name;
    private String gender;
    private String age;
    private String eye_color;
    private String hair_color;

    public People(String name, String gender, String age, String eye_color, String hair_color) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.eye_color = eye_color;
        this.hair_color = hair_color;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getAge() {
        return age;
    }

    public String getEye_color() {
        return eye_color;
    }

    public String getHair_color() {
        return hair_color;
    }
}
