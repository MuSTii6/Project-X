package ch.zhaw.springboot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)			//Inheritance: Definiert Parent und somit dass Attribute von Child geerbt werden
public class Music {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String artist;

    @ManyToOne
    private Composition composition;
    
    public Music(String artist, Composition composition) {
        this.artist = artist;
        this.composition = composition;
    }

    public Music() {

    }

    

	public long getId() {
        return id;
    }

    public String getArtist() {
        return artist;
    }

    public Composition getComposition() {
        return composition;
    }
}
