package com.acazia.betatheater.repository;

import com.acazia.betatheater.models.Bill;
import com.acazia.betatheater.models.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long>, JpaSpecificationExecutor<Bill> {
    Page<Bill> findAllByCustomerIdIsLike(Long userId, Pageable pageable);
}
