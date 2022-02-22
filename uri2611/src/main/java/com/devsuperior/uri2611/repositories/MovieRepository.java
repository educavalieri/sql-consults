package com.devsuperior.uri2611.repositories;

import com.devsuperior.uri2611.dto.MovieDTO;
import com.devsuperior.uri2611.entities.Movie;
import com.devsuperior.uri2611.projections.MovieMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query(nativeQuery = true, value = "select movies.id, movies.name "
            + "from public.movies "
            + "inner join genres on movies.id_genres = genres.id "
            + "where genres.description = :genreName "
            )
    List<MovieMinProjection> search1(String genreName);

    @Query("select new com.devsuperior.uri2611.dto.MovieDTO(obj.id, obj.name) "
            + "from Movie obj "
            + "where obj.genre.description = :genreName"
            )
    List<MovieDTO> search2(String genreName);
}
