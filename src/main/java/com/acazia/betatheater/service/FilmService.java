package com.acazia.betatheater.service;

import com.acazia.betatheater.dto.consume.FilmConsumeDto;
import com.acazia.betatheater.enums.FilmEnum;
import com.acazia.betatheater.mapper.FilmMapper;
import com.acazia.betatheater.models.Film;
import com.acazia.betatheater.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FilmService {
    @Autowired
    FilmRepository filmRepository;

    @Autowired
    FilmMapper filmMapper;

    public Page<Film> getAllFilms(Pageable pageable){
        return filmRepository.findAllByAuditingStatus(FilmEnum.AVAILABLE.getCode(), pageable);
    }

    public Page<Film> getAllFilmsPlaying(Pageable pageable){
        return filmRepository.findAllByAuditingStatus(FilmEnum.PLAYING.getCode(), pageable);
    }
    public Film createFilm(FilmConsumeDto  filmConsumeDto){
        Optional<Film> optionalFilm = filmMapper.toFilm(filmConsumeDto);
        Film film = new Film();
        if (optionalFilm.isPresent()){
          film = optionalFilm.get();
          film.setAuditingStatus(FilmEnum.AVAILABLE.getCode());
        }
        filmRepository.save(film);
        return film;
    }
}
