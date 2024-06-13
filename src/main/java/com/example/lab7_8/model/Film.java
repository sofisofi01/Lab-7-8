package com.example.lab7_8.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("filmBean")
@Scope("prototype")
public class Film {
    private String title;
    private String director;
    private String annotation;
    private String ISBN;
    private int duration;

    public Film(@Value("test") String title, @Value("Tarkovsky") String director, @Value("Good film") String annotation, @Value("112321321") String ISBN, @Value("130") int duration) {
        this.title = title;
        this.director = director;
        this.annotation = annotation;
        this.ISBN = ISBN;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

}