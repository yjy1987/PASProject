package com.app.pas.dao.board.impl;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dao.board.TotalNoticeDao;
import com.app.pas.dto.board.TotalNoticeVo;
import com.ibatis.sqlmap.client.SqlMapClient;

public class TotalNoticeDaoImpl implements TotalNoticeDao {
	private SqlMapClient client;
	
	public void setClient (SqlMapClient client){
		this.client = client;
	}
	
	
	@Override
	public List<TotalNoticeVo> selectTotalNoticeList(TotalNoticeVo totalNoticeVo) throws SQLException {
		List<TotalNoticeVo> list = client.queryForList("selectTotalNoticeList",totalNoticeVo);
		return list;
	}
//디테일
	@Override
	public TotalNoticeVo selectTotalNoticeBoard(int ttnotice_Num) throws SQLException {
		TotalNoticeVo totalNoticeVo = (TotalNoticeVo)client.queryForObject("selectTotalNoticeBoard",ttnotice_Num);
		return totalNoticeVo;
	}

	@Override
	public void insertTotalNotice(TotalNoticeVo totalNoticeVo)
			throws SQLException {
		client.insert("insertTotalNotice",totalNoticeVo);
	}
//수정
	@Override
	public void updateTotalNotice(TotalNoticeVo totalNoticeVo)throws SQLException {
		client.update("updateTotalNotice",totalNoticeVo);
	}

	@Override
	public void deleteTotalNotice(int ttnotice_Num) throws SQLException {
		client.delete("deleteTotalNotice",ttnotice_Num);
		
	}


	@Override
	public int toTalNoticeTotalCount() throws SQLException {
		int noticeCount = (Integer)client.queryForObject("toTalNoticeTotalCount");
		return noticeCount;
	}


	@Override
	public void totalNoticeCount(int ttnotice_Num) throws SQLException {
		client.update("totalNoticeCount",ttnotice_Num);
		
	}


	@Override
	public int toTalNoticeSearchCount(TotalNoticeVo totalNoticeVo)
			throws SQLException {
		int ttNoticeCount = (Integer)client.queryForObject("toTalNoticeSearchCount",totalNoticeVo);
		return ttNoticeCount;
	}
	

	
	
	

}
