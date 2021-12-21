package com.dnabplus.board.domain;

import java.time.LocalDateTime;

public class UserDTO {
	
	private String id;
	
	private String passwd;
	
	private String nickN;
	
	private String phone;
	
	private String email;
	
	private LocalDateTime joinDate;
	
	private String name;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getNickN() {
		return nickN;
	}

	public void setNickN(String nickN) {
		this.nickN = nickN;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDateTime joinDate) {
		this.joinDate = joinDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
