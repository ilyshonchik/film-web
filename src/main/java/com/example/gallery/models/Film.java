package com.example.gallery.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table (name = "film_table", schema = "film_database")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(length = 100)
    public String name;

    @Column(name = "release_year")
    public Short year;

    @Column(name = "rating")
    public Float rating;

    @Column(name = "genre")
    public Integer genre;

    @Column(name = "nsfm")
    public boolean nsfm = false;
}