package com.javatrainee.batch27.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatrainee.batch27.entity.LoginHistory;
import com.javatrainee.batch27.repo.LoginHistoryRepo;

@Service
public class LoginHistoryServiceImpl implements LoginHistoryService {

	@Autowired
	private LoginHistoryRepo loginHistoryRepo;
	
	@Override
	public Long findLoginHistoryByIdUser(Long idUser) {
		// TODO Auto-generated method stub
		return loginHistoryRepo.findLoginHistoryByIdUser(idUser);
	}

	@Override
	public void insert(LoginHistory loginHistory) {
		// TODO Auto-generated method stub
		loginHistoryRepo.save(loginHistory);
	}

	@Override
	public void delete(long idLogin) {
		// TODO Auto-generated method stub
		loginHistoryRepo.delete(idLogin);
	}

}
