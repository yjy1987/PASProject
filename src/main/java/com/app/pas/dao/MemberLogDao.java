package com.app.pas.dao;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dto.MemberLogCommand;
import com.app.pas.dto.MemberLogVo;

public interface MemberLogDao {
	public void insertMemberLog(MemberLogVo memberLogVo) throws SQLException;
	public MemberLogVo selectLastMemberLogByEmail(String mem_Email) throws SQLException;
	public List<MemberLogCommand> selectWeeklyLogCount() throws SQLException;
}
