package com.guest.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guest.service.GetMessageListService;
import com.guest.service.MessageListView;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pageStr = request.getParameter("page");
		int page = 1;

		if (pageStr != null) {
			page = Integer.valueOf(pageStr);
		}

		GetMessageListService service = GetMessageListService.getInstance();
		MessageListView list = service.getMessageList(page);

		request.setAttribute("list", list);

		request.getRequestDispatcher("/WEB-INF/view/main.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
