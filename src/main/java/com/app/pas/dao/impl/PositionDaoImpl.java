package com.app.pas.dao.impl;

import java.sql.SQLException;

import com.app.pas.dao.PositionDao;
import com.app.pas.dto.PositionVo;
import com.ibatis.sqlmap.client.SqlMapClient;

public class PositionDaoImpl implements PositionDao {

	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}
	@Override
	public PositionVo selectPosition(String position_Num) throws SQLException {
		PositionVo positionVo = (PositionVo) client.queryForObject("selectPosition",position_Num);
		return positionVo;
	}

	@Override
	public void updatePosition(PositionVo positionVo) throws SQLException {
		client.update("updatePosition",positionVo);
	}

}
