package chatroom;

import interfaces.Member;

public class Message {
	public Member sender;
	public String messageText;

	public Message(String msgText) {
		this.messageText = msgText;
	}
	@Override
	public String toString() {
		return "message: '" + messageText + "' received from " + sender;
	}
}
