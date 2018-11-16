package chatroom;

import interfaces.Mediator;
import interfaces.Member;

public class ChatMember extends Member {
	public Message lastRecievedMessage;
	public ChatMember(String name, Mediator m) {
		super(name, m);
	}

	public void receive(Message msg) {
		lastRecievedMessage = msg;
	}
	
	@Override
	public String toString() {
		return super.chatUsername;
	}
}
