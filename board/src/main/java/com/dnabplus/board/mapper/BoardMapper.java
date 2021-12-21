package com.dnabplus.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.dnabplus.board.domain.BoardDTO;
import com.dnabplus.board.domain.UserDTO;

@Mapper
public interface BoardMapper {
	public int countBoard();
	public int insertBoard(BoardDTO board);
	public List<BoardDTO> boardList();
	public BoardDTO selectBoard(String boardNum);
	public int updateBoard(BoardDTO board);
	public int deleteBoard(String boardNum);
}
