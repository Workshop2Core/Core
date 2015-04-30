package com.javatrainee.batch27.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatrainee.batch27.entity.PasswordHistory;
import com.javatrainee.batch27.repo.PasswordHistoryRepo;

@Service
public class PasswordHistoryServiceImpl implements PasswordHistoryService {

	@Autowired
	private PasswordHistoryRepo passwordHistoryRepo;
	
	@Override
	public PasswordHistory findPasswordHistoryByIdUserAndPassword(long idUser,
			String password) {
		// TODO Auto-generated method stub
		return passwordHistoryRepo.findPasswordHistoryByIdUserAndPassword(idUser, password);
	}

	@Override
	public void insert(PasswordHistory passwordHistory) {
		// TODO Auto-generated method stub
		passwordHistoryRepo.save(passwordHistory);
	}


	@Override
	public PasswordHistory findById(long idPassword) {
		// TODO Auto-generated method stub
		return passwordHistoryRepo.findOne(idPassword);
	}

}
