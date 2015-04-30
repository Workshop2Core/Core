package com.javatrainee.batch27.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatrainee.batch27.entity.LoginHistory;
import com.javatrainee.batch27.entity.OrderHistory;
import com.javatrainee.batch27.repo.LoginHistoryRepo;
import com.javatrainee.batch27.repo.UserRepo;

@Service
public class LoginHistoryServiceImpl implements LoginHistoryService {

	@Autowired
	private LoginHistoryRepo loginHistoryRepo;
	
	@Override
	public LoginHistory findLoginHistoryByIdUser(long idUser) {
		// TODO Auto-generated method stub
		return loginHistoryRepo.findLoginHistoryByIdUser(idUser);
	}

	@Override
	public void insert(LoginHistory loginHistory) {
		// TODO Auto-generated method stub
		loginHistoryRepo.save(loginHistory);
	}

	@Override
	public void update(long idLogin, LoginHistory loginHistory) {
		// TODO Auto-generated method stub
		LoginHistory l = loginHistoryRepo.findOne(idLogin);
		loginHistory.setIdlogin(idLogin);
		loginHistoryRepo.save(l);
	}

	@Override
	public void delete(long idLogin) {
		// TODO Auto-generated method stub
		loginHistoryRepo.delete(idLogin);
	}

}
