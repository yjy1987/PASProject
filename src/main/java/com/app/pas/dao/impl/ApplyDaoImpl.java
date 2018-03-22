package com.app.pas.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dao.ApplyDao;
import com.app.pas.dto.ApplyVo;
import com.ibatis.sqlmap.client.SqlMapClient;

public class ApplyDaoImpl implements ApplyDao{

	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}
	@Override
	public List<ApplyVo> selectApplyList() throws SQLException {
		List<ApplyVo> list = client.queryForList("selectApplyList");
		return list;
	}

	@Override
	public ApplyVo selectApply(int apply_Num) throws SQLException {
		ApplyVo applyVo = (ApplyVo) client.queryForObject("selectApply",apply_Num);
		return applyVo;
	}

	@Override
	public void insertApply(ApplyVo applyVo) throws SQLException {	
		client.insert("insertApply",applyVo);
	}

	@Override
	public void updateApply(ApplyVo applyVo) throws SQLException {
		client.update("updateApply",applyVo);
	}

	@Override
	public void deleteApply(ApplyVo applyVo) throws SQLException {
		client.delete("deleteApply",applyVo);
	}
	@Override
	public List<Integer> selectApplyById(String mem_Email) throws SQLException {
		List<Integer> list = client.queryForList("selectApplyById", mem_Email);
		return list;
	}

}
