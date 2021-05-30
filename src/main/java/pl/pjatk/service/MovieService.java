package pl.pjatk.service;

import org.springframework.stereotype.Service;
import pl.pjatk.repository.MovieRepository;
import pl.pjatk.web.system.model.MovieModel;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public MovieModel addMovie (MovieModel addMovie) {
        if (addMovie.getName() == "") {
            return null;
        }

        return this.movieRepository.save(addMovie);
    }

    public MovieModel update(MovieModel movie) {
        Long movieId = movie.getId();

        Optional<MovieModel> movieToUpdateOpt = this.movieRepository.findById(movieId);
        if(!movieToUpdateOpt.isPresent()) {
            return null;
        }
        MovieModel movieToUpdate = movieToUpdateOpt.get();
        movieToUpdate.setName(movie.getName());
        movieToUpdate.setCategory(movie.getCategory());

        return this.movieRepository.save(movieToUpdate);
    }

    public MovieModel getMovie(Long movieId) {
        Optional<MovieModel> movieOpt = this.movieRepository.findById(movieId);
        if(!movieOpt.isPresent()) {
            return null;
        }
        return movieOpt.get();
    }

    public List<MovieModel> getAllMovies() {
        return this.movieRepository.findAll();
    }

    public boolean removeMovie(Long id){
        MovieModel movieModel = this.getMovie(id);
        if(movieModel == null){
            return false;
        }
        this.movieRepository.delete(movieModel);

        return true;
    }
}


