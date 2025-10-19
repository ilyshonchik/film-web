package com.example.gallery.controlers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import models.ModelFilm;


@Controller
@RequestMapping("")
public class MainControler {
    @GetMapping("/")
    public String getMethodName(@RequestParam(required=false) String param, Model model) {

        ArrayList<ModelFilm> film_list = new ArrayList<ModelFilm>(); 
        
        ModelFilm theNorthman2022 = new ModelFilm();
        theNorthman2022.year = 2022;
        theNorthman2022.comment = "Fun movie with one poor casting choice.";
        theNorthman2022.rating = 7;
        theNorthman2022.name = "The Nortman";
        theNorthman2022.pictureUrl = "https://picsum.photos/200";
        film_list.add(theNorthman2022);

        ModelFilm dune2021 = new ModelFilm();
        dune2021.year = 2021;
        dune2021.comment = "";
        dune2021.rating = 8;
        dune2021.name = "Dune";
        dune2021.pictureUrl = "https://picsum.photos/201";
        film_list.add(dune2021);

        ModelFilm dune2024 = new ModelFilm();
        dune2024.year = 2024;
        dune2024.comment = "";
        dune2024.rating = 8;
        dune2024.name = "Dune 2";
        dune2024.pictureUrl = "https://picsum.photos/202";
        film_list.add(dune2024);

        ModelFilm superMan2025 = new ModelFilm();
        superMan2025.year = 2025;
        superMan2025.comment = "Superman in other films was better.";
        superMan2025.rating = 7;
        superMan2025.name = "Superman";
        superMan2025.pictureUrl = "https://picsum.photos/203";
        film_list.add(superMan2025);

        model.addAttribute("film_list", film_list);
        return "film";
    }
}
