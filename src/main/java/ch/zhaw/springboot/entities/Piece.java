package ch.zhaw.springboot.entities;

import javax.persistence.Entity;

@Entity
public class Piece extends Music {

    private String title;

    public Piece(String title) {
        this.title = title;
    }

    public Piece() {

    }

    public String getTitle() {
        return title;
    }
}
