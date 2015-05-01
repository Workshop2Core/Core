package com.javatrainee.batch27.service;

import java.util.List;

import com.javatrainee.batch27.entity.Saham;

public interface SahamService {
	
	//path : workshop2/saham
	public List<Saham> findAll();										//--> getAll
	public Saham findSahamByIdSaham(long sahamId); 						//--> /getSahamByIdSaham/{idSaham}
	public Saham findSahamBySahamName(String sahamName); 				//--> /getSahamBySahamName/{sahamName}
	public Saham findSahamByKodeSaham(String kodeSaham); 				//--> /getSahamByKodeSaham/{kodeSaham}
	public void insert(Saham saham);									//--> /insert/
	public void update(long idSaham, Saham saham);						//--> /update/{idSaham}
	public void delete(long idTransaksi);								//--> /delete/{idSaham}
}
