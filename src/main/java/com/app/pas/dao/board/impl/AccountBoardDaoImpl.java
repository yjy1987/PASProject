package com.app.pas.dao.board.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.pas.dao.board.AccountBoardDao;
import com.app.pas.dto.board.AccountBoardVo;
import com.ibatis.sqlmap.client.SqlMapClient;

public class AccountBoardDaoImpl implements AccountBoardDao {

	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	@Override
	public List<AccountBoardVo> selectAccountBoardByProj(int proj_Num) throws SQLException {
		List<AccountBoardVo> list = client.queryForList("selectAccountBoardByProj",proj_Num);
		return list;
	}

	@Override
	public AccountBoardVo selectAccountBoardByAcc(AccountBoardVo accountBoardVo) throws SQLException {
		AccountBoardVo accountBoardVo1 = (AccountBoardVo) client.queryForObject("selectAccountBoardByAcc",accountBoardVo);
		return accountBoardVo1;
	}

	@Override
	public void insertAccountBoard(AccountBoardVo accountBoardVo)
			throws SQLException {
		client.insert("insertAccountBoard",accountBoardVo);
	}

	@Override
	public void updateAccountBoard(AccountBoardVo accountBoardVo)
			throws SQLException {
		client.update("updateAccountBoard",accountBoardVo);
	}

	@Override
	public void deleteAccountBoard(AccountBoardVo accountBoardVo) throws SQLException {
		client.update("deleteAccountBoard",accountBoardVo);
	}

	@Override
	public int sumAccountImp(int proj_Num) throws SQLException {
		int result = (Integer) client.queryForObject("sumAccountImp", proj_Num);
		return result;
	}

	@Override
	public int sumAccountExp(int proj_Num) throws SQLException {
		int result =(Integer) client.queryForObject("sumAccountExp", proj_Num);
				
		return result;
	}

	@Override
	public int selectAccountCount(int proj_Num) throws SQLException {
		int result =(Integer)client.queryForObject("selectAccountCount", proj_Num);
		return result;
	}

}
