package kr.co.sist.chatroom;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration("stompWebSocketConfig")
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	/**
	 * View에서 STOMP 사용을 위한 prefix(/topic, /app)등 네이밍은 임의 지정 가능.
	 */
	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		// 클라이언트로 메세지를 보낼 때 사용할 prefix 설정 (/topic과 /queue 두개 설정한거, 하나는 지워도됨)
		config.enableSimpleBroker("/queue");
		
		// 클라이언트에서 서버로 메세지를 보낼 때 사용할 prefix 설정
		config.setApplicationDestinationPrefixes("/pub");
		
	}// configureMessageBroker

	/**
	 * addEndpoint는 localhost:8080/chat 으로 stomp 접속 URL 설정이고
	 * setAllowedOrigins는 CORS 도메인 설정인데 *은 모든 접속 허용!
	 */
	@Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // 반드시 엔드포인트를 등록해야 합니다
        registry.addEndpoint("/chat")
                .setAllowedOriginPatterns("*")
                .withSockJS();
    }
}
