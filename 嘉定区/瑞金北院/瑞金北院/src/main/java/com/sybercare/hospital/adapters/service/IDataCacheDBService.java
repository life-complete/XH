package com.sybercare.hospital.adapters.service;

import java.sql.Connection;

public interface IDataCacheDBService {

	Object readStaff(Connection connection, Object params);

	Object readPatient(Connection connection, Object params);

	Object readPother(Connection connection, Object params);

}
