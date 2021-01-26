package com.mycompany.webapp.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.ch14BoardDao;
import com.mycompany.webapp.dto.Ch14Pager;
import com.mycompany.webapp.dto.ch14Board;

@Service
public class ch14BoardService {
	private static Logger logger =
			LoggerFactory.getLogger(ch14BoardService.class);

	@Resource
	private ch14BoardDao boardDao;
	
	public List<ch14Board> getBoardList() {
		List<ch14Board> list = boardDao.selectAll();
		return list;
	}
	
	public List<ch14Board> getBoardList(Ch14Pager pager) {
		List<ch14Board> list = boardDao.selectByPage(pager);
		return list;
	}
	
	/*
	 * public List<ch14Board> getBoardList(int pageNo) { List<ch14Board> list =
	 * boardDao.selectAll(); return list; }
	 */
	
	public void saveBoard(ch14Board board)
	{
		boardDao.insert(board);
	}

	public int getTotalRows() {
		int totalRows = boardDao.countAll();
		return totalRows;
	}

	public ch14Board getBoard(int bno) {
		ch14Board board = boardDao.selectByPk(bno);
		return board;
	}

	public void updateBoard(ch14Board board) {
		boardDao.update(board);
		
	}

	public void deleteBoard(int bno) {
		boardDao.delete(bno);
	}

	public void addHitcount(int bno) {
		boardDao.updateHitcount(bno);
		
	}
}
