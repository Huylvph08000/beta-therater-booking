package com.acazia.betatheater.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "voucher")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Voucher extends BaseEntity{
   @Column(name = "item_id")
    private Long item_id;

   @Column(name = "item_quantity")
   private int item_quantity;

   @Column(name = "from_date")
   private LocalDateTime fromDate;

   @Column(name ="to_date")
    private LocalDateTime toDate;

   @Column(name = "reduce")
    private Double reduce;
}
