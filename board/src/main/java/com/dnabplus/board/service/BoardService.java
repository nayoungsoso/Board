package com.dnabplus.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnabplus.board.domain.BoardDTO;
import com.dnabplus.board.domain.UserDTO;
import com.dnabplus.board.mapper.BoardMapper;
import com.dnabplus.board.mapper.UserMapper;

@Service
public class BoardService {

	@Autowired
	BoardMapper mapper;
	
	public int countBoard() {
		return mapper.countBoard();
	}
	
	public List<BoardDTO> boardList() {
		return mapper.boardList();
	}
	
	public int insertBoard(BoardDTO board) {
		return mapper.insertBoard(board);
	}
	
	public BoardDTO selectBoard(String boardNum) {
		return mapper.selectBoard(boardNum);
	}
	
	public int updateBoard(BoardDTO board) {
		
		return mapper.updateBoard(board);
	}
	public int deleteBoard(String boardNum) {

		return mapper.deleteBoard(boardNum);
	}
}
