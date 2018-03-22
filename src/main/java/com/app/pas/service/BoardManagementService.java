package com.app.pas.service;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dao.BoardManagementDao;
import com.app.pas.dto.BoardManagementVo;

public class BoardManagementService {

	private BoardManagementDao boardManagementDao;

	public void setBoardManagementDao(BoardManagementDao boardManagementDao) {
		this.boardManagementDao = boardManagementDao;
	}
	
	public boolean insertBoardManagement(BoardManagementVo boardManagementVo) throws SQLException{
		int result = boardManagementDao.insertBoardManagement(boardManagementVo);
		boolean flag = false;
		if(result >=1){
			flag = true;
		}
		return flag;
	}
	
	public BoardManagementVo selectLastColumn(String bm_Mem_Email) throws SQLException{
		BoardManagementVo boardManagementVo = boardManagementDao.selectLastColumn(bm_Mem_Email);
		return boardManagementVo;
	}
	public List<BoardManagementVo> selectBoardList(int bm_Proj_Num) throws SQLException{
		List<BoardManagementVo> list = boardManagementDao.selectBoardList(bm_Proj_Num);
		return list;
	}
	
	public void deleteBoardManagement(int bm_Num) throws SQLException{
		boardManagementDao.deleteBoardManagement(bm_Num);
	}
	
	public BoardManagementVo selectBoardByBmNum(int bm_Num) throws SQLException{
		BoardManagementVo boardManagementVo = boardManagementDao.selectBoardByBmNum(bm_Num);
		return boardManagementVo;
	}
	
	public int selectBoardCount(int bm_Num)	throws SQLException{
		int resultCount = boardManagementDao.selectBoardCount(bm_Num);
		return resultCount;
	}
}
