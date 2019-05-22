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
public class Seat {
    private int id;
    private int theaterid;
    private int rownum;
    private int colnum;
    private int status;

    public Seat() {
    }

    public Seat(int id, int theaterid, int rownum, int colnum, int status) {
        this.id = id;
        this.theaterid = theaterid;
        this.rownum = rownum;
        this.colnum = colnum;
        this.status = status;
    }
    
    

    public int getId() {
        return id;
    }

    public int getTheaterid() {
        return theaterid;
    }

    public int getRownum() {
        return rownum;
    }

    public int getColnum() {
        return colnum;
    }

    public int getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTheaterid(int theaterid) {
        this.theaterid = theaterid;
    }

    public void setRownum(int rownum) {
        this.rownum = rownum;
    }

    public void setColnum(int colnum) {
        this.colnum = colnum;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    
    
}
