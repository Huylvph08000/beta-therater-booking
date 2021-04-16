package com.acazia.betatheater.service;

import com.acazia.betatheater.dto.consume.FilmTicketConsumeDto;
import com.acazia.betatheater.dto.produce.FilmTicketProduceDto;
import com.acazia.betatheater.enums.FilmEnum;
import com.acazia.betatheater.mapper.FilmTicketMapper;
import com.acazia.betatheater.models.Film;
import com.acazia.betatheater.models.FilmTicket;
import com.acazia.betatheater.repository.FilmTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmTicketService {

    @Autowired
    FilmTicketRepository filmTicketRepository;

    @Autowired
    FilmTicketMapper filmTicketMapper;

    public FilmTicket createFilmTicket(FilmTicketConsumeDto filmTicketConsumeDto){
        Optional<FilmTicket> optionalFilm = filmTicketMapper.toFilmTicket(filmTicketConsumeDto);
        FilmTicket filmTicket = new FilmTicket();
        if (optionalFilm.isPresent()){
            filmTicket = optionalFilm.get();
            filmTicket.setAuditingStatus(FilmEnum.AVAILABLE.getCode());
        }
        return filmTicketRepository.save(filmTicket);
    }

    public List<FilmTicket> getAll(){
        return filmTicketRepository.findAll();
    }
    public FilmTicketProduceDto findByFilmsId(Long filmId){
       return filmTicketMapper.toFilmTicketProduce(filmTicketRepository.findByFilmIdIsLike(filmId)).get();
    }

}
