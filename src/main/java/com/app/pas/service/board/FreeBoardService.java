package com.app.pas.service.board;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.pas.dao.board.FreeBoardDao;
import com.app.pas.dto.board.FreeBoardLikeVo;
import com.app.pas.dto.board.FreeBoardVo;


public class FreeBoardService {
	
	private FreeBoardDao freeboardDao;

	public void setFreeboardDao(FreeBoardDao freeboardDao) {
		this.freeboardDao = freeboardDao;
	}
	
	public List<FreeBoardVo> selectFreeBoardList(FreeBoardVo freeBoardVo) throws SQLException{
		List<FreeBoardVo> list= new ArrayList<FreeBoardVo>();
		list = freeboardDao.selectFreeBoardList(freeBoardVo);
		return list;
	}
 
	
	public FreeBoardVo selectFreeBoardDetail(int frb_Article_Num)throws SQLException{
		FreeBoardVo freeBoardVo = null;
			freeBoardVo = freeboardDao.selectFreeBoardDetail(frb_Article_Num);
		return freeBoardVo;
	}
	
	
	public void insertFreeBoard(FreeBoardVo freeBoardVo) throws SQLException{
				freeboardDao.insertFreeBoard(freeBoardVo);
	}
	

	public void deleteFreeBoard(int frb_Article_Num)throws SQLException{
		
			freeboardDao.deleteFreeBoard(frb_Article_Num);
		
	}
	
	public void updateFreeBoard(FreeBoardVo freeBoardVo)throws SQLException{
		
			freeboardDao.updateFreeBoard(freeBoardVo);
	
	}
	
	public int selectTotalCount() throws SQLException{
		int totalCount = freeboardDao.selectTotalCount();
		return totalCount;
	}
	
	
	public void insertFreeboardLike(FreeBoardLikeVo freeBoardLikeVo)
			throws SQLException {
		freeboardDao.insertFreeboardLike(freeBoardLikeVo);
		
	}

	
	public void deleteFreeboardLike(FreeBoardLikeVo freeBoardLikeVo)
			throws SQLException {
		freeboardDao.deleteFreeboardLike(freeBoardLikeVo);
		
	}

	
	public int selectFreeBoardLike(int frb_Article_Num) throws SQLException {
		
		int likeCount = freeboardDao.selectFreeBoardLike(frb_Article_Num);
		return likeCount;
	}

	
	public FreeBoardLikeVo selectFreeBoardLikeList(FreeBoardLikeVo freeBoardLikeVo)
			throws SQLException {
		
		FreeBoardLikeVo freeBoardLike = freeboardDao.selectFreeBoardLikeList(freeBoardLikeVo);
				return freeBoardLike;
	}

	
	public void updateFreeBoardCount(FreeBoardVo freeBoardVo)
			throws SQLException {
		
		freeboardDao.updateFreeBoardCount(freeBoardVo);
		
	}

	
	public void updateFreeBoardCountM(FreeBoardVo freeBoardVo)
			throws SQLException {
		freeboardDao.updateFreeBoardCountM(freeBoardVo);
		
	}

	
	public List<FreeBoardVo> selectFreeLikeCountViewList() throws SQLException {
		List<FreeBoardVo> list = new ArrayList<FreeBoardVo>();
		list = freeboardDao.selectFreeLikeCountViewList();
		return list;
		
	}
	
	public int freeBoardSearchCount (FreeBoardVo freeBoardVo)throws SQLException{
		int totalCount =freeboardDao.freeBoardSearchCount(freeBoardVo);
		return totalCount;
	}
	//내가쓴글 리스트 
	public List<FreeBoardVo> frb_myPost(FreeBoardVo freeBoardVo) throws SQLException{
		List<FreeBoardVo> list = freeboardDao.frb_myPost(freeBoardVo);
		return list;
	}
	//내가쓴글 리스트 페이징
	public int frb_myPostCount(FreeBoardVo freeboardVo) throws SQLException{
		int totalCount = freeboardDao.frb_myPostCount(freeboardVo);
		return totalCount;
	}
	
}
