package com.example.board.service;

import com.example.board.dto.BoardCreateDto;
import com.example.board.dto.BoardDetailDto;
import com.example.board.dto.BoardListDto;
import com.example.board.dto.BoardUpdateDto;
import com.example.board.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper boardMapper;

    public void save(BoardCreateDto boardCreateDto) {
        boardMapper.save(boardCreateDto);
    }

    public List<BoardListDto> findAll() {
        return boardMapper.findAll();
    }

    public BoardDetailDto findById(Long id) {
        return boardMapper.findById(id);
    }

    public void deleteById(Long id) {
        boardMapper.deleteById(id);
    }

    public void update(BoardUpdateDto boardUpdateDto) {
        boardMapper.update(boardUpdateDto);
    }
}
