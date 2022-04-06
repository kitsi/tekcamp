package com.teksystems.bootcamp.springboot.movierental.service;

import com.teksystems.bootcamp.springboot.movierental.model.Customer;
import com.teksystems.bootcamp.springboot.movierental.model.Film;
import com.teksystems.bootcamp.springboot.movierental.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;

    public List<Film> getFilms() {
        return filmRepository.findAll();
    }

    public Optional<Film> getFilm(Short id) {
        return filmRepository.findById(id);
    }
}
