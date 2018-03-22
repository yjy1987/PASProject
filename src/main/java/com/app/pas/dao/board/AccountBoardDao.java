package com.app.pas.dao.board;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dto.board.AccountBoardVo;

public interface AccountBoardDao {
  
	public List<AccountBoardVo> selectAccountBoardByProj(int proj_Num)throws SQLException;
	public AccountBoardVo selectAccountBoardByAcc(AccountBoardVo accountBoardVo)throws SQLException;
	public void insertAccountBoard(AccountBoardVo accountBoardVo)throws SQLException;
	public void updateAccountBoard(AccountBoardVo accountBoardVo)throws SQLException;
	public void deleteAccountBoard(AccountBoardVo accountBoardVo)throws SQLException;	
	public int sumAccountImp(int proj_Num) throws SQLException;
	public int sumAccountExp(int proj_Num) throws SQLException;
	public int selectAccountCount(int proj_Num) throws SQLException;
	
	
}
