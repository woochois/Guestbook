package com.guest.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guest.model.Message;
import com.guest.service.WriteMessageService;

@WebServlet("/write")
public class WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Message message = new Message();

		String name = request.getParameter("name");
		String pw = request.getParameter("password");
		String msg = request.getParameter("message");

		if (name == null || pw == null || msg == null || name.isEmpty() || pw.isEmpty() || msg.isEmpty()) {
			request.getSession().setAttribute("info", "이름, 암호, 메시지를 꼭 입력하세요.");
		} else {

			message.setGuestName(name);
			message.setPassword(pw);
			message.setMessage(msg);

			boolean success = WriteMessageService.getInstance().write(message);

			if (success) {
				request.getSession().setAttribute("info", "메시지가 등록되었습니다.");
			} else {
				request.getSession().setAttribute("info", "메시지 등록에 실패하였습니다.");
			}

		}
		response.sendRedirect("main");
	}
}
