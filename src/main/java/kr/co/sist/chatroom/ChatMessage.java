package kr.co.sist.chatroom;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ChatMessage {
	public enum MessageType {
		CHAT, JOIN, LEAVE
	}
	
	private MessageType type;
	private String content;
	private String sender;
	private String timestamp;
	
}
