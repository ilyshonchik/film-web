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
        FiltersSettingsDTO filters = (FiltersSettingsDTO) model.getAttribute("filters");
        List<Film> films = filmRepo.findAll();
        List<FilmSummaryDTO> filmSummaryDTOs = FilmSummaryDTO.fromFilms(films);
        System.out.println(filters);
        model.addAttribute("films", filmSummaryDTOs);

        List<Genre> genres = genreRepo.findAllOrderByName();
        model.addAttribute("genres", genres);
        return "catalog";
    }

    @GetMapping("/film-{filmName}")
    public String getFilm(@PathVariable String filmName, Model model) {
        model.addAttribute("film", filmRepo.findFirstByNameLike(filmName).get());
        return "film";
    }

    @PostMapping("/filter")
    //@ResponseBody
    public String postMethodName(@RequestBody FiltersSettingsDTO entity, Model model
    /*//, RedirectAttributes redirectAttributes*/) {
        List<Genre> genres = genreRepo.findAllOrderByName();
        model.addAttribute("genres", genres);
        //List<Film> films = filmRepo.findAllByFilters(entity.minRating, entity.yearfrom, entity.yearmax);  
        List<Film> films = null;
        if (entity.genres.length == 0) {
            films = filmRepo.findAllByFilters(entity.minRating, entity.yearfrom, entity.yearmax);
        } else {
            LinkedList<Integer> genresId = new LinkedList<Integer>();

            for (int i = 0; i < entity.genres.length; i++) {
                genresId.add(Integer.parseInt(entity.genres[i]));
            }

            films = filmRepo.findAllByFilters(entity.minRating, entity.yearfrom, entity.yearmax, genresId);
        }
        List<FilmSummaryDTO> filmSummaryDTOs = FilmSummaryDTO.fromFilms(films);
        model.addAttribute("films", filmSummaryDTOs);
        //TODO: process POST request
        //redirectAttributes.addFlashAttribute("filters", entity);
        // return "redirect:/";

        //System.out.println(entity.toString());
        return "catalog";
    }
}
