package com.acazia.betatheater.dto.consume;

import com.acazia.betatheater.models.FilmTicket;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillConsumeDto {
//    @JsonProperty("film_tickets")
//    private Collection<FilmTicket> filmTicket;
//    private Long filmTicketId;

    private Integer totalItem;

//    @JsonProperty("total_expense")
//    private Double totalExpense;
//
//    @JsonProperty("total_reduce")
//    private Double totalReduce;
//
//    @JsonProperty("final_expense")
//    private Double finalExpense;

//    @JsonProperty("customer_id")
    private Long customerId;

//    @JsonProperty("product_id")
    private Long productId;

//    private Collection<FilmTicket> filmTickets;
}
