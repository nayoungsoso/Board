package com.dnabplus.board.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnabplus.board.domain.BoardDTO;
import com.dnabplus.board.domain.UserDTO;
import com.dnabplus.board.mapper.UserMapper;

@Service
public class UserService {

	@Autowired
	UserMapper mapper;
	
	public String selectUser(String id) {
		return mapper.selectUser(id);
	}

	public UserDTO selectData(String id) {
		return mapper.selectData(id);
	}
	
	public int insertUser(UserDTO user) {
		return mapper.insertUser(user);
	}
	
	public int deleteUser(String id) {

		return mapper.deleteUser(id);
	}
	
	public int updateUser(UserDTO user) {
		
		return mapper.updateUser(user);
	}

	public String selectNick(String id) {
		return mapper.selectNick(id);
	}
}

