package com.sybercare.hospital.adapters.service.impl;

import java.sql.Connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.jndi.url.corbaname.corbanameURLContextFactory;
import com.sybercare.hospital.adapters.dao.CacheDBDAO;
import com.sybercare.hospital.adapters.service.IDataCacheDBService;
@Service
public class DataCacheDBServiceImpl implements IDataCacheDBService {

	@Autowired
	private CacheDBDAO cacheDBDAO;
	@Override
	public Object readStaff(Connection connection, Object params) {
		return this.cacheDBDAO.readStaff(connection,params);
	}
	@Override
	public Object readPatient(Connection connection, Object params) {
		return this.cacheDBDAO.readPatient(connection,params);
	}
	@Override
	public Object readPother(Connection connection, Object params) {
		return  this.cacheDBDAO.readPother(connection,params);
	}

}
