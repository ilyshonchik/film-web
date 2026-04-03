package com.example.gallery.dto;
import java.util.LinkedList;
import java.util.List;

import com.example.gallery.models.Film;

public class FilmSummaryDTO {

    public int id; 
    public String title = "";
    public int year = 0;
    public String duration = "";
    public Integer genre = 0;
    public float rating = 0.0f;
    public String posterUrl = "";
    public String badge = "";
    
    public static List<FilmSummaryDTO> fromFilms(List<Film> films) {
        List<FilmSummaryDTO> dto = new LinkedList<FilmSummaryDTO>();
        for (Film resource : films){
            dto.add(fromFilm(resource));
        }
        return dto;
    }

    public static FilmSummaryDTO fromFilm(Film film) {
        FilmSummaryDTO dto = new FilmSummaryDTO();
        dto.id = film.id;
        dto.title = film.name;
        dto.year = film.year;
        dto.genre = film.genre;
        dto.rating = film.rating;
        return dto;
    }
}
