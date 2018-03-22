package com.app.pas.dao;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dto.PositionVo;

public interface PositionDao {
	public PositionVo selectPosition(String position_Num)throws SQLException;
	public void updatePosition(PositionVo positionVo)throws SQLException;
}
