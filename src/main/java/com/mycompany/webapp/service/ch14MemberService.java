package com.mycompany.webapp.service;

import javax.annotation.Resource;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.ch14MemberDao;
import com.mycompany.webapp.dto.ch14Member;

@Service
public class ch14MemberService {
	private static Logger logger =
			LoggerFactory.getLogger(ch14MemberService.class);
	
	@Resource
	private ch14MemberDao memberDao;
	
	public void join(ch14Member member) {
		memberDao.insert(member);
	}
	public String login(ch14Member member)
	{
		ch14Member dbMember = memberDao.selectByPk(member.getMid());
		if(dbMember == null) {
			return "wrongMid";
		} else if(dbMember.getMpassword().equals(member.getMpassword())){
			return "success";
		} else {
			return "wrongMpassword";
		}
	}
	public ch14Member getMember(String mid) {
		ch14Member member = memberDao.selectByPk(mid);
		return member;
	}
}
