package com.example.gallery.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.gallery.models.Film;


@Repository
public interface FilmRepository extends JpaRepository<Film, Integer>{
    public Optional<Film> findById(Integer id);

    @Query("SELECT f FROM Film f WHERE f.name LIKE %:name%")
    public Optional<Film> findFirstByNameLike(@Param("name") String name);

    public List<Film> findAllByOrderByNameAsc();
}