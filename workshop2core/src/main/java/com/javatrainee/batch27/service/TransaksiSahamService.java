package com.javatrainee.batch27.service;

import java.util.List;

import com.javatrainee.batch27.entity.TransaksiSaham;

public interface TransaksiSahamService {
	public List<TransaksiSaham> findAll();
	public TransaksiSaham findById(long idTransaksi);
	public void insertTransaksiSaham(TransaksiSaham transaksiSaham);
	public void updateTransaksiSaham(long idTransaksi, TransaksiSaham transaksiSaham);
	public void deleteTransaksiSaham(long idTransaksi);
	
}
