package com.app.pas.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dao.BoardTotalDao;
import com.app.pas.dto.BoardTotalVo;
import com.ibatis.sqlmap.client.SqlMapClient;

public class BoardTotalDaoImpl implements BoardTotalDao{

	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	@Override
	public List<BoardTotalVo> selectBoardTotalList(int bm_Num)
			throws SQLException {
		
		List<BoardTotalVo> list = client.queryForList("selectBoardTotalList",bm_Num);
		return list;
	}

	@Override
	public void insertBoardTotal(BoardTotalVo boardTotalVo) throws SQLException {
		client.update("insertBoardTotal",boardTotalVo);
	}

	@Override
	public BoardTotalVo selectBoardTotalByBtNum(int bt_Num) throws SQLException {
		BoardTotalVo boardTotalVo =(BoardTotalVo) client.queryForObject("selectBoardTotalByBtNum",bt_Num);
		return boardTotalVo;
	}

	@Override
	public void updateBoardTotal(BoardTotalVo boardTotalVo) throws SQLException {
		client.update("updateBoardTotal",boardTotalVo);
	}

	@Override
	public void deleteBoardTotal(int bt_Num) throws SQLException {
		client.update("deleteBoardTotal",bt_Num);
	}

	@Override
	public int totalCountBoardTotalList(int bm_Num) throws SQLException {
		int resultCount =(Integer) client.queryForObject("totalCountBoardTotalList",bm_Num);
		return resultCount;
	}

}
