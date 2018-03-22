package com.app.pas.dao.board.impl;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dao.board.ProjectBoardReplyDao;
import com.app.pas.dto.board.ProjectBoardReplyVo;
import com.ibatis.sqlmap.client.SqlMapClient;

public class ProjectBoardReplyDaoImpl implements ProjectBoardReplyDao{

	private SqlMapClient client;
	
	public void setClient(SqlMapClient client){
		this.client = client;
	}
	
	@Override
	public List<ProjectBoardReplyVo> selectProjectBoardReply(int pb_Article_num)
			throws SQLException {
		List<ProjectBoardReplyVo> list = client.queryForList("selectProjectBoardReply", pb_Article_num);
		return list;
	}

	@Override
	public void insertProjectBoardReply(ProjectBoardReplyVo projectBoardReplyVo)
			throws SQLException {
		client.insert("insertProjectBoardReply",projectBoardReplyVo);
		
	}

	@Override
	public void updateProjectBoardReply(ProjectBoardReplyVo projectBoardReplyVo)
			throws SQLException {
		client.update("updateProjectBoardReply",projectBoardReplyVo);
		
	}

	@Override
	public void deleteProjectBoardReply(int pb_Reply_Num) throws SQLException {
		client.update("deleteProjectBoardReply",pb_Reply_Num);
		
	}

	
	
	


}
