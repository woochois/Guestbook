package com.guest.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guest.dao.MessageDao;
import com.guest.jdbc.ConnectionProvider;
import com.guest.jdbc.JdbcUtil;
import com.guest.model.Message;

@WebServlet("/MessageDaiListTestServlet")
public class MessageDaoSelectListTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = null;
		int firstRow = 1;
		int endRow = 20;
		try {
			conn = ConnectionProvider.getConnection();
			MessageDao dao = MessageDao.getInstance();

			List<Message> list = dao.selectList(conn, firstRow, endRow);
			for (int i = 0; i < list.size(); i++) {
				System.out.println("----" + (i + 1) + "----");
				System.out.println(list.get(i));
			}
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
