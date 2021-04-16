package com.acazia.betatheater.mapper;

import com.acazia.betatheater.dto.consume.FilmConsumeDto;
import com.acazia.betatheater.dto.consume.FilmTicketConsumeDto;
import com.acazia.betatheater.dto.produce.FilmTicketProduceDto;
import com.acazia.betatheater.models.Film;
import com.acazia.betatheater.models.FilmTicket;
import com.acazia.betatheater.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
public class FilmTicketMapper {
    @Autowired
    FilmRepository filmRepository;
    public Optional<FilmTicket> toFilmTicket(FilmTicketConsumeDto filmTicketConsumeDto){
        if (Objects.isNull(filmTicketConsumeDto)){
            return Optional.empty();
        }
        FilmTicket filmTicket = FilmTicket.builder()
                .endDate(filmTicketConsumeDto.getEndDate())
                .filmId(filmTicketConsumeDto.getFilmId())
                .price(filmTicketConsumeDto.getPrice())
                .start_Date(filmTicketConsumeDto.getStart_date())
                .voucherId(filmTicketConsumeDto.getVoucherId())
                .auditingStatus(filmTicketConsumeDto.getAuditingStatus())
                .id(filmTicketConsumeDto.getFilmId())
                .build();
//        Film film = filmRepository.findById(filmTicket.getFilmId()).get();
//        filmTicket.setF
        return Optional.of(filmTicket);
    }
    public Optional<FilmTicketProduceDto> toFilmTicketProduce(FilmTicket filmTicket){
        if (Objects.isNull(filmTicket)){
            return Optional.empty();
        }
        FilmTicketProduceDto filmTicketProduceDto = FilmTicketProduceDto.builder()
                .filmId(filmTicket.getFilmId())
                .FilmName(filmRepository.findById(filmTicket.getFilmId()).get().getName())
                .price(filmTicket.getPrice())
                .filmTicketId(filmTicket.getId())
                .build();
        return Optional.of(filmTicketProduceDto);
    }
}
