package com.javatrainee.batch27.service;

import java.util.List;

import com.javatrainee.batch27.entity.User;

public interface UserService {
	public List<User> findAll();
	public User findById(long idUser);
	public User findByUsernameAndPassword(String username, String password);
	public void insert(User user);
	public void update(long idUser, User user);
	public void delete(long idUser);
}
