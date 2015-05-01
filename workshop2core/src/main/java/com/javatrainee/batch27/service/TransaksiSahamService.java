package com.javatrainee.batch27.service;

import java.util.List;

import com.javatrainee.batch27.entity.TransaksiSaham;

public interface TransaksiSahamService {
	
	//Path : workshop2/dataSaham
	public List<TransaksiSaham> findAll();								//--> getAllDataSaham
	public List<TransaksiSaham> findDataSahamByUserId(long userId); 	//--> getDataSahamByUserId/{userId}
	public void insert(TransaksiSaham transaksiSaham);					//--> /insert
	public void update(long idTransaksi, TransaksiSaham transaksiSaham);//--> /update/{idDataSaham}
	public TransaksiSaham findDataSahamByUserIdAndIdSaham(long userId, long sahamId);
}
