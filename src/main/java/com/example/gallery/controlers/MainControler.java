package com.example.gallery.controlers;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.gallery.dto.FilmSummaryDTO;
import com.example.gallery.dto.FiltersSettingsDTO;
import com.example.gallery.models.Film;
import com.example.gallery.models.Genre;
import com.example.gallery.repositories.FilmRepository;
import com.example.gallery.repositories.GenreRepository;
@Controller
@RequestMapping("")
public class MainControler {

    @Autowired
    FilmRepository filmRepo;

    @Autowired
    GenreRepository genreRepo;

    @GetMapping("/")
    public String getMainPage(Model model) {
        FiltersSettingsDTO filters = (FiltersSettingsDTO)model.getAttribute("filters");
        List<Film> films = filmRepo.findAll();  
        // Частичная конвертация списка фильмов в  список ДТО 

        System.out.println(filters);
        List<FilmSummaryDTO> filmsDTO = new LinkedList<FilmSummaryDTO>();
        filmsDTO.add(new FilmSummaryDTO());
        model.addAttribute("films", filmsDTO);
  
        List<Genre> genres = genreRepo.findAll();
        model.addAttribute("genres", genres);
        return "catalog";
    }

    @GetMapping("/film-{filmName}")
    public String getFilm(@PathVariable String filmName, Model model) {
        model.addAttribute("film", filmRepo.findFirstByNameLike(filmName).get());
        return "film";
    }

    @PostMapping("/")
    //@ResponseBody
    public String postMethodName(@RequestBody FiltersSettingsDTO entity,
        RedirectAttributes redirectAttributes) {
        //TODO: process POST request
        redirectAttributes.addFlashAttribute("filters", entity);
        return "redirect:/";
        
    }
}
