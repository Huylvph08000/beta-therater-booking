package com.acazia.betatheater.controllers;

import com.acazia.betatheater.dto.consume.BillConsumeDto;
import com.acazia.betatheater.dto.consume.FilmConsumeDto;
import com.acazia.betatheater.dto.produce.BillProduceDto;
import com.acazia.betatheater.mapper.BillMapper;
import com.acazia.betatheater.models.Bill;
import com.acazia.betatheater.models.Film;
import com.acazia.betatheater.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/bills")
public class BillController {

    @Autowired
    BillService billService;
    @Autowired
    BillMapper billMapper;

    @GetMapping("/{id}")
    public BillProduceDto getDetailById(@PathVariable("id") Long id){
        return billService.getBillDetail(id).get();
    }

    @GetMapping("user/{id}")
    public ResponseEntity getAllBillByCustomerId(@PathVariable("id") Long id,
                                             @RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "5") int size){
        try {
            List<Bill> bills = new ArrayList<Bill>();
            Pageable paging = PageRequest.of(page, size);
            Page<Bill> billPage = billService.findAllByCustomerId(id, paging);
            bills = billPage.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("bills", bills);
            response.put("currentPage", billPage.getNumber());
            response.put("totalItems", billPage.getTotalElements());
            response.put("totalPages", billPage.getTotalPages());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity getAllBill(
    @RequestParam(defaultValue = "0") int page,
    @RequestParam(defaultValue = "5") int size){
        try {
            List<Bill> bills = new ArrayList<Bill>();
            Pageable paging = PageRequest.of(page, size);
            Page<Bill> billPage = billService.getAllBill(paging);
            bills = billPage.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("bills", bills);
            response.put("currentPage", billPage.getNumber());
            response.put("totalItems", billPage.getTotalElements());
            response.put("totalPages", billPage.getTotalPages());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public Bill createFilm(@RequestBody BillConsumeDto billConsumeDto){
        return billService.createBill(billConsumeDto);
    }
}
