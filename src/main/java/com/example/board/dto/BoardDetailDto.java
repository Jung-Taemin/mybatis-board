package com.example.board.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDetailDto {
    private Long id;
    private String title;
    private String writer;
    private String category;
    private String content;
    private String createdAt;
}
