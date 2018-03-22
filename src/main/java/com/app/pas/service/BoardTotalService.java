package com.app.pas.service;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dao.BoardTotalDao;
import com.app.pas.dto.BoardTotalVo;

public class BoardTotalService {

	private BoardTotalDao boardTotalDao;

	public void setBoardTotalDao(BoardTotalDao boardTotalDao) {
		this.boardTotalDao = boardTotalDao;
	}
	
	public List<BoardTotalVo> selectBoardTotalList(int bt_Num) throws SQLException{
		List<BoardTotalVo> list = boardTotalDao.selectBoardTotalList(bt_Num);
		return list;
	}
	
	public void insertBoardTotal(BoardTotalVo boardTotalVo) throws SQLException{
		boardTotalDao.insertBoardTotal(boardTotalVo);
	}
	
	public BoardTotalVo selectBoardTotalByBtNum(int bt_Num) throws SQLException{
		BoardTotalVo boardTotalVo = boardTotalDao.selectBoardTotalByBtNum(bt_Num);
		return boardTotalVo;
	}
	
	public void updateBoardTotal(BoardTotalVo boardTotalVo) throws SQLException{
		boardTotalDao.updateBoardTotal(boardTotalVo);
	}
	
	public void deleteBoardTotal(int bt_Num)throws SQLException{
		boardTotalDao.deleteBoardTotal(bt_Num);
	}
	
	public int totalCountBoardTotalList(int bm_Num) throws SQLException{
		int resultCount = boardTotalDao.totalCountBoardTotalList(bm_Num);
		return resultCount;
	}
}
