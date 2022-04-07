package com.teksystems.bootcamp.springboot.movierental.service;

import com.teksystems.bootcamp.springboot.movierental.model.Customer;
import com.teksystems.bootcamp.springboot.movierental.model.Film;
import com.teksystems.bootcamp.springboot.movierental.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;

    public Page<Film> getFilms(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<Film> films = filmRepository.findAll(pageable);
        return films;
    }

    public Optional<Film> getFilm(Short id) {
        return filmRepository.findById(id);
    }
}
