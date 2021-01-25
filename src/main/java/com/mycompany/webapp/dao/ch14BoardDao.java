package com.mycompany.webapp.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mycompany.webapp.dto.ch14Board;

@Repository
public class ch14BoardDao {
	
private static final Logger logger = LoggerFactory.getLogger(ch14BoardDao.class);
	
	@Resource
	private SqlSessionTemplate sst;    
	
	public List<ch14Board> selectAll()
	{
		List<ch14Board> list = sst.selectList("mybatis.mapper.boards.selectAll");
		return list;
	}
		
	
	public int insert(ch14Board board) {
			int rows = sst.insert("mybatis.mapper.boards.insert", board);
			return rows;
	}
	 
	

}
