package com.example.parulchopra.pinnacle_new_app;

/**
 * Created by Ideal on 2/14/2017.
 */

public class Video_model {
    String name1,name2,name3;
    int image;

    public Video_model(String name1, String name2, String name3, int image) {
        this.name1 = name1;
        this.name2 = name2;
        this.name3 = name3;
        this.image = image;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getName3() {
        return name3;
    }

    public void setName3(String name3) {
        this.name3 = name3;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
