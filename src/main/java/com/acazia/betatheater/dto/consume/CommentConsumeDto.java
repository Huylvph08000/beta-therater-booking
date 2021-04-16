package com.acazia.betatheater.dto.consume;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentConsumeDto {

    private Long userId;

    private Long filmId;

    private String content;
}
