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
    private int cinemaID;
    private int managerID;
    private int status;

    public Theater(int id, int cinemaID, int managerID, int status) {
        this.id = id;
        this.cinemaID = cinemaID;
        this.managerID = managerID;
        this.status = status;
    }

    public Theater() {
    }

    public int getId() {
        return id;
    }

    public int getCinemaID() {
        return cinemaID;
    }

    public int getManagerID() {
        return managerID;
    }

    public int getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCinemaID(int cinemaID) {
        this.cinemaID = cinemaID;
    }

    public void setManagerID(int managerID) {
        this.managerID = managerID;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
}
