package chatroom;

import java.util.ArrayList;
import java.util.List;

import interfaces.Mediator;

public class ChatRoomMediator implements Mediator {
	private List<ChatMember> listOfChatmembers;

	public void AddChatmember(ChatMember member) {
		if (listOfChatmembers == null) {
			listOfChatmembers = new ArrayList<ChatMember>();
		}
		listOfChatmembers.add(member);
	}

	@Override
	public void send(Message msg) {
		for (ChatMember m : listOfChatmembers) {
			if (m != msg.sender) {
				m.receive(msg);
			}
		}
	}

}
