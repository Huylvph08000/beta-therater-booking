package com.acazia.betatheater.dto.consume;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmTicketConsumeDto {

    @JsonProperty("film_id")
    private Long filmId;

    @JsonProperty("start_date")
    private LocalDateTime start_date;

    @JsonProperty("end_date")
    private LocalDateTime endDate;

    private Double price;

    @JsonProperty("voucher_id")
    private Long voucherId;

    @JsonProperty("auditing_status")
    private Integer auditingStatus;
}
