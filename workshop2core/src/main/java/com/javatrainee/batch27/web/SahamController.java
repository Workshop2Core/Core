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

import com.javatrainee.batch27.entity.Saham;
import com.javatrainee.batch27.service.SahamService;

@RestController
@RequestMapping("workshop2/saham")
public class SahamController {

	@Autowired
	private SahamService sahamService;
	
	@RequestMapping(value="/getAll",method=RequestMethod.GET)
	public ResponseEntity<List<Saham>> getAllSaham() {
		List<Saham> saham = sahamService.findAll();	 
	    return new ResponseEntity<List<Saham>>(saham, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getSahamByIdSaham/{idSaham}",method=RequestMethod.GET)
	public ResponseEntity<Saham> getSahamByIdSaham(@PathVariable("idSaham") long idSaham) {
		Saham saham = sahamService.findSahamByIdSaham(idSaham);	 
	    return new ResponseEntity<Saham>(saham, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getSahamBySahamName/{sahamName}",method=RequestMethod.GET)
	public ResponseEntity<Saham> getSahamBySahamName(@PathVariable("sahamName") String sahamName) {
		Saham saham = sahamService.findSahamBySahamName(sahamName);	 
	    return new ResponseEntity<Saham>(saham, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getSahamByKodeSaham/{kodeSaham}",method=RequestMethod.GET)
	public ResponseEntity<Saham> getSahamByKodeSaham(@PathVariable("kodeSaham") String kodeSaham) {
		Saham saham = sahamService.findSahamByKodeSaham(kodeSaham);	 
	    return new ResponseEntity<Saham>(saham, HttpStatus.OK);
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public ResponseEntity<Saham> insertSaham(@RequestBody @Valid Saham saham){
		sahamService.insert(saham);
		return new ResponseEntity<Saham>(HttpStatus.NO_CONTENT);
	}
	

	@RequestMapping(value="/update/{idSaham}",method=RequestMethod.PUT)
	public ResponseEntity<Saham> updateSaham(
			@PathVariable("idSaham") long idSaham,
			@RequestBody @Valid Saham saham){
		sahamService.update(idSaham,saham);
		return new ResponseEntity<Saham>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value="/delete/{idSaham}",method=RequestMethod.DELETE)
	public ResponseEntity<Saham> deleteSaham(@PathVariable("idSaham") long idSaham){
		sahamService.delete(idSaham);
		return new ResponseEntity<Saham>(HttpStatus.NO_CONTENT);
	}
}
