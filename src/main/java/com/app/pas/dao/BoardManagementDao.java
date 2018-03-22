package com.app.pas.dao;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dto.BoardManagementVo;

public interface BoardManagementDao {
 public int insertBoardManagement(BoardManagementVo boardManagementVo) throws SQLException;
 public BoardManagementVo selectLastColumn(String bm_Mem_Email) throws SQLException;
 public List<BoardManagementVo> selectBoardList(int bm_Proj_Num) throws SQLException;
 public void deleteBoardManagement(int bm_Num) throws SQLException;
 public BoardManagementVo selectBoardByBmNum(int bm_Num) throws SQLException;
 public int selectBoardCount(int bm_Num) throws SQLException;
}
