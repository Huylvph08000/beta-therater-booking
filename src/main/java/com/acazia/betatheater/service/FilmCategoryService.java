package com.acazia.betatheater.service;

import com.acazia.betatheater.models.FilmCategory;
import com.acazia.betatheater.repository.FilmCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmCategoryService {
    @Autowired
    FilmCategoryRepository filmCategoryRepository;

    public FilmCategory findFilmCategoryById(Integer id){
        return filmCategoryRepository.findByIdIsLike(id).get();
    }
}
