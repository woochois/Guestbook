package com.guest.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guest.model.Message;
import com.guest.service.WriteMessageService;

@WebServlet("/WriteMessageServiceTestServlet")
public class WriteMessageServiceTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		WriteMessageService service = WriteMessageService.getInstance(); // 하나의 객체를 만들어 주기 위해서.

		Message message = new Message();
		message.setGuestName("백두산");
		message.setPassword("seoul");
		message.setMessage("제주도 삼다수");

		service.write(message);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
