package com.app.pas.service;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dao.MemberLogDao;
import com.app.pas.dto.MemberLogCommand;
import com.app.pas.dto.MemberLogVo;

public class MemberLogService {


	private MemberLogDao memberLogDao;
	
	
	public void setMemberLogDao(MemberLogDao memberLogDao) {
		this.memberLogDao = memberLogDao;
	}


	public void insertMemberLog(MemberLogVo memberLogVo)throws SQLException{
		memberLogDao.insertMemberLog(memberLogVo);
	}
	public MemberLogVo selectLastMemberLogByEmail(String mem_Email) throws SQLException {
		MemberLogVo log = memberLogDao.selectLastMemberLogByEmail(mem_Email);
		return log;
	}
	public List<MemberLogCommand> selectWeeklyLogCount () throws SQLException{
		List<MemberLogCommand> list = memberLogDao.selectWeeklyLogCount();
		return list;
	}
}
