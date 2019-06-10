
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

    public int add(Movie movie) {
        return movieM.insert(movie);
    }

    public int modify(Movie movie) {
        return movieM.update(movie);
    }

    public int delete(int id) {
        return movieM.delete(id);
    }

    public List<Movie> select(String condt) {
        return movieM.select(condt);
    }

    public List<Movie> selectAll() {

        return movieM.select("");
    }

    public List<Movie> selectScheduledMovie(String condt) {
        return movieM.selectScheduledMovie("");
    }

}
