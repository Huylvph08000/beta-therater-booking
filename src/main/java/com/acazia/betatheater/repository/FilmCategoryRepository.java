package com.acazia.betatheater.repository;

import com.acazia.betatheater.models.Bill;
import com.acazia.betatheater.models.FilmCategory;
import com.acazia.betatheater.models.FilmTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface FilmCategoryRepository extends JpaRepository<FilmCategory, Long>, JpaSpecificationExecutor<FilmCategory> {
    Optional<FilmCategory> findByIdIsLike(Integer id);
}
