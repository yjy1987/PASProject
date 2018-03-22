package com.app.pas.dao.board;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dto.board.QnaBoardVo;

public interface QnaBoardDao {
  
	  public List<QnaBoardVo> selectQnaBoardList(QnaBoardVo qnaBoardVo)throws SQLException;
	  public List<QnaBoardVo>selectAllQna()throws SQLException;
	  public QnaBoardVo selectQnaBoard(int qb_Article_Num)throws SQLException;
	  public void insertQnaBoard(QnaBoardVo qnaBoardVo)throws SQLException;
	  public void updateQnaBoard(QnaBoardVo qnaBoardVo)throws SQLException;
	  public void deleteQnaBoard(int qb_Article_Num)throws SQLException;
	  public int QnaSelectTotalCount()throws SQLException;
	  public void updateQnaYN(int qb_Article_Num)throws SQLException;
	  public void deleteQnaYN(int qb_Article_Num )throws SQLException;
	  public void QnaBoardCount(int keyword)throws SQLException;
	  public int QnaSearchTotalCount(QnaBoardVo qnaBoardVo)throws SQLException;
	  public List<QnaBoardVo> myPostList(QnaBoardVo qnaBoardVo) throws SQLException;
	  public int myPostListCount(QnaBoardVo qnaBoardVo)throws SQLException;
	  public int selectNCount() throws SQLException;
	  

	  
}
