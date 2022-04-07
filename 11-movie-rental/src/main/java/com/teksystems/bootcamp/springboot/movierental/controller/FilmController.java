package com.teksystems.bootcamp.springboot.movierental.controller;

import com.teksystems.bootcamp.springboot.movierental.model.Film;
import com.teksystems.bootcamp.springboot.movierental.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/films")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @GetMapping("/")
    public Page<Film> getFilms(
            @RequestParam(value = "pageNum", defaultValue = "0", required = false) int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize
    ) {
        return filmService.getFilms(pageNum, pageSize);
    }

    @GetMapping("/{id}")
    public Optional<Film> getFilm(@PathVariable(value = "id") Short id) {
        return filmService.getFilm(id);
    }

}
