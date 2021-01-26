package com.mycompany.webapp.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mycompany.webapp.dto.Ch14Pager;
import com.mycompany.webapp.dto.ch14Board;

@Repository
public class ch14BoardDao {
	
private static final Logger logger = LoggerFactory.getLogger(ch14BoardDao.class);
	
	@Resource
	private SqlSessionTemplate sst;    
	
	public List<ch14Board> selectAll()
	{
		List<ch14Board> list = sst.selectList("boards.selectAll");
		return list;
	}
		
	public int countAll() {
		int count = sst.selectOne("boards.countAll");
		return count;
	}
		
	
	public int insert(ch14Board board) {
			int rows = sst.insert("boards.insert", board);
			return rows;
	}

	public List<ch14Board> selectByPage(Ch14Pager pager) {
		List<ch14Board> list = sst.selectList("boards.selectByPage", pager);
		return list;
	}

	public ch14Board selectByPk(int bno) {
		ch14Board board = sst.selectOne("boards.selectByPk", bno);
		return board;
	}

	public int update(ch14Board board) {
		int rows= sst.update("boards.update", board);
		return rows;
		
	}

	public int delete(int bno) {
		int rows = sst.delete("boards.delete", bno);
		return rows;
		
	}

	public int updateHitcount(int bno) {
		int rows = sst.update("boards.updateHitcount", bno);
		return rows;
	}
	 
	

}
