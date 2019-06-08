
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MCControllers;

import MCModels.Movie;

import java.util.List;

/**
 *
 * @author USER
 */
public class MovieController {

    private final Movie movieM = new Movie();

//   public int Add(String name, int dur, int status)
//   {
//       Movie movie = new Movie();
//       
//       movie.setName(name);
//       movie.setDuration(dur);
//       movie.setStatus(status);
//       
//       return movieM.Insert(movie);
//   }
//   
//   public int Modify(int id, String name, int dur, int status)
//   {
//       Movie movie = new Movie();
//       
//       movie.setId(id);
//       movie.setName(name);
//       movie.setDuration(dur);
//       movie.setStatus(status);
//              
//       return movieM.Update(movie);     
//   }
//   
//   public int Delete (int id)
//   {
//       return movieM.Delete(id);
//   }
//   
//   public Object[][] SelectAll()
//   {
//       List <Movie> movieList = movieM.Select("");
//
//       int length=movieList.size()+1;
//       
//       System.out.println("length: "+length);
//       
//       Object[][] data = new Object[length][4];
//       data[0][0]=length;
//          
//       for (int i=1; i<length; i++){
//            data[i][0] = movieList.get(i-1).getId();
//            data[i][1] = movieList.get(i-1).getName();
//            data[i][2] = movieList.get(i-1).getDuration();
//            data[i][3] = movieList.get(i-1).getStatus();       
//            System.out.println(data[i][0]);
//        }
//        
//       return data;
//   }
//   
//   public List<Movie> SelectScheduledMovie(String condt)
//   {
//       return movieM.SelectScheduledMovie("");
//   }
//   
    public int Add(Movie movie) {
        return movieM.Insert(movie);
    }

    public int Modify(Movie movie) {
        return movieM.Update(movie);
    }

    public int Delete(int id) {
        return movieM.Delete(id);
    }

    public List<Movie> select(String condt) {
        return movieM.Select(condt);
    }

    public List<Movie> SelectAll() {

        return movieM.Select("");
    }

    public List<Movie> SelectScheduledMovie(String condt) {
        return movieM.SelectScheduledMovie("");
    }

}
