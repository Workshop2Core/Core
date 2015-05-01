package com.javatrainee.batch27.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatrainee.batch27.entity.Saham;
import com.javatrainee.batch27.repo.SahamRepo;

@Service
public class SahamServiceImpl implements SahamService {
	@Autowired
	private SahamRepo sahamRepo;
	@Override
	public List<Saham> findAll() {
		// TODO Auto-generated method stub
		return sahamRepo.findAll();
	}

	@Override
	public Saham findSahamByIdSaham(long sahamId) {
		// TODO Auto-generated method stub
		return sahamRepo.findOne(sahamId);
	}

	@Override
	public Saham findSahamBySahamName(String sahamName) {
		// TODO Auto-generated method stub
		return sahamRepo.findSahamBySahamName(sahamName);
	}

	@Override
	public Saham findSahamByKodeSaham(String kodeSaham) {
		// TODO Auto-generated method stub
		return sahamRepo.findSahamByKodeSaham(kodeSaham);
	}

	@Override
	public void insert(Saham saham) {
		// TODO Auto-generated method stub
		sahamRepo.save(saham);
	}

	@Override
	public void update(long idSaham, Saham saham) {
		// TODO Auto-generated method stub
		Saham sahamUpdate = sahamRepo.findOne(idSaham);
		sahamUpdate.setNama(saham.getNama());
		sahamUpdate.setDeskripsi(saham.getDeskripsi());
		sahamUpdate.setKodeSaham(saham.getKodeSaham());
		sahamUpdate.setLastprice(saham.getLastprice());
		sahamRepo.save(sahamUpdate);
	}

	@Override
	public void delete(long idSaham) {
		// TODO Auto-generated method stub
		sahamRepo.delete(idSaham);
	}

}
