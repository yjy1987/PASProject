package com.app.pas.dao.board.impl;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dao.board.FreeBoardDao;
import com.app.pas.dto.board.FreeBoardLikeVo;
import com.app.pas.dto.board.FreeBoardVo;
import com.ibatis.sqlmap.client.SqlMapClient;

public class FreeBoardDaoImpl implements FreeBoardDao{
	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	@Override
	public List<FreeBoardVo> selectFreeBoardList(FreeBoardVo freeBoardVo) throws SQLException {
		List<FreeBoardVo> list = client.queryForList("selectFreeBoardList",freeBoardVo);
		return list;
	}

	@Override
	public FreeBoardVo selectFreeBoard(int frb_Article_Num) throws SQLException {
		FreeBoardVo freeBoardVo = (FreeBoardVo) client.queryForObject("selectFreeBoard",frb_Article_Num);
		return freeBoardVo;
	}

	@Override
	public void insertFreeBoard(FreeBoardVo freeBoardVo) throws SQLException {
		client.insert("insertFreeBoard",freeBoardVo);
	}

	@Override
	public void updateFreeBoard(FreeBoardVo freeBoardVo) throws SQLException {
		client.update("updateFreeBoard",freeBoardVo);
	}

	@Override
	public void deleteFreeBoard(int frb_Article_Num) throws SQLException {
		client.delete("deleteFreeBoard",frb_Article_Num);
	}

	@Override
	public FreeBoardVo selectFreeBoardDetail(int frb_Article_Num)
			throws SQLException {
		FreeBoardVo freeBoardVo = (FreeBoardVo) client.queryForObject("selectFreeBoardDetail",frb_Article_Num);
		return freeBoardVo;
	}

	@Override
	public int selectTotalCount() throws SQLException {
		int totalCount = (Integer) client.queryForObject("selectTotalCount");
		return totalCount;
	}

	@Override
	public void insertFreeboardLike(FreeBoardLikeVo freeBoardLikeVo)
			throws SQLException {
		client.update("insertFreeboardLike", freeBoardLikeVo);
		
	}

	@Override
	public void deleteFreeboardLike(FreeBoardLikeVo freeBoardLikeVo)
			throws SQLException {
		client.update("deleteFreeboardLike", freeBoardLikeVo);
		
	}

	@Override
	public int selectFreeBoardLike(int frb_Article_Num) throws SQLException {
		int likeCount = (Integer)client.queryForObject("selectFreeBoardLike", frb_Article_Num);
		return likeCount;
	}

	@Override
	public FreeBoardLikeVo selectFreeBoardLikeList(FreeBoardLikeVo freeBoardLikeVo)
			throws SQLException {
		FreeBoardLikeVo freeBoardLike =
				(FreeBoardLikeVo)client.queryForObject("selectFreeBoardLikeList",freeBoardLikeVo);
		return freeBoardLike;
	}

	@Override 
	public void updateFreeBoardCount(FreeBoardVo freeBoardVo)
			throws SQLException {
		client.update("updateFreeBoardCount",freeBoardVo);
		
	}

	@Override
	public void updateFreeBoardCountM(FreeBoardVo freeBoardVo)
			throws SQLException {
		client.update("updateFreeBoardCountM",freeBoardVo);
		
	}

	@Override
	public List<FreeBoardVo> selectFreeLikeCountViewList() throws SQLException {
		List<FreeBoardVo> list = client.queryForList("selectFreeLikeCountViewList");
		return list;
	}

	@Override
	public int freeBoardSearchCount(FreeBoardVo freeBoardVo)
			throws SQLException {
		int likeCount = (Integer)client.queryForObject("freeBoardSearchCount", freeBoardVo);
		return likeCount;
	}

	@Override
	public List<FreeBoardVo> frb_myPost(FreeBoardVo freeBoardVo)
			throws SQLException {
		List<FreeBoardVo> list = client.queryForList("frb_myPost",freeBoardVo);
		return list;
	}

	@Override
	public int frb_myPostCount(FreeBoardVo freeBoardVo) throws SQLException {
		int totalCount = (Integer) client.queryForObject("frb_myPostCount", freeBoardVo);
		return totalCount;
	}

}
