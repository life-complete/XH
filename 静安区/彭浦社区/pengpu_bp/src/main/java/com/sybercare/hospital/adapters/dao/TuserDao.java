package com.sybercare.hospital.adapters.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sybercare.hospital.adapters.entity.Tuser;
import com.sybercare.hospital.common.ds.DynamicDataSourceAutowired;

@Repository
public class TuserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@DynamicDataSourceAutowired(name = "his")
	public Tuser save(Tuser tuser) {
		this.jdbcTemplate.update("INSERT INTO `t_user`(`email`,`passWord`,`userName`,`mobile`,`nickName`) VALUES ('renlr@outlook.com','a123456','L梁','13601655231','梁哥')");
		return null;
	}
	
	@DynamicDataSourceAutowired(name = "his")
	public List<Tuser> readTuserList() {
		List<Tuser> result = new ArrayList<Tuser>();
		StringBuffer sql = new StringBuffer()
			.append("SELECT `t_user`.`id`,")
			.append("`t_user`.`email`,")
			.append("`t_user`.`mobile`,")
			.append("`t_user`.`nickname`,")
			.append("`t_user`.`password`,")
			.append("`t_user`.`username` ")
			.append("FROM `t_user`");
		result = this.jdbcTemplate.query(sql.toString(), new RowMapper<Tuser>() {
			@Override
			public Tuser mapRow(ResultSet rs, int rowNum) throws SQLException {
				Tuser tuser = new Tuser();
				tuser.setId(rs.getLong("id"));
				tuser.setEmail(rs.getString("email"));
				tuser.setMobile(rs.getString("mobile"));
				tuser.setNickName(rs.getString("nickname"));
				tuser.setPassWord(rs.getString("password"));
				tuser.setUserName(rs.getString("username"));
				return tuser;
			}
		});
		return result;
	}
}