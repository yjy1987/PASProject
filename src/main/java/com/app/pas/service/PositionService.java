package com.app.pas.service;

import java.sql.SQLException;

import com.app.pas.dao.PositionDao;
import com.app.pas.dto.PositionVo;

public class PositionService {

	
	private PositionDao positionDao;

	public void setPositionDao(PositionDao positionDao) {
		this.positionDao = positionDao;
	}
	
}
