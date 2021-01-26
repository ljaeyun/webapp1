package com.mycompany.webapp.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mycompany.webapp.dto.ch14Member;

@Repository
public class ch14MemberDao {
	
private static final Logger logger = LoggerFactory.getLogger(ch14MemberDao.class);
	
	@Resource
	private SqlSessionTemplate sst;    
	
	public ch14Member selectByPk(String mid)
	{
		ch14Member member = sst.selectOne("members.selectByPk", mid);
		return member;
	}

	public int insert(ch14Member member ) {
		int rows = sst.insert("members.insert",member);
		return rows;
	}
	
}
