package com.acazia.betatheater.repository;

import com.acazia.betatheater.models.FilmTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmTicketRepository extends JpaRepository<FilmTicket, Long> {
    FilmTicket findByFilmIdIsLike(Long id);
}
