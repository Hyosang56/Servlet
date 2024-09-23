package com.icia.controller.action;

import java.io.IOException;

import com.icia.dao.BoardDAO;
import com.icia.dto.BoardVO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BoardViewAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/board/boardView.jsp";
	      String num = request.getParameter("num");
	      BoardDAO bDao = BoardDAO.getInstance();
	      bDao.updateReadCount(num);
	      BoardVO bVo = bDao.selectOneBoardByNum(num);
	      request.setAttribute("board", bVo);
	      RequestDispatcher dispatcher = 
	            request.getRequestDispatcher(url);
	      dispatcher.forward(request, response);
		
	}

}
