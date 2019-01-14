package com.mycom.mybatis0111;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycom.mybatis0111.dao.CommentsDao;
import com.mycom.mybatis0111.vo.Comments;

@Controller
public class CommentsController {
	@Autowired
	CommentsDao dao;
	
	@RequestMapping(value="/insertComments", method=RequestMethod.POST)
	public String insertComments(HttpSession session, String boardseq, Comments comments, Model model) {
		if (session.getAttribute("loginId") == null) {//로그인 session이 만료되지 않았는지 session검사
			return "login";
		}

		comments.setId((String)session.getAttribute("loginId"));
		
		int result = dao.insertComments(comments);
		if (result == 0) {
			model.addAttribute("warning", "댓글 등록에 실패했습니다.");
		}
		
		model.addAttribute("boardseq", boardseq);
		
		return "redirect:/boardDetail?boardseq="+boardseq;
	}
	
	//댓글 삭제하기
	@RequestMapping(value="/deleteComments", method=RequestMethod.GET)
	public String deleteComments(String commentseq, String boardseq, Model model) {
		dao.deleteComments(commentseq);
		model.addAttribute("boardseq", boardseq);
		return "redirect:/boardDetail";
	}
}
