package com.guest.exceptions;

import java.sql.Connection;
import java.sql.SQLException;

import com.guest.dao.MessageDao;
import com.guest.jdbc.ConnectionProvider;
import com.guest.jdbc.JdbcUtil;
import com.guest.model.Message;

public class DeleteMessageService {
	private static DeleteMessageService instance = new DeleteMessageService();

	public static DeleteMessageService getInstance() {
		return instance;
	}

	private DeleteMessageService() {

	}

	public String deleteMessage(int messageId, String password) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);

			MessageDao messageDao = MessageDao.getInstance();
			Message message = messageDao.select(conn, messageId);
			if (message == null) {
				throw new MessageNotFoundException("메시지 없음");
			}
			if (!message.matchPassword(password)) {
				throw new InvalidPasswordException("Bad password");
			}
			messageDao.delete(conn, messageId);
			conn.commit();

			return "삭제 성공";
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new ServiceException("삭제 실패:" + e.getMessage(), e);
		} catch (InvalidPasswordException | MessageNotFoundException e) {
			JdbcUtil.rollback(conn);
			throw e;
		} finally {
			JdbcUtil.close(conn);
		}
	}
}
