package com.example.gallery.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.gallery.repositories.FilmRepository;


@RestController
@RequestMapping("/rest")
public class MainRestControler {
    
    @Autowired
    FilmRepository filmRepo;

    @GetMapping("/")
    public String getMainPage(@RequestParam(required = false) String param, Model model) {

        // model.addAttribute("film_list", null);
        return filmRepo.findAll().toString();
    }

    @GetMapping("/film-{filmName}")
    public String getFilm(@PathVariable String filmName, Model model) {
        // model.addAttribute("name", filmName);
        return filmRepo.findFirstByNameLike(filmName).toString();
    }

}
