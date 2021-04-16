package com.acazia.betatheater.controllers;

import com.acazia.betatheater.base.BaseResponseDto;
import com.acazia.betatheater.dto.consume.FilmConsumeDto;
import com.acazia.betatheater.models.Film;
import com.acazia.betatheater.repository.FilmRepository;
import com.acazia.betatheater.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/films")
public class FilmController {

    @Autowired
    FilmService filmService;

    @Autowired
    FilmRepository filmRepository;


    @GetMapping
    public ResponseEntity<BaseResponseDto> getAllFilms(){
        return ResponseEntity.ok(BaseResponseDto.success(filmRepository.findAll(), "Get films successfully!"));
    }

//    @GetMapping
//    public ResponseEntity getAllFilms(@RequestParam(defaultValue = "0") int page,
//                                      @RequestParam(defaultValue = "5") int size) {
//        try {
//            List<Film> filmList = new ArrayList<Film>();
//            Pageable paging = PageRequest.of(page, size);
//            Page<Film> filmPage = filmService.getAllFilms(paging);
//            filmList = filmPage.getContent();
//
//            Map<String, Object> response = new HashMap<>();
//            response.put("filmList", filmList);
//            response.put("currentPage", filmPage.getNumber());
//            response.put("totalItems", filmPage.getTotalElements());
//            response.put("totalPages", filmPage.getTotalPages());
//            return new ResponseEntity<>(response, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
    @GetMapping("/playing")
    public ResponseEntity getAllFilmsPlaying(@RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "5") int size) {
        try {
            List<Film> filmList = new ArrayList<Film>();
            Pageable paging = PageRequest.of(page, size);
            Page<Film> filmPage = filmService.getAllFilmsPlaying(paging);
            filmList = filmPage.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("filmList", filmList);
            response.put("currentPage", filmPage.getNumber());
            response.put("totalItems", filmPage.getTotalElements());
            response.put("totalPages", filmPage.getTotalPages());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{id}")
    public Film getById(@PathVariable("id" ) Long id){
        return filmRepository.findById(id).get();
    }

    @PostMapping
    public  Film createFilm(@RequestBody FilmConsumeDto filmConsumeDto){
       return filmService.createFilm(filmConsumeDto);
    }

}
