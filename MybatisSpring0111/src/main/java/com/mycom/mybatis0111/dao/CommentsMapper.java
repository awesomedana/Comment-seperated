package com.mycom.mybatis0111.dao;

import java.util.ArrayList;

import com.mycom.mybatis0111.vo.Comments;

public interface CommentsMapper {
	public int insertComments(Comments comments);//댓글 입력하기
	public ArrayList<Comments> commentsList(String boardseq);//댓글 전체 보기
	public void deleteComments(String commentseq);//댓글 삭제하기
}
