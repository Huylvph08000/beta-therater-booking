package com.acazia.betatheater.dto.produce;

import com.acazia.betatheater.models.FilmTicket;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Collection;

@Data
@Builder
public class BillProduceDto {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("film_ticket")
//    private Collection<FilmTicket> filmTicket;
    private Long filmTicketId;

    @JsonProperty("total_item")
    private Integer totalItem;

    @JsonProperty("total_expense")
    private Double totalExpense;

    @JsonProperty("total_reduce")
    private Double totalReduce;

    @JsonProperty("final_expense")
    private Double finalExpense;

    @JsonProperty("customer_name")
    private String customerName;

    @JsonProperty("film_name")
    private String filmName;
}
