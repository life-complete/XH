package com.sybercare.hospital.adapters.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * 功能：mysql数据库版业务处理
 *
 * @author 任梁荣
 * @version 创建时间：Sep 25, 2017 1:50:39 PM
 * */
@Repository
public class MysqlDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

}
