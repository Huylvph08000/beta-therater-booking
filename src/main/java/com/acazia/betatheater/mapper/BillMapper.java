package com.acazia.betatheater.mapper;


import com.acazia.betatheater.dto.consume.BillConsumeDto;
import com.acazia.betatheater.dto.produce.BillProduceDto;
import com.acazia.betatheater.enums.BillStatus;
import com.acazia.betatheater.models.Bill;
import com.acazia.betatheater.models.FilmTicket;
import com.acazia.betatheater.repository.FilmRepository;
import com.acazia.betatheater.repository.FilmTicketRepository;
import com.acazia.betatheater.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
public class BillMapper {

    @Autowired
    VoucherMapper voucherMapper;

    @Autowired
    FilmTicketRepository filmTicketRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    FilmRepository filmRepository;

    public Optional<BillProduceDto> toDetailBill(Optional<Bill> originBill){
        if (Objects.isNull(originBill)){
            return Optional.empty();
        }
        BillProduceDto billProduceDto = BillProduceDto.builder()
                .id(originBill.get().getId())
                .customerName(userRepository.findById(originBill.get().getCustomerId()).get().getUsername())
                .filmTicketId(originBill.get().getFilmTicketId())
                .filmName(filmRepository.findById(filmTicketRepository.findById(originBill.get().getFilmTicketId()).get().getFilmId()).get().getName())
                .totalItem(originBill.get().getQuantity())
                .finalExpense(originBill.get().getFinalExpense())
                .totalExpense(originBill.get().getTotalExpense())
                .totalReduce(originBill.get().getTotalReduce())
                .build();

        return Optional.of(billProduceDto);
    }
    public Optional<Bill> toBill(BillConsumeDto billConsumeDto){
        if (Objects.isNull(billConsumeDto)){
            return Optional.empty();
        }
        Bill bill = Bill.builder()
                .auditingStatus(BillStatus.NEW.getCode())
                .customerId(billConsumeDto.getCustomerId())
                .filmTicketId(billConsumeDto.getProductId())
                .quantity(billConsumeDto.getTotalItem())
                .totalExpense(countTotalExpense(billConsumeDto.getTotalItem(), billConsumeDto.getProductId()))
                .totalReduce(getTotalReduce(billConsumeDto.getProductId(), billConsumeDto.getTotalItem()))
                .finalExpense((countTotalExpense(billConsumeDto.getTotalItem(), billConsumeDto.getProductId()) - getTotalReduce(billConsumeDto.getProductId(), billConsumeDto.getTotalItem())))
                .build();
        return Optional.of(bill);
    }

    public Double countFinalExpense(Double totalExpense, Double totalReduce){
        return (totalExpense - totalReduce);
    }
    public Double countTotalExpense(Integer totalItem, Long itemId){
        FilmTicket item = filmTicketRepository.findByFilmIdIsLike(itemId);
        return (item.getPrice()) * totalItem;
    }


//    public Double getTotalReduce( Collection<FilmTicket> filmTickets){
//        AtomicReference<Double> totalReduce = new AtomicReference<>(0.0);
//        filmTickets.forEach(filmTicket -> {
//            totalReduce.updateAndGet(v -> v + voucherMapper.getReduceByProductId(filmTicket.getFilmId()));
//        });
//        return totalReduce.get();
//    }
    public Double getTotalReduce(Long filmTicketId, Integer totalItems){
     return   voucherMapper.getReduceByProductId(filmTicketId) * totalItems;

    }
}
