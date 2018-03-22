package com.app.pas.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dao.ProjectJoinDao;
import com.app.pas.dto.ProjectJoinVo;
import com.ibatis.sqlmap.client.SqlMapClient;

public class ProjectJoinDaoImpl implements ProjectJoinDao {

	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	@Override
	public List<ProjectJoinVo> selectProjectJoinList() throws SQLException {
		List<ProjectJoinVo> list = client.queryForList("selectProjectJoinList");
		return list;
	}

	@Override
	public ProjectJoinVo selectProjectJoin(ProjectJoinVo projectJoinVo)
			throws SQLException {
		ProjectJoinVo projectJoin = (ProjectJoinVo) client.queryForObject("selectProjectJoin",projectJoinVo);
		return projectJoin;
	}

	@Override
	public void insertProjectJoin(ProjectJoinVo projectJoinVo)
			throws SQLException {
		client.insert("insertProjectJoin",projectJoinVo);
		
	}

	@Override
	public void updateProjectJoin(ProjectJoinVo projectJoinVo)
			throws SQLException {
		client.update("updateProjectJoin",projectJoinVo);
	}

	@Override
	public void deleteProjectJoin(ProjectJoinVo projectJoinVo)
			throws SQLException {
		client.update("deleteProjectJoin",projectJoinVo);
	}

	@Override
	public void updateProjectJoinColor(ProjectJoinVo projectJoinVo)
			throws SQLException {
		client.update("updateProjectJoinColor",projectJoinVo);
		
	}

	@Override
	public void updatePosition(ProjectJoinVo projectJoinVo) throws SQLException {
		client.update("updatePositionNum",projectJoinVo);
		
	}

	@Override
	public int selectJoinCountMember(int proj_Num) throws SQLException {
		int count = (Integer) client.queryForObject("selectJoinCountMember",proj_Num);
		return count;
	}
	
}
