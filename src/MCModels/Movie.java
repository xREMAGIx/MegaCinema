/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MCModels;

/**
 *
 * @author USER
 */
public class Movie {
    private int id;
    private String name;
    private int duration;
    private String genre;

    public Movie(int id, String name, int duration, String genre) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.genre = genre;
        
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Movie() {
    }
    

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    
}
