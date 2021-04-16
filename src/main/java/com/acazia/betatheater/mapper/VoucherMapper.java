package com.acazia.betatheater.mapper;

import com.acazia.betatheater.models.Film;
import com.acazia.betatheater.models.FilmTicket;
import com.acazia.betatheater.models.Voucher;
import com.acazia.betatheater.repository.FilmRepository;
import com.acazia.betatheater.repository.FilmTicketRepository;
import com.acazia.betatheater.repository.VoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class VoucherMapper {
    @Autowired
    VoucherRepository voucherRepository;
    @Autowired
    FilmTicketRepository filmTicketRepository;

    public Double getReduceByProductId(Long productId){
        Optional<FilmTicket> product = filmTicketRepository.findById(productId);
        Optional<Voucher> voucher = voucherRepository.findById(product.get().getVoucherId());
        return voucher.get().getReduce();
    }
}
