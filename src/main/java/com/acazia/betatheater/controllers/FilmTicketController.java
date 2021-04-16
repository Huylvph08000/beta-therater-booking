package com.acazia.betatheater.controllers;

import com.acazia.betatheater.base.BaseResponseDto;
import com.acazia.betatheater.dto.consume.FilmTicketConsumeDto;
import com.acazia.betatheater.dto.produce.FilmTicketProduceDto;
import com.acazia.betatheater.models.FilmTicket;
import com.acazia.betatheater.service.FilmTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/film/tickets")
public class FilmTicketController {

    @Autowired
    FilmTicketService filmTicketService;

    @PostMapping
    public  FilmTicket createFilm(@RequestBody FilmTicketConsumeDto filmTicketConsumeDto){
        return filmTicketService.createFilmTicket(filmTicketConsumeDto);
    }
    @GetMapping
    public List<FilmTicket> filmTickets(){
        return filmTicketService.getAll();
    }

    @GetMapping("/film/{id}")
    public FilmTicketProduceDto getFilmTicketByFilmId(@PathVariable("id") Long id){
        return filmTicketService.findByFilmsId(id);
    }
}
