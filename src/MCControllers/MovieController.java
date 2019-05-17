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
   
   public int Add(String name, int dur, int status)
   {
       Movie movie = new Movie();
       
       movie.setName(name);
       movie.setDuration(dur);
       movie.setStatus(status);
       
       return movieM.Insert(movie);
   }
   
   public int Modify(Movie movie)
   {
       return movieM.Update(movie);     
   }
   
   public int Delete (int id)
   {
       return movieM.Delete(id);
   }
   
   public List<Movie> SelectAll()
   {
       
       return movieM.Select("");
   }
   
   public List<Movie> SelectScheduledMovie(String condt)
   {
       return movieM.SelectScheduledMovie("");
   }
}
