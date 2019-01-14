package com.mycom.mybatis0111.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycom.mybatis0111.vo.Comments;

@Repository
public class CommentsDao {
	@Autowired
	SqlSession session;
	
	public int insertComments(Comments comments) {
		int result = 0;
		CommentsMapper mapper = session.getMapper(CommentsMapper.class);
		try {
			result = mapper.insertComments(comments);
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}

		return result;
	}
	
	//댓글 전체 보이기
	public ArrayList<Comments> commentsList(String boardseq){
		ArrayList<Comments> cList = null;
		CommentsMapper mapper = session.getMapper(CommentsMapper.class);
		try {
			cList = mapper.commentsList(boardseq);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return cList;
	}
	
	//댓글 삭제하기
	public void deleteComments(String commentseq) {
		CommentsMapper mapper = session.getMapper(CommentsMapper.class);
		try {
			mapper.deleteComments(commentseq);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
