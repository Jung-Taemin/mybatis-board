package com.example.board.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoardUpdateDto {

    private Long id;

    @NotBlank(message = "제목은 필수입니다.")
    private String title;

    @NotBlank(message = "작성자는 필수입니다.")
    private String writer;

    @NotBlank(message = "카테고리는 필수입니다.")
    private String category;

    @NotBlank(message = "내용은 필수입니다.")
    private String content;
}
