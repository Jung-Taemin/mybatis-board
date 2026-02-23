package com.example.mybatisboard.domain.board.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record BoardUpdateRequest(
        @NotBlank @Size(max = 200) String title,
        @NotBlank String content
) {
}
