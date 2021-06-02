package pl.pjatk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import pl.pjatk.web.system.model.MovieModel;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<MovieModel,Long> {

    @Query("select m from MovieModel m")
    List<MovieModel> findAll();

    @Transactional
    @Modifying
    @Query("delete from MovieModel m WHERE m.id =:#{#m.id}")
    void delete(@Param("m") MovieModel movieModel);

    @Query("select m from MovieModel m WHERE m.id =:id")
    Optional<MovieModel> findById(Long id);

    @Transactional
    @Modifying
    @Query(value = "insert into MovieModel (name, category) "
            + "VALUES (:#{#m.name},:#{#m.category})", nativeQuery = true)
    MovieModel save(@Param("m") MovieModel movieModel);

    @Transactional
    @Modifying
    @Query(value = "Update movie m set m.name = :#{#m.name}, m.is_available = :#{#m.isAvailable}  where m.id = :#{#m.id}", nativeQuery = true)
    void update(@Param("m") MovieModel movieModel);

}