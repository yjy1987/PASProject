package com.app.pas.dao.board;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dto.board.FreeBoardLikeVo;
import com.app.pas.dto.board.FreeBoardVo;

public interface FreeBoardDao {
	
	public List<FreeBoardVo> selectFreeBoardList(FreeBoardVo freeBoardVo)throws SQLException;
	public FreeBoardVo selectFreeBoard(int frb_Article_Num)throws SQLException;
	public void insertFreeBoard(FreeBoardVo freeBoardVo)throws SQLException;
	public void updateFreeBoard(FreeBoardVo freeBoardVo)throws SQLException;
	public void deleteFreeBoard(int frb_Article_Num)throws SQLException;
	public FreeBoardVo selectFreeBoardDetail(int frb_Article_Num) throws SQLException;
	public int selectTotalCount() throws SQLException;
	public void insertFreeboardLike(FreeBoardLikeVo freeBoardLikeVo)throws SQLException;
	public void deleteFreeboardLike(FreeBoardLikeVo freeBoardLikeVo)throws SQLException;
	public int selectFreeBoardLike(int frb_Article_Num) throws SQLException;
	public FreeBoardLikeVo selectFreeBoardLikeList(FreeBoardLikeVo freeBoardLikeVo)throws SQLException;
	public void updateFreeBoardCount(FreeBoardVo freeBoardVo)throws SQLException;
	public void updateFreeBoardCountM(FreeBoardVo freeBoardVo)throws SQLException;
	public List<FreeBoardVo> selectFreeLikeCountViewList()throws SQLException;
	public int freeBoardSearchCount (FreeBoardVo freeBoardVo) throws SQLException;
	
	public List<FreeBoardVo>frb_myPost(FreeBoardVo freeBoardVo) throws SQLException;
	public int frb_myPostCount(FreeBoardVo freeBoardVo) throws SQLException;
	
}
