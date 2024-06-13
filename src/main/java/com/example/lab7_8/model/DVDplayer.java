package com.example.lab7_8.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("showFilm")

public class DVDplayer {
    @Autowired
    public DVDplayer(@Qualifier("firstFilm") Film currentFilm, @Qualifier("secondFilm") Film previousFilm, @Qualifier("thirdFilm") Film followingFilm) {
        this.currentFilm = currentFilm;
        this.previousFilm = previousFilm;
        this.followingFilm = followingFilm;
    }

    private Film currentFilm;
    private Film previousFilm;
    private Film followingFilm;
}