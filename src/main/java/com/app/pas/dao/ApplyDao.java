package com.app.pas.dao;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dto.ApplyVo;

public interface ApplyDao {

	public List<ApplyVo> selectApplyList()throws SQLException;
	public ApplyVo selectApply(int apply_Num)throws SQLException;
	public void insertApply(ApplyVo applyVo)throws SQLException;
	public void updateApply(ApplyVo applyVo)throws SQLException;
	public void deleteApply(ApplyVo applyVo)throws SQLException;
	public List<Integer> selectApplyById(String mem_Email) throws SQLException;
}
