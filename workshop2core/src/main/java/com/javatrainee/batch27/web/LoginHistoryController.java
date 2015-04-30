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

import com.javatrainee.batch27.entity.LoginHistory;
import com.javatrainee.batch27.service.LoginHistoryService;

@RestController
@RequestMapping("workshop2/loginHistory")
public class LoginHistoryController {

	@Autowired
	private LoginHistoryService loginHistoryService;
	
	@RequestMapping(value="/findLoginHistoryByIdUser/{userid}",method=RequestMethod.GET)
	public ResponseEntity<LoginHistory> findLoginHistoryByIdUser(@PathVariable("userid") long userid) {
		LoginHistory loginHistory = loginHistoryService.findLoginHistoryByIdUser(userid);	 
	    return new ResponseEntity<LoginHistory>(loginHistory, HttpStatus.OK);
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public ResponseEntity<LoginHistory> insertLoginHistory(@RequestBody @Valid LoginHistory loginHistory){
		loginHistoryService.insert(loginHistory);
		return new ResponseEntity<LoginHistory>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<LoginHistory> deleteLoginHistory(@PathVariable("id") long idLogin){
		loginHistoryService.delete(idLogin);
		return new ResponseEntity<LoginHistory>(HttpStatus.NO_CONTENT);
	}
	
}
