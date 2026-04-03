
package com.example.gallery.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.gallery.models.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer>{
    public Optional<Genre> findById(Integer id);

    @Query("""
        SELECT u
        FROM Genre u
        ORDER BY u.name asc
    """)
    public List<Genre> findAllOrderByName();

    // public List<Genre> findAllOrderById();
}