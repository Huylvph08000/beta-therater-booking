package com.acazia.betatheater.mapper;

import com.acazia.betatheater.dto.consume.CommentConsumeDto;
import com.acazia.betatheater.models.Comment;
import com.acazia.betatheater.repository.FilmRepository;
import com.acazia.betatheater.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
public class CommentMapper {
    @Autowired
    UserRepository userRepository;
    @Autowired
    FilmRepository filmRepository;

    public Optional<Comment> toComment(CommentConsumeDto commentConsumeDto){
        if (Objects.isNull(commentConsumeDto)){
            return Optional.empty();
        }
        Comment comment = Comment.builder()
                .user(userRepository.findById(commentConsumeDto.getUserId()).get())
                .film(filmRepository.findById(commentConsumeDto.getFilmId()).get())
                .content(commentConsumeDto.getContent())
                .build();
        return Optional.of(comment);
    }
}
