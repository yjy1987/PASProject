package com.app.pas.service;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dao.ApplyDao;
import com.app.pas.dto.ApplyVo;

public class ApplyService {

	
	private ApplyDao applyDao;
	


	public void setApplyDao(ApplyDao applyDao) {
		this.applyDao = applyDao;
	}
	
	public List<Integer> selectApplyById(String mem_Email) throws SQLException{
		List<Integer> list =applyDao.selectApplyById(mem_Email);
		return list;
	}
	
	public void deleteApply(ApplyVo applyVo) throws SQLException{
		applyDao.deleteApply(applyVo);
	}
	
	
}
