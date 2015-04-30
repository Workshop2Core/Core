package com.javatrainee.batch27.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatrainee.batch27.entity.TransaksiSaham;
import com.javatrainee.batch27.repo.TransaksiSahamRepo;

@Service
public class TransaksiSahamServiceImpl implements TransaksiSahamService{
	@Autowired
	private TransaksiSahamRepo transaksiSahamRepo;
	
	@Override
	public List<TransaksiSaham> findAll()
	{
		return transaksiSahamRepo.findAll();
	}
	
	public TransaksiSaham findById(long idTransaksi)
	{
		return transaksiSahamRepo.findOne(idTransaksi);
	}
	
	public void insertTransaksiSaham(TransaksiSaham transaksiSaham)
	{
		transaksiSahamRepo.save(transaksiSaham);
	}
	
	public void updateTransaksiSaham(long idTransaksi, TransaksiSaham transaksiSaham)
	{
		TransaksiSaham transaksiUpdate = transaksiSahamRepo.findOne(idTransaksi);
		transaksiUpdate.setUser(transaksiSaham.getUser());
		transaksiUpdate.setSaham(transaksiSaham.getSaham());
		transaksiUpdate.setLot(transaksiSaham.getLot());
		
		transaksiSahamRepo.save(transaksiUpdate);
	}
	
	public void deleteTransaksiSaham(long idTransaksi)
	{
		transaksiSahamRepo.delete(idTransaksi);
	}
}
