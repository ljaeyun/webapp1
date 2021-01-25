package com.mycompany.webapp.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mycompany.webapp.dto.ch14Employee;

@Repository
public class ch14EmployeeDao {
	private static final Logger logger = LoggerFactory.getLogger(ch14EmployeeDao.class);
	
	@Resource
	private SqlSessionTemplate sst;    
	//준비작업끝
	public ch14Employee selectByPk(int employee_id) {
		ch14Employee emp = sst.selectOne("mybatis.mapper.employees.selectByPk", employee_id);
		
		return emp;
		
		
		
	}
	
}
