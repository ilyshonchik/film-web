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
        dune2021.pictureUrl = "https://picsum.photos/200";
        film_list.add(dune2021);

        ModelFilm dune2024 = new ModelFilm();
        dune2024.year = 2024;
        dune2024.comment = "";
        dune2024.rating = 8;
        dune2024.name = "Dune 2";
        dune2024.pictureUrl = "https://picsum.photos/200";
        film_list.add(dune2024);

        ModelFilm superMan2025 = new ModelFilm();
        superMan2025.year = 2025;
        superMan2025.comment = "Superman in other films was better.";
        superMan2025.rating = 7;
        superMan2025.name = "Superman";
        superMan2025.pictureUrl = "https://picsum.photos/200";
        film_list.add(superMan2025);

        ModelFilm homeAlone1990 = new ModelFilm();
        homeAlone1990.year = 1990;
        homeAlone1990.comment = "The GOAT new year movie!";
        homeAlone1990.rating = 8;
        homeAlone1990.name = "Home alone 1";
        homeAlone1990.pictureUrl = "https://picsum.photos/200";
        film_list.add(homeAlone1990);

        ModelFilm homeAlone1992 = new ModelFilm();
        homeAlone1992.year = 1992;
        homeAlone1992.comment = "First was better.";
        homeAlone1992.rating = 7;
        homeAlone1992.name = "Home alone 2";
        homeAlone1992.pictureUrl = "https://picsum.photos/200";
        film_list.add(homeAlone1992);

        ModelFilm homeAlone1997 = new ModelFilm();
        homeAlone1997.year = 1997;
        homeAlone1997.comment = "It was the worst.";
        homeAlone1997.rating = 5;
        homeAlone1997.name = "Home alone 3";
        homeAlone1997.pictureUrl = "https://picsum.photos/200";
        film_list.add(homeAlone1997);

        ModelFilm homeAlone2012 = new ModelFilm();
        homeAlone2012.year = 2025;
        homeAlone2012.comment = "";
        homeAlone2012.rating = 7;
        homeAlone2012.name = "Home alone 5";
        homeAlone2012.pictureUrl = "https://picsum.photos/203";
        film_list.add(homeAlone2012);

        ModelFilm homeAlone2021 = new ModelFilm();
        homeAlone2021.year = 2021;
        homeAlone2021.comment = "";
        homeAlone2021.rating = 3;
        homeAlone2021.name = "Home alone 6";
        homeAlone2021.pictureUrl = "https://picsum.photos/203";
        film_list.add(homeAlone2021);

        ModelFilm greenMile = new ModelFilm();
        greenMile.year = 1999;
        greenMile.comment = "All was crying..";
        greenMile.rating = 9;
        greenMile.name = "The Green Mile";
        greenMile.pictureUrl = "https://picsum.photos/203";
        film_list.add(greenMile);

        ModelFilm bingoBongo1982 = new ModelFilm();
        bingoBongo1982.year = 1982;
        bingoBongo1982.comment = "";
        bingoBongo1982.rating = 9;
        bingoBongo1982.name = "Bingo bongo";
        bingoBongo1982.pictureUrl = "https://picsum.photos/203";
        film_list.add(bingoBongo1982);

        ModelFilm bluff = new ModelFilm();
        bluff.year = 1976;
        bluff.comment = "";
        bluff.rating = 10;
        bluff.name = "Bluff";
        bluff.pictureUrl = "https://picsum.photos/203";
        film_list.add(bluff);

        ModelFilm heIsWorseThanMe1985 = new ModelFilm();
        heIsWorseThanMe1985.year = 1985;
        heIsWorseThanMe1985.comment = "Superman in other films was better.";
        heIsWorseThanMe1985.rating = 9;
        heIsWorseThanMe1985.name = "He is worse than me";
        heIsWorseThanMe1985.pictureUrl = "https://picsum.photos/203";
        film_list.add(heIsWorseThanMe1985);


        model.addAttribute("film_list", film_list);
        return "film";
    }
}
