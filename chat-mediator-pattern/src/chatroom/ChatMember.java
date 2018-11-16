package chatroom;

import interfaces.Mediator;
import interfaces.Member;

public class ChatMember extends Member {
	public ChatMember(String name, Mediator m) {
		super(name, m);
	}

	public void receive(Message msg) {
		System.out.println(
				chatUsername + " received message: '" + msg.messageText + "' from user: " + msg.sender.chatUsername);
	}

}
