package com.example.gallery.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gallery.models.Film;


@Repository
public interface FilmRepository extends JpaRepository<Film, Integer>{
    public Optional<Film> findById(Integer id);
}