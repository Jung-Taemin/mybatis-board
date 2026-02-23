package com.example.mybatisboard.domain.board.service;

import com.example.mybatisboard.domain.board.dto.BoardCreateRequest;
import com.example.mybatisboard.domain.board.dto.BoardResponse;
import com.example.mybatisboard.domain.board.dto.BoardUpdateRequest;
import com.example.mybatisboard.domain.board.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper boardMapper;

    public List<BoardResponse> findAll() {
        return boardMapper.findAll();
    }

    @Transactional
    public BoardResponse findDetail(Long id) {
        boardMapper.increaseHits(id);
        BoardResponse board = boardMapper.findById(id);
        if (board == null) throw new IllegalArgumentException("게시글 없음");
        return board;
    }

    @Transactional
    public void create(BoardCreateRequest req) {
        boardMapper.insert(req);
    }

    @Transactional
    public void update(Long id, BoardUpdateRequest req) {
        BoardResponse board = boardMapper.findById(id);
        if (board == null) throw new IllegalArgumentException("게시글 없음");
        boardMapper.update(id, req);
    }

    @Transactional
    public void delete(Long id) {
        boardMapper.delete(id);
    }
}
