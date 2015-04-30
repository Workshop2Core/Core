package com.javatrainee.batch27.service;

import com.javatrainee.batch27.entity.LoginHistory;

public interface LoginHistoryService {

	public LoginHistory findLoginHistoryByIdUser(long idUser);
	public void insert(LoginHistory loginHistory);
	public void update(long idLogin, LoginHistory loginHistory);
	public void delete(long idLogin);
	
}
