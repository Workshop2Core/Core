package com.javatrainee.batch27.service;

import java.util.List;

import com.javatrainee.batch27.entity.User;

public interface UserService {
	
	//path : workshop2/user
	public List<User> findAll();											//-->getall
	public User findById(long idUser);										//-->findbyid/{id}
	public User findByUsernameAndPassword(String username, String password);//-->findbyusernameandpassword/{username/{password}
	public void insert(User user);											//-->insert
	public void update(long idUser, User user);								//-->update/{id}
	public void delete(long idUser);										//-->delete/{id}
}
