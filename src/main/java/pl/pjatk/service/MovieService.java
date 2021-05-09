package pl.pjatk.service;

import org.springframework.stereotype.Service;
import pl.pjatk.web.system.model.EnCategory;
import pl.pjatk.web.system.model.MovieModel;

import java.util.List;

@Service
public class MovieService {
    private List<MovieModel> movies;

    public MovieService() {
        this.movies = List.of(
                new MovieModel(1L,"Movie1", EnCategory.Comedy),
                new MovieModel(2L,"Movie2", EnCategory.Horror)
        );
    }

    public List<MovieModel> addMovie (MovieModel addMovie) {
        if (addMovie.getName() == "") {
            return null;
        }

        this.movies.add(addMovie);

        return this.movies;
    }
    public MovieModel update(MovieModel movie) {
        Long movieId = movie.getId();
        MovieModel movieToUpdate = this.getMovie(movieId);
        if(movieToUpdate == null) {
            return null;
        }

        movieToUpdate.setName(movie.getName());
        movieToUpdate.setCategory(movie.getCategory());

        return movieToUpdate;
    }

    public MovieModel getMovie(Long movieId) {
        for (MovieModel movie : this.movies) {
            if (movie.getId().equals(movieId)) {
                return movie;
            }
        }
        return null;
    }

    public List<MovieModel> getAllMovies() {
        return this.movies;
    }

    public boolean removeMovie(Long id){
        return this.movies.removeIf(e -> e.getId().equals(id));
    }
}


