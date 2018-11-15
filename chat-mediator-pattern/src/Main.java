import chatroom.ChatMember;
import chatroom.ChatRoomMediator;
import chatroom.Message;

public class Main {
	public static void main(String[] args) {
		ChatRoomMediator mediator = new ChatRoomMediator();
		ChatMember member1 = new ChatMember("member1", mediator);
		ChatMember member2 = new ChatMember("member2", mediator);
		ChatMember member3 = new ChatMember("member3", mediator);
		ChatMember member4 = new ChatMember("member4", mediator);
		mediator.AddChatmember(member1);
		mediator.AddChatmember(member2);
		mediator.AddChatmember(member3);
		mediator.AddChatmember(member4);
		member1.Send(new Message("Hello World!"));
	}
}
