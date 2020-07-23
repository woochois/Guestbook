package com.guest.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guest.exceptions.DeleteMessageService;

@WebServlet("/DeleteMessageServiceTestServlet")
public class DeleteMessageServiceTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DeleteMessageService service = DeleteMessageService.getInstance();

		int messageId = 28;

		String password = "hong";

		String info = service.deleteMessage(messageId, password);

		System.out.println(info);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
