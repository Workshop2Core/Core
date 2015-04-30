package com.javatrainee.batch27.service;

import com.javatrainee.batch27.entity.LoginHistory;

public interface LoginHistoryService {

	//path : /loginhistory
	public LoginHistory findLoginHistoryByIdUser(long idUser); 		//-->findloginhistorybyid/{idUser}
	public void insert(LoginHistory loginHistory);					//-->insert
	public void delete(long idLogin);								//-->delete/{idLogin}
	
}
