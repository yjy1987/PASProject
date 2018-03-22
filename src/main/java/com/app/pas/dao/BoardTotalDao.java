package com.app.pas.dao;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dto.BoardTotalVo;

public interface BoardTotalDao {

	public List<BoardTotalVo> selectBoardTotalList(int bm_Num) throws SQLException;
	public void insertBoardTotal(BoardTotalVo boardTotalVo) throws SQLException;
	public BoardTotalVo selectBoardTotalByBtNum(int bt_Num) throws SQLException;
	public void updateBoardTotal(BoardTotalVo boardTotalVo) throws SQLException;
	public void deleteBoardTotal(int bt_Num)throws SQLException;
	public int totalCountBoardTotalList(int bm_Num) throws SQLException;
}
