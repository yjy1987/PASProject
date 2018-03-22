package com.app.pas.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dao.MemberDao;
import com.app.pas.dto.MemApplyViewVo;
import com.app.pas.dto.MemPositionViewVo;
import com.app.pas.dto.MemberCommandVo;
import com.app.pas.dto.MemberVo;
import com.ibatis.sqlmap.client.SqlMapClient;

public class MemberDaoImpl implements MemberDao {
	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	@Override
	public List<MemberVo> selectMemberList() throws SQLException {
		List<MemberVo> list = client.queryForList("selectMemberList");
		return list;
	}
	
	@Override
	public List<MemberVo> selectMemList(String mem_Email) throws SQLException {
		List<MemberVo> list = client.queryForList("selectMemberList", mem_Email);
		return list;
	}

	@Override
	public MemberVo selectMember(String mem_Email) throws SQLException {
		MemberVo memberVo = (MemberVo) client.queryForObject("selectMember",mem_Email);
		return memberVo;
	}
	

	@Override
	public void insertMember(MemberVo memberVo) throws SQLException {
		client.insert("insertMember",memberVo);
	}

	@Override
	public int updateMember(MemberVo memberVo) throws SQLException {
		return client.update("updateMember",memberVo);
	}

	@Override
	public void deleteMember(String mem_Email) throws SQLException {
		client.update("deleteMember",mem_Email);
	}

	@Override
	public void extraMemberPwd(MemberVo memberVo) throws SQLException {
		client.update("extraMemberPwd",memberVo);
		
	}

	@Override
	public void AuthMember(String mem_Email) throws SQLException {
		client.update("AuthMember",mem_Email);
		
	}

	@Override
	public int selectCountMemApplyView(MemApplyViewVo memApplyViewVo)
			throws SQLException {
		int countMemApply =(Integer) client.queryForObject("selectCountMemApplyView",memApplyViewVo);
		return countMemApply;
	}

	@Override
	public MemApplyViewVo selectMemApplyViewByMemProj(
			MemApplyViewVo memApplyViewVo) throws SQLException {
		memApplyViewVo = (MemApplyViewVo) client.queryForObject("selectMemApplyViewByMemProj",memApplyViewVo);
		return memApplyViewVo;
	}
	// �뿬以��쁺 遺�遺�
		public void updateMemberImg(MemberVo memberVo) throws SQLException{
		    client.update("updateMemberImg",memberVo);
		}

	@Override
	public List<MemApplyViewVo> selectMemApplyViewByEmail(String p_Mem_Email)
			throws SQLException {
		List<MemApplyViewVo> list = (List<MemApplyViewVo>) client.queryForList("selectMemApplyViewByEmail",p_Mem_Email);
		return list;
	}

	@Override
	public MemberVo searchEmail(MemberVo memberVo) throws SQLException {
		MemberVo MemberVo1 = (MemberVo) client.queryForObject("searchEmail",memberVo);
		return MemberVo1;
	}
	public void updateApplyCommitCheck(int apply_Num) throws SQLException {
		client.update("updateApplyCommitCheck",apply_Num);
	}

	@Override
	public MemApplyViewVo selectMemApplyViewByApplyNum(int apply_Num)
			throws SQLException {
		MemApplyViewVo memApplyViewVo = (MemApplyViewVo) client.queryForObject("selectMemApplyViewByApplyNum",apply_Num);
		return memApplyViewVo;
	}

	@Override
	public void deleteApplyViewByApplyNum(int apply_Num) throws SQLException {
		client.delete("deleteApplyViewByApplyNum",apply_Num);

	}

	@Override
	public List<MemPositionViewVo> selectMemberListByProj(MemPositionViewVo memPoistionViewVo)
			throws SQLException {
		List<MemPositionViewVo> list = client.queryForList("selectMemberListByProj",memPoistionViewVo );
		return list;
	}

