package com.javatrainee.batch27.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatrainee.batch27.entity.User;
import com.javatrainee.batch27.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public List<User> findAll()
	{
		return (List<User>) userRepo.findAll();
	}
	
	@Override
	public User findById(long idUser)
	{
		return userRepo.findOne(idUser);
	}
	
	@Override
	public User findByUsernameAndPassword(String username, String password)
	{
		return userRepo.findUserByUsernameAndPassword(username, password);
	}
	
	@Override
	public void insert(User user)
	{
		userRepo.save(user);
	}
	
	@Override
	public void update(long idUser, User user)
	{
		User userUpdate = userRepo.findOne(idUser);
		userUpdate.setUsername(user.getUsername());
		userUpdate.setPassword(user.getPassword());
		userUpdate.setSaldo(user.getSaldo());
		userRepo.save(userUpdate);
	}
	
	@Override
	public void delete(long idUser)
	{
		userRepo.delete(idUser);
	}
}
