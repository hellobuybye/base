package com.cyh.base.mapper;


import com.cyh.base.dto.BoardDto;
import com.cyh.base.dto.UserDto;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

	public UserDto selectLoginUser(String userId);

	// public List<BoardDto> getBoardList(BoardDto boardDto) throws Exception;

	// public Integer getBoardListCount(BoardDto boardDto) throws Exception;

	

	// public void insertBoard(BoardDto boardDto) throws Exception;

	// public void updateBoard(BoardDto boardDto) throws Exception;
	
	// public void deleteBoard(BoardDto boardDto) throws Exception;


}
