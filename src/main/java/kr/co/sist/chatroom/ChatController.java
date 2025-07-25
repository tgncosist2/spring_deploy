package kr.co.sist.chatroom;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {

	@GetMapping("/chatroom")
	public String chatroom() {
		return "chat/chatroom";
	}
	
    @MessageMapping("/chat/{roomId}")
    @SendTo("/queue/chat/{roomId}") 
    public ChatMessage sendMessage(@DestinationVariable String roomid, ChatMessage message) {
        return message;
    }
    
    
	
}
