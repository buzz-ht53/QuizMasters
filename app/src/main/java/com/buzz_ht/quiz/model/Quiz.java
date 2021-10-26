package com.buzz_ht.quiz.model;

import java.util.ArrayList;
import java.util.List;

public class Quiz {

    int ID;
    String title;
    int Image;

    public Quiz(int ID, String title, int image1) {
        this.ID = ID;
        this.title = title;
        this.Image = image1;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }
}
