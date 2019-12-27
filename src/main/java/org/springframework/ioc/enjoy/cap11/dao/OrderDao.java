package org.springframework.ioc.enjoy.cap11.dao;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	//操作数据的方法
	public void insert(){
		String sql = "insert into `test01` (id) values(?)";
		jdbcTemplate.update(sql,1);
	}
}
