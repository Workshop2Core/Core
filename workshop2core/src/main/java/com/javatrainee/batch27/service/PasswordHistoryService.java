package com.javatrainee.batch27.service;

import com.javatrainee.batch27.entity.LoginHistory;
import com.javatrainee.batch27.entity.PasswordHistory;

public interface PasswordHistoryService {

	public PasswordHistory findPasswordHistoryByIdUserAndPassword(long idUser, String password);
	public void insert(PasswordHistory passwordHistory);
	public void update(long idPassword, PasswordHistory passwordHistory);
	public void delete(long idPassword);
}