	@Override
	public MemPositionViewVo selectMemberPosition(
			MemPositionViewVo memPositionViewVo) throws SQLException {
		MemPositionViewVo memPositionViewVo1 = (MemPositionViewVo) client.queryForObject("selectMemberPosition", memPositionViewVo);
		return memPositionViewVo1; 
	}

	@Override
	public int selectMemberTotalCount() throws SQLException {
		int totalCount = (Integer) client.queryForObject("selectTotalCountMember");
		return totalCount;
	}
	@Override
	public int selectCountMemApplyViewByEmail(String p_Mem_Email)
			throws SQLException {
		int memApplyViewCount = (Integer) client.queryForObject("selectCountMemApplyViewByEmail",p_Mem_Email);
		return memApplyViewCount;

	}


	public List<MemberCommandVo> selectMemberEmailList(int proj_Num) throws SQLException {
	
		List<MemberCommandVo> list = client.queryForList("selectMemberEmailList", proj_Num);
		return list;
	}

	@Override
	public void updateMemberQuitCheck(MemberVo memberVo) throws SQLException {
		client.update("updateMemberQuitCheck", memberVo);
		
	}


	public String selectMemberPhone(String mem_Email) throws SQLException {
		String mem_Phone = (String) client.queryForObject("selectMemberPhone", mem_Email);
		return mem_Phone;
	}

	@Override
	public int selectOtherProjectCount(String mem_Email) throws SQLException {
	  int result=(Integer) client.queryForObject("selectOtherProjectCount", mem_Email);
		return result;
	}

	@Override
	public MemPositionViewVo selectMemberPositionByEmail(
			MemPositionViewVo memPositionViewVo) throws SQLException {
		memPositionViewVo = (MemPositionViewVo) client.queryForObject("selectMemberPositionByEmail",memPositionViewVo);
		return memPositionViewVo;
	}

	@Override
	public MemberVo selectByMemEmail(String mem_Email) throws SQLException {
		MemberVo memberVo = (MemberVo) client.queryForObject("selectByMemEmail",mem_Email);
		return memberVo;
	}

	@Override
	public int selectJoinToday() throws SQLException {
		int joinCount = (Integer) client.queryForObject("selectJoinToday");
		return joinCount;
	}
	
	@Override
	public List<MemberVo> selectJoinMemberToday() throws SQLException {
		List<MemberVo> list  = client.queryForList("selectJoinMemberToday");
		return list;
	}

	@Override
	public int selectProjCreated_Count() throws SQLException {
		int projCount = (Integer)client.queryForObject("selectProjCreated_Count");
		return projCount;
	}

	@Override
	public int selectVisitorNum() throws SQLException {
		int visitorNum = (Integer)client.queryForObject("selectVisitorNum");
		return visitorNum;
	}

	@Override
	public int selectExit_count() throws SQLException {
		int exitCount = (Integer)client.queryForObject("selectExit_count");
		return exitCount;
	}

	@Override
	public List<MemberVo> selectExit_MemList() throws SQLException {
		List<MemberVo>exit_MemList = client.queryForList("selectExit_MemList");
		return exit_MemList;
	}

	@Override
	public int selectTodayVisitorCount() throws SQLException {
		int todayVisitorCount = (Integer)client.queryForObject("selectTodayVisitorCount");
		return todayVisitorCount;
	}
	
	@Override
	public int selectVisitThisWeek() throws SQLException {
		int visitThisWeekCount = (Integer)client.queryForObject("selectVisitThisWeek");
		return visitThisWeekCount;
	}
	
	@Override
	public int selectVisitLastWeek() throws SQLException {
		int visitLastWeelCount = (Integer)client.queryForObject("selectVisitLastWeek");
		return visitLastWeelCount;
	}

	@Override
	public MemberVo selectKing(int proj_Num) throws SQLException {
		MemberVo memberVo = (MemberVo) client.queryForObject("selectKing", proj_Num);
		return memberVo;
	}
	
}
