package org.zerock.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.log4j.Log4j;

/**
 * Servlet implementation class MsgListController
 */
@WebServlet("/msg/list")
@Log4j
public class MsgListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MsgListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		log.debug("d /msg/list doGet....");
		log.info("i /msg/list doGet....");
		log.warn("w /msg/list doGet....");
		log.error("e /msg/list doGet....");
		log.fatal("f /msg/list doGet....");
		
		request.getRequestDispatcher("/WEB-INF/views/msg/list.jsp")
		.forward(request, response);
		
	}

}


