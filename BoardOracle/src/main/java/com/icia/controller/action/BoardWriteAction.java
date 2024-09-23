package com.icia.controller.action;

import java.io.IOException;

import com.icia.dao.BoardDAO;
import com.icia.dto.BoardVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BoardWriteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardVO bVo = new BoardVO();
        bVo.setName(request.getParameter("name"));
	    bVo.setPass(request.getParameter("pass"));
	    bVo.setEmail(request.getParameter("email"));      bVo.setTitle(request.getParameter("title"));
	    bVo.setContent(request.getParameter("content"));
	    BoardDAO bDao = BoardDAO.getInstance();
	    bDao.insertBoard(bVo);
	    new BoardListAction().execute(request, response);
		
	}

}
