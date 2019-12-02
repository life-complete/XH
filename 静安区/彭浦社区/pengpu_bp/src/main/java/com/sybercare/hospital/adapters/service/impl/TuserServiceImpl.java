package com.sybercare.hospital.adapters.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sybercare.hospital.adapters.dao.TuserDao;
import com.sybercare.hospital.adapters.entity.Tuser;
import com.sybercare.hospital.adapters.service.ITuserService;

@Service
public class TuserServiceImpl implements ITuserService {

	@Autowired
	private TuserDao tuserDao;

	@Override
	public boolean addTuser(Tuser tuser) {
		this.tuserDao.save(tuser);
		return false;
	}

	@Override
	public List<Tuser> readTuserList() {
		return this.tuserDao.readTuserList();
	}

	@Override
	public void addRecvData(Object data) {

	}

}
