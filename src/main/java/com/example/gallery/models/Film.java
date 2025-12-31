package com.example.gallery.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "film_table")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100)
    private String name;

    @Column(name = "release_year")
    private Short year;

    @Column(name = "rating")
    private Float rating;

    @Column(length = 500, name = "pictureUrl")
    private String pictureURL;

    @Column(name = "genre")
    private Integer genre;

}