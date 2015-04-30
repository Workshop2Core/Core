package com.javatrainee.batch27.service;

import com.javatrainee.batch27.entity.PasswordHistory;

public interface PasswordHistoryService {

	//-->workshop2/pwdHistory
	public PasswordHistory findPasswordHistoryByIdUserAndPassword(long idUser, String password); //-->/findByIdPass/{iduser}/{password}
	public PasswordHistory findById(long idPassword);											//-->/get/{id}
	public void insert(PasswordHistory passwordHistory);										//-->/insert
	public void update(long idPassword, PasswordHistory passwordHistory);						//-->/update/{id}
	public void delete(long idPassword);														//-->/delete/{id}
}
