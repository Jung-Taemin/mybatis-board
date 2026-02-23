package com.example.mybatisboard.domain.board.controller;

import com.example.mybatisboard.domain.board.dto.BoardCreateRequest;
import com.example.mybatisboard.domain.board.dto.BoardUpdateRequest;
import com.example.mybatisboard.domain.board.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/boards")
public class BoardController {

    private final BoardService boardService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("boards", boardService.findAll());
        return "board/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("board", boardService.findDetail(id));
        return "board/detail";
    }

    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("form", new BoardCreateRequest("", "", ""));
        return "board/form";
    }

    @PostMapping
    public String create(@ModelAttribute("form") @Valid BoardCreateRequest form,
                         BindingResult br) {
        if (br.hasErrors()) return "board/form";
        boardService.create(form);
        return "redirect:/boards";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        var board = boardService.findDetail(id); // 조회수 늘리기 싫으면 findById용 메서드 따로 빼도 됨
        model.addAttribute("id", id);
        model.addAttribute("form", new BoardUpdateRequest(board.title(), board.content()));
        return "board/form";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Long id,
                         @ModelAttribute("form") @Valid BoardUpdateRequest form,
                         BindingResult br) {
        if (br.hasErrors()) return "board/form";
        boardService.update(id, form);
        return "redirect:/boards/" + id;
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        boardService.delete(id);
        return "redirect:/boards";
    }
}