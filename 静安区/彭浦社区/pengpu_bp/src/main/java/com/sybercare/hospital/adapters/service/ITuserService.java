package com.sybercare.hospital.adapters.service;

import java.util.List;

import com.sybercare.hospital.adapters.entity.Tuser;

public interface ITuserService {

	boolean addTuser(Tuser tuser);

	List<Tuser> readTuserList();

	void addRecvData(Object data);

}
