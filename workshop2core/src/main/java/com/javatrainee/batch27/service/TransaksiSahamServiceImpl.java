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
	
	public void insert(TransaksiSaham transaksiSaham)
	{
		transaksiSahamRepo.save(transaksiSaham);
	}
	
	public void update(long idTransaksi, TransaksiSaham transaksiSaham)
	{
		TransaksiSaham transaksiUpdate = transaksiSahamRepo.findOne(idTransaksi);
		transaksiUpdate.setUser(transaksiSaham.getUser());
		transaksiUpdate.setSaham(transaksiSaham.getSaham());
		transaksiUpdate.setLot(transaksiSaham.getLot());
		
		transaksiSahamRepo.save(transaksiUpdate);
	}

	@Override
	public List<TransaksiSaham> findDataSahamByUserId(long userId) {
		// TODO Auto-generated method stub
		return transaksiSahamRepo.findDataSahamByUserId(userId);
	}
	
	@Override
	public TransaksiSaham findDataSahamByUserIdAndIdSaham(long userId, long sahamId)
	{
		return transaksiSahamRepo.findDataSahamByUserIdAndIdSaham(userId, sahamId);
	}
}
