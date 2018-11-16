package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import chatroom.ChatMember;
import chatroom.ChatRoomMediator;
import chatroom.Message;

public class ChatRoomTest {
	ChatRoomMediator mediator;
	ChatMember member1;
	ChatMember member2;
	ChatMember member3;
	ChatMember member4;

	@Before
	public void before() {
		mediator = new ChatRoomMediator();
		member1 = new ChatMember("member1", mediator);
		member2 = new ChatMember("member2", mediator);
		member3 = new ChatMember("member3", mediator);
		member4 = new ChatMember("member4", mediator);
		mediator.AddChatmember(member1);
		mediator.AddChatmember(member2);
		mediator.AddChatmember(member3);
		mediator.AddChatmember(member4);
	}
	
	@Test
	public void test() {
		member1.Send(new Message("Hello world"));
		String expected = "message: 'Hello world' received from member1";
		Assert.assertEquals(expected, member2.lastRecievedMessage.toString());
		Assert.assertEquals(expected, member3.lastRecievedMessage.toString());
		Assert.assertEquals(expected, member4.lastRecievedMessage.toString());
	}
}
