package interfaces;

import chatroom.Message;

public abstract class Member {
	public String chatUsername;
	private Mediator mediator;

	public Member(String name,Mediator m) {
		chatUsername = name;
		mediator = m;
	}

	public void Send(Message msg) {
		msg.sender = this;
		mediator.send(msg);
	}

}
