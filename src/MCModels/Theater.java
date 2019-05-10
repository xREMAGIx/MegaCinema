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
public class Theater {
    private int id;
    private int movieID;
    private int managerID;
    private String status;

    public Theater(int id, int movieID, int managerID, String status) {
        this.id = id;
        this.movieID = movieID;
        this.managerID = managerID;
        this.status = status;
    }

    public Theater() {
    }

    public int getId() {
        return id;
    }

    public int getMovieID() {
        return movieID;
    }

    public int getManagerID() {
        return managerID;
    }

    public String getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public void setManagerID(int managerID) {
        this.managerID = managerID;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
