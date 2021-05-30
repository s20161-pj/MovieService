package pl.pjatk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pjatk.web.system.model.MovieModel;

public interface MovieRepository extends JpaRepository<MovieModel,Long> {

}
