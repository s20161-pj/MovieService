package pl.pjatk.web.system.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.service.MovieService;
import pl.pjatk.web.system.model.MovieModel;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping()
    public ResponseEntity<List<MovieModel>> getMovies() {
        return ResponseEntity.ok(this.movieService.getAllMovies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieModel> getMovie(@PathVariable Long id) {
        return ResponseEntity.ok(this.movieService.getMovie(id));
    }

    @PostMapping()
    public ResponseEntity addMovie(@RequestBody MovieModel movieToAdd){
        List<MovieModel> movies = this.movieService.addMovie(movieToAdd);

        if(movies == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieModel> updateMovie(@RequestBody MovieModel movieToUpdate){
        MovieModel movie = this.movieService.update(movieToUpdate);

        if(movie == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok().build();
    }
}


