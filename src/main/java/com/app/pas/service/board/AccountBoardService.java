package com.app.pas.service.board;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dao.board.AccountBoardDao;
import com.app.pas.dto.board.AccountBoardVo;

public class AccountBoardService {

	private AccountBoardDao accountBoardDao;

	public void setAccountboardDao(AccountBoardDao accountBoardDao) {
		this.accountBoardDao = accountBoardDao;
	}

	public List<AccountBoardVo> getAccountList(int proj_Num)
			throws SQLException {

		List<AccountBoardVo> list = accountBoardDao
				.selectAccountBoardByProj(proj_Num);
		return list;
	}

	public void InsertAccountBoard(AccountBoardVo accountBoardVo)
			throws SQLException {
		accountBoardDao.insertAccountBoard(accountBoardVo);
	}
	
	public AccountBoardVo selectAccountBoardByAcc(AccountBoardVo accountBoardVo) throws SQLException{
		AccountBoardVo accountBoardVo1 =accountBoardDao.selectAccountBoardByAcc(accountBoardVo);
		return accountBoardVo1;
	}
	
	public void updateAccountBoard(AccountBoardVo accountBoardVo) throws SQLException{
	accountBoardDao.updateAccountBoard(accountBoardVo);
	
	}
	
	public void deleteAccountBoard(AccountBoardVo accountBoardVo) throws SQLException{
	accountBoardDao.deleteAccountBoard(accountBoardVo);
	}
	
    public int sumAccountImp(int proj_Num) throws SQLException{
    	int result=accountBoardDao.sumAccountImp(proj_Num);
    	
    	return result;
    }
    
    public int sumAccountExp(int proj_Num) throws SQLException{
    	int result = accountBoardDao.sumAccountExp(proj_Num);
    	return result;
    }
    
    public int selectAccountCount(int proj_Num) throws SQLException{
    	int result = accountBoardDao.selectAccountCount(proj_Num);
    	return result;
    }
    
}
