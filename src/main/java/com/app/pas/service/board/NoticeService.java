package com.app.pas.service.board;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.app.pas.dao.board.NoticeDao;
import com.app.pas.dto.MemPositionViewVo;
import com.app.pas.dto.board.NoticeVo;

public class NoticeService {

	private NoticeDao noticeDao;

	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}

	public List<NoticeVo> getNoticeList(int proj_Num) throws SQLException {
		List<NoticeVo> list = null;

		list = (List<NoticeVo>) noticeDao.selectNotice(proj_Num);
		return list;
	}

	public void insertNotice(NoticeVo noticeVo) throws SQLException {

		noticeDao.insertNotice(noticeVo);
	}

	public NoticeVo getNoticeDetail(HashMap map) throws SQLException {
		NoticeVo noticeVo = noticeDao.selectNoticeDetail(map);
		return noticeVo;
	}

	public void updateNotice(NoticeVo noticeVo) throws SQLException {
		noticeDao.updateNotice(noticeVo);
	}

	public void deleteNotice(NoticeVo noticeVo) throws SQLException {
		noticeDao.deleteNotice(noticeVo);
	}

	public MemPositionViewVo getNoticePosition(HashMap map)
			throws SQLException {
		MemPositionViewVo MemPositionView = noticeDao
				.selectNoticePosition(map);
		return MemPositionView;

	}
	public int selectNoticeCount(int proj_Num)throws SQLException{
		int result = noticeDao.selectNoticeCount(proj_Num);
		return result;
	}

}
