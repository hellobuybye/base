package com.cyh.base.mapper;


import com.cyh.base.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {


	public List<BoardDto> getBoardList(BoardDto boardDto) throws Exception;

	public Integer getBoardListCount(BoardDto boardDto) throws Exception;

	// public void insertBoard(BoardDto boardDto) throws Exception;

	// public BoardDto getBoardView(BoardDto boardDto) throws Exception;

	// public void updateBoard(BoardDto boardDto) throws Exception;


}
