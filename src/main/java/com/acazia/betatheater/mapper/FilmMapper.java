package com.acazia.betatheater.mapper;

import com.acazia.betatheater.dto.consume.FilmConsumeDto;
import com.acazia.betatheater.dto.produce.FilmProduceDto;
import com.acazia.betatheater.models.Film;
import com.acazia.betatheater.models.FilmCategory;
import com.acazia.betatheater.repository.FilmCategoryRepository;
import com.acazia.betatheater.service.FilmCategoryService;
import com.acazia.betatheater.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
public class FilmMapper {

    @Autowired
    FilmCategoryService filmCategoryService;
    public Optional<Film> toFilm(FilmConsumeDto filmConsumeDto){
        if (Objects.isNull(filmConsumeDto)){
            return Optional.empty();
        }
        Film film = Film.builder()
                .ageLimit(filmConsumeDto.getAgeLimit())
                .description(filmConsumeDto.getDescription())
                .category(filmConsumeDto.getCategory().getCode())
                .type(filmConsumeDto.getType())
                .name(filmConsumeDto.getName())
                .releaseDate(filmConsumeDto.getReleaseDate())
                .information(filmConsumeDto.getInformation())
                .imageUrl(filmConsumeDto.getImageUrl())
                .build();
        return Optional.of(film);
    }
    public Optional<FilmProduceDto> toDetailFilm(Optional<Film> film){
        if (Objects.isNull(film)){
            return Optional.empty();
        }
        FilmProduceDto filmProduceDto = FilmProduceDto.builder()
                .ageLimit(film.get().getAgeLimit())
                .description(film.get().getDescription())
                .name(film.get().getName())
                .information(film.get().getInformation())
                .releaseDate(film.get().getReleaseDate())
                .build();
//        Long categoryId= film.get().getCategory();
//        FilmCategory filmCategory = filmCategoryService.findFilmCategoryById(categoryId.intValue());
//        filmProduceDto.setCategoryName(filmCategory.getName());
        return Optional.of(filmProduceDto);
    }
}
