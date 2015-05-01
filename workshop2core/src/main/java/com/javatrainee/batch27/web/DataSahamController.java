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

import com.javatrainee.batch27.entity.TransaksiSaham;
import com.javatrainee.batch27.service.TransaksiSahamService;

@RestController
@RequestMapping("workshop2/dataSaham")
public class DataSahamController {
	@Autowired
	private TransaksiSahamService dataSahamService;
	
	@RequestMapping(value="/getAllDataSaham",method=RequestMethod.GET)
	public ResponseEntity<List<TransaksiSaham>> getAllDataSaham(){
		List<TransaksiSaham> listDataSaham = dataSahamService.findAll();
		return new ResponseEntity<List<TransaksiSaham>>(listDataSaham, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getDataSahamByUserId/{userId}",method=RequestMethod.GET)
	public ResponseEntity<List<TransaksiSaham>> getDataSahamByUserId(@PathVariable("userId") long userId){
		List<TransaksiSaham> listDataSaham = dataSahamService.findDataSahamByUserId(userId);		
		return new ResponseEntity<List<TransaksiSaham>>(listDataSaham, HttpStatus.OK);
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public ResponseEntity<TransaksiSaham> insertTransaksiSaham(@RequestBody @Valid TransaksiSaham dataSaham){
		dataSahamService.insert(dataSaham);
		return new ResponseEntity<TransaksiSaham>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value="/update/{idDataSaham}",method=RequestMethod.PUT)
	public ResponseEntity<TransaksiSaham> updateTransaksiSaham(
			@PathVariable("idDataSaham") long idDataSaham,
			@RequestBody @Valid TransaksiSaham dataSaham){
		dataSahamService.update(idDataSaham,dataSaham);
		return new ResponseEntity<TransaksiSaham>(HttpStatus.NO_CONTENT);
	}
	

	@RequestMapping(value="/findDataSahamByUserIdAndIdSaham/{userId}/{sahamId}",method=RequestMethod.GET)
	public ResponseEntity<TransaksiSaham> findDataSahamByUserIdAndIdSaham(@PathVariable("userId") long userId,
			@PathVariable("sahamId") long sahamId){
		TransaksiSaham listDataSaham = dataSahamService.findDataSahamByUserIdAndIdSaham(userId,sahamId);		
		return new ResponseEntity<TransaksiSaham>(listDataSaham, HttpStatus.OK);
	}
}
