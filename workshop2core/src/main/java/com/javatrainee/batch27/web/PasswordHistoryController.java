package com.javatrainee.batch27.web;

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
	
	@RequestMapping(value="/get/{idUser}",method=RequestMethod.GET)
	public ResponseEntity<PasswordHistory> findById(@PathVariable("idUser") long idUser) {
		PasswordHistory passwordHistory = pwdHistoryService.findById(idUser);	 
	    return new ResponseEntity<PasswordHistory>(passwordHistory, HttpStatus.OK);
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public ResponseEntity<PasswordHistory> insert(@RequestBody @Valid PasswordHistory passwordHistory){
		pwdHistoryService.insert(passwordHistory);
		return new ResponseEntity<PasswordHistory>(HttpStatus.NO_CONTENT);
	}

	
}
