package com.app.pas.dao.impl;

import java.sql.SQLException;

import com.app.pas.dao.DeadLineDao;
import com.app.pas.dto.DeadLineVo;
import com.ibatis.sqlmap.client.SqlMapClient;

public class DeadLineDaoImpl implements DeadLineDao{
	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}
	@Override
	public DeadLineVo selectDeadLine(int gt_Num) throws SQLException {
		DeadLineVo deadLineVo = (DeadLineVo) client.queryForObject("selectDeadLine",gt_Num);
		return deadLineVo;
	}

	@Override
	public void insertDeadLine(DeadLineVo deadLineVo) throws SQLException {
		client.insert("insertDeadLine",deadLineVo);
	}

	@Override
	public void updateDeadLine(DeadLineVo deadLineVo) throws SQLException {
		client.update("updateDeadLine",deadLineVo);
	}

	@Override
	public void deleteDeadLine(int gt_Num) throws SQLException {
		client.delete("deleteDeadLine",gt_Num);
	}

}
