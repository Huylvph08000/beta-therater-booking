package com.acazia.betatheater.dto.produce;


import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
@Builder
public class FilmTicketProduceDto {
    private Long filmTicketId;

    private Long filmId;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Double price;

    private Long voucherId;

    private String FilmName;

}
