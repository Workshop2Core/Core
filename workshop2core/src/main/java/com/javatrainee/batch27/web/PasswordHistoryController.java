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

import com.javatrainee.batch27.entity.PasswordHistory;
import com.javatrainee.batch27.entity.User;
import com.javatrainee.batch27.service.PasswordHistoryService;

@RestController
@RequestMapping("workshop2/pwdHistory")
public class PasswordHistoryController {
	
	@Autowired
	private PasswordHistoryService pwdHistoryService;
	
	@RequestMapping(value="/findByIdPass/{iduser}/{password}",method=RequestMethod.GET)
	public ResponseEntity<PasswordHistory> findPasswordHistoryByIdUserAndPassword(@PathVariable("iduser") long idUser,@PathVariable("password") String password) {
		PasswordHistory passwordHistory = pwdHistoryService.findPasswordHistoryByIdUserAndPassword(idUser, password);	 
	    return new ResponseEntity<PasswordHistory>(passwordHistory, HttpStatus.OK);
	}
	
	@RequestMapping(value="/get/{id}",method=RequestMethod.GET)
	public ResponseEntity<PasswordHistory> findById(@PathVariable("id") long idUser) {
		PasswordHistory passwordHistory = pwdHistoryService.findById(idUser);	 
	    return new ResponseEntity<PasswordHistory>(passwordHistory, HttpStatus.OK);
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public ResponseEntity<PasswordHistory> insert(@RequestBody @Valid PasswordHistory passwordHistory){
		pwdHistoryService.insert(passwordHistory);
		return new ResponseEntity<PasswordHistory>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value="/update/{id}",method=RequestMethod.POST)
	public ResponseEntity<PasswordHistory> update(@PathVariable("id") long id,@RequestBody @Valid PasswordHistory passwordHistory){
		PasswordHistory p = pwdHistoryService.findById(id);
		p.setIdpassword(passwordHistory.getIdpassword());
		p.setOldpwd(passwordHistory.getOldpwd());
		p.setTimechange(passwordHistory.getTimechange());
		p.setUser(passwordHistory.getUser());
		pwdHistoryService.update(id, p);
		
		return new ResponseEntity<PasswordHistory>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<User> delete(@PathVariable("id") long id){
		pwdHistoryService.delete(id);
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}
	
}