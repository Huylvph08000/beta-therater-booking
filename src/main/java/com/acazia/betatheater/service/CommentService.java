package com.acazia.betatheater.service;

import com.acazia.betatheater.dto.consume.CommentConsumeDto;
import com.acazia.betatheater.mapper.CommentMapper;
import com.acazia.betatheater.models.Comment;
import com.acazia.betatheater.models.Film;
import com.acazia.betatheater.repository.CommentRepository;
import com.acazia.betatheater.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;

    @Autowired
    FilmRepository filmRepository;

    @Autowired
    CommentMapper commentMapper;

    public Comment addComment(CommentConsumeDto commentConsumeDto){
        Comment comment = new Comment();
        Optional<Comment> optionalComment = commentMapper.toComment(commentConsumeDto);
        if (optionalComment.isPresent()){
             comment = optionalComment.get();
        }
        return commentRepository.save(comment);
    }
    public Page<Comment> getAllComments(Pageable pageable){
        return commentRepository.findAll(pageable);
    }
}
