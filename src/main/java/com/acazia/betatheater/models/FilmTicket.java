package com.acazia.betatheater.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "film_ticket")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class FilmTicket extends BaseEntity{
    @Column(name = "film_id")
    private Long filmId;

    @Column(name = "start_date")
    private LocalDateTime start_Date;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "price")
    private Double price;

    @Column(name = "voucher_id")
    private Long voucherId;

//    @ManyToOne
//    @JoinColumn(name = "bill_id")
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @JsonIgnoreProperties("bill")
    private Long billId;
}
