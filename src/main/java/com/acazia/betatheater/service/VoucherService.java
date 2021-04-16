package com.acazia.betatheater.service;

import com.acazia.betatheater.mapper.VoucherMapper;
import com.acazia.betatheater.models.Voucher;
import com.acazia.betatheater.repository.VoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class VoucherService {
    @Autowired
    VoucherRepository voucherRepository;

    @Autowired
    VoucherMapper voucherMapper;

    public Voucher createVoucher(Voucher voucher){
      return voucherRepository.save(voucher);
    }
    public Page<Voucher> getAll(Pageable pageable){
        return voucherRepository.findAll(pageable);
    }
}
