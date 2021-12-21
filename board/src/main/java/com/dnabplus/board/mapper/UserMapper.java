package com.dnabplus.board.mapper;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.dnabplus.board.domain.BoardDTO;
import com.dnabplus.board.domain.UserDTO;

@Mapper
public interface UserMapper {
	public String selectUser(String id);
	public int insertUser(UserDTO user);
	public UserDTO selectData(String id);
	public int deleteUser(String id);
	public int updateUser(UserDTO user);
	public String selectNick(String id);
}
