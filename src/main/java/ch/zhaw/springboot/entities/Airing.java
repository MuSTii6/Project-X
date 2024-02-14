package ch.zhaw.springboot.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

//@Entity generiert Tabelle für SQL

@Entity
public class Airing {
	    
	
	//GeneratedValue erzeugt PK im SQL
	//Id Hibernate mitteilen dass es eine ID ist
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date date;

    @ManyToOne
    private Concert concert;
    @ManyToOne
    private Music music;

    
    //Konstruktor 
    
    public Airing(Date date, Concert concert, Music music) {
        this.date = date;
        this.concert = concert;
        this.music = music;
    }

    //Default Konstruktor
    
    public Airing() {
        
    }

    public long getId() {
        return this.id;
    }

    public Date getDate() {
        return this.date;
    }

    public Concert getConcert() {
        return this.concert;
    }

    public Music getMusic() {
        return this.music;
    }

}
