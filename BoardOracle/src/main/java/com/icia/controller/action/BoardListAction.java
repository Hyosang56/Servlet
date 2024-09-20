package com.icia.controller.action;

import java.io.IOException;
import java.util.List;

import com.icia.dao.BoardDAO;
import com.icia.dto.BoardVO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BoardListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/board/boardList.jsp";
	      BoardDAO bDao = BoardDAO.getInstance();
	      
	      List<BoardVO> boardList = 
	            bDao.selectAllBoards();
	      request.setAttribute("boardList",
	               boardList);
	      RequestDispatcher dispatcher = 
	      request.getRequestDispatcher(url);
	      dispatcher.forward(request, response);
		
	}

}
