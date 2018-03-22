package com.app.pas.dao;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dto.DeadLineVo;

public interface DeadLineDao {

	public DeadLineVo selectDeadLine(int gt_Num)throws SQLException;
	public void insertDeadLine(DeadLineVo deadLineVo)throws SQLException;
	public void updateDeadLine(DeadLineVo deadLineVo)throws SQLException;
	public void deleteDeadLine(int gt_Num)throws SQLException;
}
