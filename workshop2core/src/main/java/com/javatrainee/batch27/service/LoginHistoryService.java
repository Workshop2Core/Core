package com.javatrainee.batch27.service;

import com.javatrainee.batch27.entity.LoginHistory;

public interface LoginHistoryService {

	//path : /loginHistory
	public LoginHistory findLoginHistoryByIdUser(long idUser); 		//-->findLoginHistoryByIdUser/{idUser}
	public void insert(LoginHistory loginHistory);					//-->insert
	public void delete(long idLogin);								//-->delete/{idLogin}
	
}
