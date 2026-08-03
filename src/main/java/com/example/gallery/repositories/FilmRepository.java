package com.example.gallery.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.gallery.models.Film;


@Repository
public interface FilmRepository extends JpaRepository<Film, Integer>, JpaSpecificationExecutor<Film>{
    public Optional<Film> findById(Integer id);

    @Query("SELECT f FROM Film f WHERE f.name LIKE %:name%")
    public Optional<Film> findFirstByNameLike(@Param("name") String name);

    public List<Film> findAllByOrderByNameAsc();
    public List<Film> findAllByOrderByNameDesc();
    public List<Film> findAllByNsfmTrue();

    @Query("""
        SELECT u
        FROM Film u
        WHERE (u.rating >= :rating)
    """)
    public List<Film> findAllWhereRatingGreterThan(int rating);

    
    @Query("""
        SELECT u
        FROM Film u
        WHERE (u.rating >= :minRating) AND (u.year >= :yearfrom) AND (u.year < :yearmax)
    """)
    public List<Film> findAllByFilters(
    @Param("minRating") int minRating, 
    @Param("yearfrom") int yearfrom, 
    @Param("yearmax") int yearmax);
    
    @Query("""
        SELECT u
        FROM Film u
        WHERE (u.rating >= :minRating) AND (u.year >= :yearfrom) AND (u.year < :yearmax) AND (u.genre IN :genres)
    """)
    public List<Film> findAllByFilters(
    @Param("minRating") int minRating, 
    @Param("yearfrom") int yearfrom, 
    @Param("yearmax") int yearmax,
    @Param("genres") List<Integer> genres);
}