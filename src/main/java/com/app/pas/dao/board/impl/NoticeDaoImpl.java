package com.app.pas.dao.board.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.app.pas.dao.board.NoticeDao;
import com.app.pas.dto.MemPositionViewVo;
import com.app.pas.dto.board.NoticeVo;
import com.ibatis.sqlmap.client.SqlMapClient;

public class NoticeDaoImpl implements NoticeDao{

	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}
	@Override
	public List<NoticeVo> selectNoticeList() throws SQLException {
		List<NoticeVo> list = client.queryForList("selectNoticeList");
		return list;
	}

	@Override
	public List<NoticeVo> selectNotice(int proj_Num) throws SQLException {
		List<NoticeVo> list = client.queryForList("selectNotice",proj_Num); 
		return list;
	}

	@Override
	public void insertNotice(NoticeVo noticeVo) throws SQLException {
		client.insert("insertNotice",noticeVo);
	}

	@Override
	public void updateNotice(NoticeVo noticeVo) throws SQLException {
		client.update("updateNotice",noticeVo);
	}

	@Override
	public void deleteNotice(NoticeVo noticeVo) throws SQLException {
		client.delete("deleteNotice",noticeVo);
	}
	@Override
	public int selectNoticeCount(int proj_Num) throws SQLException {
		int result =(Integer) client.queryForObject("selectNoticeCount", proj_Num);
		return result;
		
	}
	@Override
	public NoticeVo selectNoticeDetail(HashMap map) throws SQLException {
		NoticeVo noticeVo = (NoticeVo) client.queryForObject("selectNoticeDetail", map);
		return noticeVo;
	}
	@Override
	public MemPositionViewVo selectNoticePosition(HashMap map)
			throws SQLException {
		MemPositionViewVo MemPositionView = (MemPositionViewVo) client.queryForObject("selectNoticePosition",map );
		return MemPositionView;
	}

}
