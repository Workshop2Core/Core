package com.javatrainee.batch27.service;

import com.javatrainee.batch27.entity.PasswordHistory;

public interface PasswordHistoryService {

	//-->workshop2/pwdHistory
	public PasswordHistory findPasswordHistoryByIdUserAndPassword(long idUser, String password); //-->/findByIdPass/{iduser}/{password}
	public void insert(PasswordHistory passwordHistory);										//-->/insert
}
