
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MCModels;

import MCDatabase.Database;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.serial.SerialBlob;

/**
 *
 * @author USER
 */
public class Movie {

    private int id;
    private int genreId;
    //private int langId;
    private String name;
    //private String duration;
    private int duration;
    private byte[] image;
    private int status;

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Movie(int id, String name, int duration) {
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    Blob blob = null;

    public int insert(Movie movie) {
        try {
            blob = new SerialBlob(movie.getImage());
        } catch (SQLException ex) {
            Logger.getLogger(Movie.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            String sqlstr = "insert into movie(movieName, movieDuration, movieImage, movieStatus) values( '"
                    + movie.getName() + "', " + movie.getDuration() + ", ? , " + movie.getStatus()
                    + ")";
            //sqlstr += " ALTER TABLE `movie` AUTO_INCREMENT = 1;";

            Database db = new Database();

            db.openConnection();

            ResultSet rst;

            PreparedStatement stmt = db.getConnect().prepareStatement(sqlstr, Statement.RETURN_GENERATED_KEYS);
            try {
                blob = new SerialBlob(movie.getImage());
            } catch (SQLException ex) {
                Logger.getLogger(Movie.class.getName()).log(Level.SEVERE, null, ex);
            }

            stmt.setBlob(1, blob);

            stmt.executeUpdate();
            rst = stmt.getGeneratedKeys();

            if (rst != null && rst.first()) {
                movie.setId(rst.getInt(1));

            }

            db.close(rst);
            db.close();
            //db.closeConnection();	
            return 1;

        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());

        }
        return 0;
    }

    public int update(Movie movie) {

        int rtn = 0;

        try {

            System.out.println("movie: " + movie.getName());

            String sqlstr = "update movie set " + "movieId = " + movie.getId() + ", movieName = '" + movie.getName()
                    + "', movieDuration = " + movie.getDuration() + ", movieImage = ?" + ", movieStatus = " + movie.getStatus();

            //String sqlstr =" ";
            sqlstr += " where movieId = " + movie.getId();

            Database db = new Database();

            db.openConnection();

            PreparedStatement stmt = db.getConnect().prepareStatement(sqlstr);
            try {
                blob = new SerialBlob(movie.getImage());
            } catch (SQLException ex) {
                Logger.getLogger(Movie.class.getName()).log(Level.SEVERE, null, ex);
            }
            stmt.setBlob(1, blob);
            rtn = stmt.executeUpdate();
            //rtn = db.execCommand(sqlstr);

            System.out.println("Update: " + sqlstr);
            //db.closeConnection();	

        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return rtn;
    }

    public int delete(int ID) {

        int rtn = 0;

        try {
            String sqlstr = "delete from movie ";

            sqlstr += " where movieId = " + ID;

            Database db = new Database();

            db.openConnection();

            rtn = db.execCommand(sqlstr);

            db.close();
            //db.closeConnection();

        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return rtn;
    }

    public List<Movie> select(String condt) {

        List<Movie> movieList = null;

        movieList = new LinkedList<Movie>();

        try {

            String sqlstr = "select movieId, movieName, movieDuration, movieImage, movieStatus from movie ";

            condt.trim();

            if (!condt.isEmpty()) {
                sqlstr += " where " + condt;
            }

            Database db = new Database();

            db.openConnection();

            if (db.openConnection() == null) {
                return null;
            }
//	
            ResultSet rst = db.execQuery(sqlstr);

            if (rst != null) {

                while (rst.next()) {

                    Movie movie = new Movie();

                    movie.setId(rst.getInt("movieId"));

                    movie.setName(rst.getString("movieName"));

                    //ply.setIntroduction(rst.getString("play_introduction"));
//                    
                    movie.setDuration(rst.getInt("movieDuration"));
//		
                    Blob blobS = rst.getBlob("movieImage");

                    if (blobS != null) {
                        int blobLength = (int) blobS.length();
                        byte[] blobAsBytes = blobS.getBytes(1, blobLength);
                        movie.setImage(blobAsBytes);
                    } else {
                        movie.setImage(null);
                    }

//release the blob and free up memory. (since JDBC 4.0)
                    //blobS.free();
//                   // ply.setPrice(rst.getInt("play_ticket_price"));
//		
                    movie.setStatus(rst.getInt("movieStatus"));

                    movieList.add(movie);
                }
            }

            db.close(rst);
            db.close();
            //db.closeConnection();

        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());

        }

        return movieList;
    }

    public List<Movie> selectScheduledMovie(String condt) {

        List<Movie> stuList = null;

        stuList = new LinkedList<Movie>();

        try {
            String sqlstr = "select movie.movieId, movieName from movie, schedule where movie.movieId=schedule.movieId ";

            condt.trim();

            if (!condt.isEmpty()) {
                sqlstr += " where " + condt;
            }

            sqlstr += " group by movieName";

            Database db = new Database();

            if (db.openConnection() == null) {
                return null;
            }

            ResultSet rst = db.execQuery(sqlstr);

            if (rst != null) {

                while (rst.next()) {

                    Movie stu = new Movie();

                    stu.setId(rst.getInt("movieId"));

                    stu.setName(rst.getString("movieName"));

                    stuList.add(stu);

                }

            }

            db.close(rst);
            db.close();
            //db.closeConnection();

        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return stuList;
    }

}
