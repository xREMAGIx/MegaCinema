/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MCControllers;

import MCDatabase.Database;
import MCModels.Theater;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class TheaterController extends Theater {

    private final Theater theaterM = new Theater();

//    public int insertTheater(int id, int idcinema, int idmanager, int status) {
//        Theater theater = new Theater();
//        theater.setCinemaID(idcinema);
//        theater.setManagerID(idmanager);
//        theater.setStatus(status);
//
//        return theaterM.Insert(theater);
//    }
//
//    public int updateTheater(int id, int idcinema, int idmanager, int status) {
//        Theater theater = new Theater();
//        theater.setId(id);
//        theater.setCinemaID(idcinema);
//        theater.setManagerID(idmanager);
//        theater.setStatus(status);
//        return theaterM.Update(theater);
//    }

    public ArrayList<Theater> loadTheaters() {
        return theaterM.loadTheaters();
    }

    public int add(Theater theater) {
        return theaterM.insert(theater);
    }

    public int modify(Theater theater) {
        return theaterM.update(theater);
    }

    public int delete(int ID) {
        return theaterM.delete(ID);
    }

    public List<Theater> select(String condt) {
        return theaterM.select(condt);
    }

    public List<Theater> selectAll() {
        return theaterM.select("");
    }

    public int createSeats(Theater theater) {
        if (theaterM.getStatus() == 0) {
            return theaterM.createSeats(theater);
        }
        return -1;
    }
}
