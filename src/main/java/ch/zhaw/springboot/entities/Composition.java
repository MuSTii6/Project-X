package ch.zhaw.springboot.entities;

import javax.persistence.Entity;

@Entity
public class Composition extends Music {
    
    private String lyrics;

    public Composition(String lyrics) {
        this.lyrics = lyrics;
    }

    public Composition() {

    }

    public String getLyrics() {
        return lyrics;
    }
}
