/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MCControllers;

import MCDatabase.Database;
import MCModels.Seat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import MCViews.LoginMCView;
/**
 *
 * @author USER
 */
public class SeatController extends Seat{
    Database db;
    Connection con;
    PreparedStatement pst;
    
    public SeatController()
    {
        super();
        try {
            db= new Database();
            con = db.getConnection();
        } catch (Exception ex) {
            Logger.getLogger(SeatController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
