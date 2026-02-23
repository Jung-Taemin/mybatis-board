package com.example.mybatisboard.domain.board.mapper;

import com.example.mybatisboard.domain.board.dto.BoardCreateRequest;
import com.example.mybatisboard.domain.board.dto.BoardResponse;
import com.example.mybatisboard.domain.board.dto.BoardUpdateRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<BoardResponse> findAll();

    BoardResponse findById(@Param("id") Long id);

    void insert(@Param("req") BoardCreateRequest req);

    void update(@Param("id") Long id, @Param("req") BoardUpdateRequest req);

    void delete(@Param("id") Long id);

    void increaseHits(@Param("id") Long id);
}
