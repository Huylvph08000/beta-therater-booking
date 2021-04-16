package com.acazia.betatheater.service;

import com.acazia.betatheater.dto.consume.BillConsumeDto;
import com.acazia.betatheater.dto.produce.BillProduceDto;
import com.acazia.betatheater.mapper.BillMapper;
import com.acazia.betatheater.models.Bill;
import com.acazia.betatheater.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillService {
    @Autowired
    BillRepository billRepository;

    @Autowired
    BillMapper billMapper;

    public Optional<BillProduceDto> getBillDetail(Long billId){
        Optional<Bill> bill = billRepository.findById(billId);
        return billMapper.toDetailBill(bill);
    }
    public Bill createBill(BillConsumeDto billConsumeDto){
        Bill bill = billMapper.toBill(billConsumeDto).get();
        billRepository.save(bill);
        return bill;
    }
    public Page<Bill> getAllBill(Pageable pageable){
        return billRepository.findAll(pageable);
    }

    public Bill getBillById(Long id){
        return billRepository.findById(id).get();
    }
    public Page<Bill> findAllByCustomerId(Long userId, Pageable pageable){
        return billRepository.findAllByCustomerIdIsLike(userId, pageable);
    }
}
