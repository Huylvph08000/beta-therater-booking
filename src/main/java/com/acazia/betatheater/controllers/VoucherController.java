package com.acazia.betatheater.controllers;

import com.acazia.betatheater.models.Voucher;
import com.acazia.betatheater.service.VoucherService;
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
@RequestMapping("/api/vouchers")
public class VoucherController {
    @Autowired
    VoucherService voucherService;

    @GetMapping
    public ResponseEntity getAllVouchers( @RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "5") int size){
        try {
            List<Voucher> vouchers = new ArrayList<Voucher>();
            Pageable paging = PageRequest.of(page, size);
            Page<Voucher> voucherPage = voucherService.getAll(paging);
            vouchers = voucherPage.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("vouchers", vouchers);
            response.put("currentPage", voucherPage.getNumber());
            response.put("totalItems", voucherPage.getTotalElements());
            response.put("totalPages", voucherPage.getTotalPages());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
