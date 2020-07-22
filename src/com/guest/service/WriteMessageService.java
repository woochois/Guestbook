package com.guest.service;

import java.sql.Connection;

import com.guest.dao.MessageDao;
import com.guest.jdbc.ConnectionProvider;
import com.guest.jdbc.JdbcUtil;
import com.guest.model.Message;

public class WriteMessageService {
	private static WriteMessageService instance = new WriteMessageService();

	public static WriteMessageService getInstance() {
		return instance;
	}

	private WriteMessageService() {

	}

	public void write(Message message) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			MessageDao messageDao = MessageDao.getInstance();
			messageDao.insert(conn, message);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn);
		}
	}
}
