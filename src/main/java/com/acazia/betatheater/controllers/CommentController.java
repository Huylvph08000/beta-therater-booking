package com.acazia.betatheater.controllers;

import com.acazia.betatheater.dto.consume.CommentConsumeDto;
import com.acazia.betatheater.mapper.CommentMapper;
import com.acazia.betatheater.models.Comment;
import com.acazia.betatheater.repository.CommentRepository;
import com.acazia.betatheater.service.CommentService;
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
@RequestMapping("/api/comments")
public class CommentController {
    @Autowired
    CommentService commentService;
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    CommentRepository commentRepository;

    @PostMapping
    public Comment createComment(@RequestBody CommentConsumeDto commentConsumeDto){
        return commentService.addComment(commentConsumeDto);
    }

    @GetMapping
    public ResponseEntity getAllComments(@RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "5") int size){
        try{
            List<Comment> comments = new ArrayList<>();
            Pageable paging = PageRequest.of(page, size);
            Page<Comment> commentPage = commentService.getAllComments(paging);
            comments = commentPage.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("comments", comments);
            response.put("currentPage", commentPage.getNumber());
            response.put("totalItems", commentPage.getTotalElements());
            response.put("totalPages", commentPage.getTotalPages());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
