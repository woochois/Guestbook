package com.guest.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guest.dao.MessageDao;
import com.guest.jdbc.JdbcUtil;
import com.guest.model.Message;

@WebServlet("/MessageDaoInsertTestServlet")
public class MessageDaoInsertTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:guestbook");
			Message message = new Message();

			message.setGuestName("홍길동" + Math.floor(Math.random() * 100));
			message.setPassword("hong");
			message.setMessage("홍길동 다녀감" + Math.random());

			MessageDao dao = MessageDao.getInstance();
			dao.insert(conn, message);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
