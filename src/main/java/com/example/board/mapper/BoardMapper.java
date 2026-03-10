package com.example.board.mapper;

import com.example.board.dto.BoardCreateDto;
import com.example.board.dto.BoardDetailDto;
import com.example.board.dto.BoardListDto;
import com.example.board.dto.BoardUpdateDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    void save(BoardCreateDto boardCreateDto);
    List<BoardListDto> findAll();
    BoardDetailDto findById(Long id);
    void deleteById(Long id);
    void update(BoardUpdateDto boardUpdateDto);
}
