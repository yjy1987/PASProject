package com.app.pas.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dao.BoardManagementDao;
import com.app.pas.dto.BoardManagementVo;
import com.ibatis.sqlmap.client.SqlMapClient;

public class BoardManagementDaoImpl implements BoardManagementDao {
	
	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	@Override
	public int insertBoardManagement(BoardManagementVo boardManagementVo)
			throws SQLException {
		int result  = client.update("insertBoardManagement",boardManagementVo);
		return result;
	}

	@Override
	public BoardManagementVo selectLastColumn(String bm_Mem_Email) throws SQLException {
		BoardManagementVo boardManagementVo =(BoardManagementVo) client.queryForObject("selectLastColumn",bm_Mem_Email);
		return boardManagementVo;
	}

	@Override
	public List<BoardManagementVo> selectBoardList(int bm_Proj_Num)
			throws SQLException {
		List<BoardManagementVo> list = client.queryForList("selectBoardList",bm_Proj_Num);
		return list;
	}

	@Override
	public void deleteBoardManagement(int bm_Num) throws SQLException {
		client.update("deleteBoardManagement",bm_Num);
	}

	@Override
	public BoardManagementVo selectBoardByBmNum(int bm_Num) throws SQLException {
		BoardManagementVo boardManagementVo = (BoardManagementVo) client.queryForObject("selectBoardByBmNum",bm_Num);
		return boardManagementVo;
	}

	@Override
	public int selectBoardCount(int bm_Num) throws SQLException {
		int resultCount = (Integer) client.queryForObject("selectBoardCount",bm_Num);
		return resultCount;
	}

}
