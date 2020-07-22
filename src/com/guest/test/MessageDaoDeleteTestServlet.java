package com.guest.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guest.dao.MessageDao;
import com.guest.jdbc.ConnectionProvider;
import com.guest.jdbc.JdbcUtil;

@WebServlet("/MessageDaoDeleteTestServlet")
public class MessageDaoDeleteTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = null;
		int messageId = 3;
		try {
			conn = ConnectionProvider.getConnection();
			MessageDao dao = MessageDao.getInstance();
			System.out.println(dao.delete(conn, messageId) + "개 삭제됨");
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
