package com.app.pas.service.board;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.pas.dao.board.TotalNoticeDao;
import com.app.pas.dto.board.NoticeVo;
import com.app.pas.dto.board.TotalNoticeVo;
import com.sun.security.ntlm.Client;

public class TotalNoticeService {
 
	private TotalNoticeDao totalnoticeDao;

	public void setTotalnoticeDao(TotalNoticeDao totalnoticeDao) {
		this.totalnoticeDao = totalnoticeDao;
	}
	//토탈 노티스 List 
	public List<TotalNoticeVo> selectTotalNoticeList(TotalNoticeVo totalNoticeVo) throws SQLException{
		List<TotalNoticeVo> list = new ArrayList<TotalNoticeVo>();
		list = totalnoticeDao.selectTotalNoticeList(totalNoticeVo);
		return list; 
		}
    public int toTalNoticeSearchCount(TotalNoticeVo totalNoticeVo)throws SQLException{
    	int ttNoticeCount = totalnoticeDao.toTalNoticeSearchCount(totalNoticeVo);
    	return ttNoticeCount;
    }
    
	
	//전체공지사항 Detail
	public TotalNoticeVo selectTotalNoticeBoard(int ttnotice_Num) throws SQLException{
		
		TotalNoticeVo totalNoticeVo = totalnoticeDao.selectTotalNoticeBoard(ttnotice_Num);
		
		return totalNoticeVo;
	}
	//글쓰기
	public TotalNoticeVo insertTotalNotice(TotalNoticeVo totalNoticeVo)throws SQLException{
		totalnoticeDao.insertTotalNotice(totalNoticeVo);
		
		return totalNoticeVo;
	}
	//글삭제 
	public void deleteTotalNotice(int ttnotice_Num) throws SQLException{
		totalnoticeDao.deleteTotalNotice(ttnotice_Num);
	}
	//글수정폼
	public TotalNoticeVo UpdateFormTotalNotice (TotalNoticeVo totalNoticeVo,int ttnotice_Num) throws SQLException{
		 totalnoticeDao.selectTotalNoticeBoard(ttnotice_Num);
		
		return totalNoticeVo;
		
	}
	
	//글수정
	public void updateTotaTotalNotice(TotalNoticeVo totalNoticeVo) throws SQLException{
		totalnoticeDao.updateTotalNotice(totalNoticeVo);
	}
	
	
	public int toTalNoticeTotalCount() throws SQLException{
		int noticeCount = totalnoticeDao.toTalNoticeTotalCount();
		return noticeCount;
	}
	
	public void totalNoticeCount (int ttnotice_Num) throws SQLException{
		totalnoticeDao.totalNoticeCount(ttnotice_Num);
	}
}
