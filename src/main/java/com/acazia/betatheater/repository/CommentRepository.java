package com.acazia.betatheater.repository;

import com.acazia.betatheater.models.Bill;
import com.acazia.betatheater.models.Comment;
import com.acazia.betatheater.models.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CommentRepository extends JpaRepository<Comment, Long>, JpaSpecificationExecutor<Comment> {
}
