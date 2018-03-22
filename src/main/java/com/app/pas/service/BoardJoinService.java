package com.app.pas.service;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dao.BoardJoinDao;
import com.app.pas.dto.BoardJoinVo;
import com.app.pas.dto.MemberVo;

public class BoardJoinService {

	private BoardJoinDao boardJoinDao;

	public void setBoardJoinDao(BoardJoinDao boardJoinDao) {
		this.boardJoinDao = boardJoinDao;
	}
	
	public boolean insertBoardJoinDao(BoardJoinVo boardJoinVo) throws SQLException{
		int result = boardJoinDao.insertBoardJoin(boardJoinVo);
		boolean flag = false;
		if(result>=1){
			flag = true;
		}
		return flag;
	}
	public List<BoardJoinVo> selectBoardJoinList(int bm_Num) throws SQLException{
		List<BoardJoinVo> list = boardJoinDao.selectBoardJoinList(bm_Num);
		return list;
	}

	public void updateBoardJoin(BoardJoinVo boardJoinVo) throws SQLException{
		boardJoinDao.updateBoardJoin(boardJoinVo);
	}


	public BoardJoinVo selectBoardJoinByEmailBmNum(BoardJoinVo boardJoinVo) throws SQLException{
		BoardJoinVo boardJoin = boardJoinDao.selectBoardJoinByEmailBmNum(boardJoinVo);
		return boardJoin;
	}

	public List<MemberVo> selectBoardJoinNotInMemberList (BoardJoinVo boardJoinVo) throws SQLException{
		List<MemberVo> list = boardJoinDao.selectBoardJoinNotInMemberList(boardJoinVo);
		return list;
	}


}
