package com.javatrainee.batch27.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javatrainee.batch27.entity.User;
import com.javatrainee.batch27.service.UserService;

@RestController
@RequestMapping("workshop2/User")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/getall",method=RequestMethod.GET)
	public ResponseEntity<List<User>> getAll() {
		List<User> entity = userService.findAll();	 
	    return new ResponseEntity<List<User>>(entity, HttpStatus.OK);
	}
	
	@RequestMapping(value="/findbyid/{id}",method=RequestMethod.GET)
	public ResponseEntity<User> findById(@PathVariable("id") long idUser) {
		User user = userService.findById(idUser);	 
	    return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value="/findbyusernameandpassword/{username}/{password}",method=RequestMethod.GET)
	public ResponseEntity<User> findByUsernameAndPassword(@PathVariable("username") String username,@PathVariable("password") String password) {
		User user = userService.findByUsernameAndPassword(username, password);	 
	    return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public ResponseEntity<User> insertUser(@RequestBody @Valid User user){
		userService.insert(user);
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value="/update/{id}",method=RequestMethod.POST)
	public ResponseEntity<User> updateUser(
			@PathVariable("id") long idUser,
			@RequestBody @Valid User user){
		
		userService.update(idUser, user);		
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<User> deleteUser(@PathVariable("id") long idUser){
		userService.delete(idUser);
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}
	
}
