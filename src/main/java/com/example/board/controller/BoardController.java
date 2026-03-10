package com.example.board.controller;

import com.example.board.dto.BoardCreateDto;
import com.example.board.dto.BoardUpdateDto;
import com.example.board.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/boards")
    public String list(Model model) {
        model.addAttribute("boardList", boardService.findAll());
        return "board/list";
    }

    @GetMapping("/boards/write")
    public String writeForm(Model model) {
        model.addAttribute("boardCreateDto", new BoardCreateDto());
        return "board/write";
    }

    @PostMapping("/boards/write")
    public String write(@Valid BoardCreateDto boardCreateDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "board/write";
        }

        boardService.save(boardCreateDto);
        return "redirect:/boards";
    }

    @GetMapping("/boards/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("board", boardService.findById(id));
        return "board/detail";
    }

    @PostMapping("/boards/{id}/delete")
    public String delete(@PathVariable Long id) {
        boardService.deleteById(id);
        return "redirect:/boards";
    }

    @GetMapping("/boards/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("boardUpdateDto", boardService.findById(id));
        return "board/edit";
    }

    @PostMapping("/boards/{id}/edit")
    public String edit(@PathVariable Long id,
                       @Valid BoardUpdateDto boardUpdateDto,
                       BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "board/edit";
        }

        boardUpdateDto.setId(id);
        boardService.update(boardUpdateDto);
        return "redirect:/boards/" + id;
    }
}
