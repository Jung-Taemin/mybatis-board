package com.example.mybatisboard.domain.board.dto;

import java.time.LocalDateTime;

public record BoardResponse(
        Long id,
        String title,
        String content,
        String writer,
        int hits,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
