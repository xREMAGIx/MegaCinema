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
    private String duration;

    public Movie(int id, String name, String duration) {
        this.id = id;
        this.name = name;
        this.duration = duration;
    }

    public Movie() {
    }
    

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDuration() {
        return duration;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
    
}
