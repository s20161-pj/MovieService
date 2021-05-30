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
        MovieModel addedModel = this.movieService.addMovie(movieToAdd);

        if(addedModel == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieModel> updateMovie(@RequestBody MovieModel movieToUpdate){
       MovieModel movieUpdated = this.movieService.update(movieToUpdate);

        if(movieUpdated == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id){
        boolean isRemoved = this.movieService.removeMovie(id);
        if(isRemoved) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}


