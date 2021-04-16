package com.acazia.betatheater.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "bill")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Bill extends BaseEntity{

//    @OneToMany(mappedBy = "bill", cascade = CascadeType.ALL)
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @JsonIgnoreProperties("bill")
//    private Collection<FilmTicket> filmTicket;
    private Long filmTicketId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "total_expense")
    private Double totalExpense;

    @Column(name = "total_reduce")
    private Double totalReduce;

    @Column(name = "final_expense")
    private Double finalExpense;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "created_date")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(pattern="dd/MM/yyyy hh:mm")
    private LocalDate timeCreated = LocalDate.now();
}
