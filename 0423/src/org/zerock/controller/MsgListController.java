package org.zerock.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zerock.service.MsgService;
import org.zerock.vo.MsgVO;

import lombok.extern.log4j.Log4j;

/**
 * Servlet implementation class MsgListController
 */
@WebServlet("/msg/list")
@Log4j
public class MsgListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MsgService service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MsgListController() {
        super();
        service = new MsgService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String mid = request.getParameter("mid");

		List<MsgVO> whomList = service.getWhom(mid);
		
		request.setAttribute("rlist", whomList);
		
		List<MsgVO> whoList = service.getWho(mid);
		
		
		request.getRequestDispatcher("/WEB-INF/views/msg/list.jsp")
		.forward(request, response);
		
	}

}


