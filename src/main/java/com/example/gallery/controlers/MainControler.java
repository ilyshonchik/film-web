package com.example.gallery.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.gallery.models.Film;
import com.example.gallery.repositories.FilmRepository;

@Controller
@RequestMapping("")
public class MainControler {
    
    @Autowired
    FilmRepository filmRepo;

    @GetMapping("/")
    public String getMainPage(@RequestParam(required = false) String param, Model model) {

        List<Film> table = filmRepo.findAllByOrderByNameAsc();
        model.addAttribute("film_list", table);
        return "main";
    }

    @GetMapping("/film-{filmName}")
    public String getFilm(@PathVariable String filmName, Model model) {
        model.addAttribute("name", filmName);
        return "film";
    }

}
