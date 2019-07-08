/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MCControllers;

import MCModels.Cinema;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class CinemaController extends Cinema {

    private final Cinema cinemaM = new Cinema();

    public int insertCinema(int id, String name, String location, int status) {
        Cinema cinema = new Cinema();
        cinema.setId(id);
        cinema.setName(name);
        cinema.setLocation(location);
        cinema.setStatus(status);

        return cinemaM.Insert(cinema);
    }

    public int updateCinema(int id, String name, String location, int status) {
        Cinema cinema = new Cinema();
        cinema.setId(id);
        cinema.setName(name);
        cinema.setLocation(location);
        cinema.setStatus(status);
        return cinemaM.Update(cinema);
    }

    public int deleteCinema(int id) {
        return cinemaM.Delete(id);

    }

    public List<Cinema> loadCinemas() {
        return cinemaM.Select("");
    }

    public int getNextID() {
        return cinemaM.getNextID();
    }
}
