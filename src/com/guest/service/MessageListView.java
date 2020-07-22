package com.guest.service;

import java.util.List;

import com.guest.model.Message;

public class MessageListView {
	private int messageTotalCount;
	private int currentPageNumber;
	private List<Message> messageList;
	private int pageTotalCount;
	private int messageCountPerPage;
	private int firstRow;
	private int endRow;

	@Override
	public String toString() {
		return "MessageListView [messageTotalCount=" + messageTotalCount + ", currentPageNumber=" + currentPageNumber
				+ ", messageList=" + messageList + ", pageTotalCount=" + pageTotalCount + ", messageCountPerPage="
				+ messageCountPerPage + ", firstRow=" + firstRow + ", endRow=" + endRow + "]";
	}

	public MessageListView(List<Message> messageList, int messageTotalCount, int currentPageNumber,
			int messageCountPerPage, int startRow, int endRow) {
		this.messageList = messageList;
		this.messageTotalCount = messageTotalCount;
		this.currentPageNumber = currentPageNumber;
		this.messageCountPerPage = messageCountPerPage;
		this.firstRow = startRow;
		this.endRow = endRow;

		calculatePageTotalCount();
	}

	private void calculatePageTotalCount() {
		if (messageTotalCount == 0) {
			pageTotalCount = 0;
		} else {
			pageTotalCount = messageTotalCount / messageCountPerPage;
			if (messageTotalCount % messageCountPerPage > 0) {
				pageTotalCount++;
			}
		}
	}

	public int getMessageTotalCount() {
		return messageTotalCount;
	}

	public int getCurrentPageNumber() {
		return currentPageNumber;
	}

	public List<Message> getMessageList() {
		return messageList;
	}

	public int getPageTotalCount() {
		return pageTotalCount;
	}

	public int getMessageCountPerPage() {
		return messageCountPerPage;
	}

	public int getFirstRow() {
		return firstRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public boolean isEmplty() {
		return messageTotalCount == 0;
	}

}
