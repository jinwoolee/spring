package kr.or.ddit.websocket;


import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.fasterxml.jackson.databind.ObjectMapper;

//진행중 https://supawer0728.github.io/2018/03/30/spring-websocket/
public class ChatRoom {
	private String id;
	private String name;
	private Set<WebSocketSession> sessions = new HashSet<>();

	public void handleMessage(WebSocketSession session, ChatMessage chatMessage, ObjectMapper objectMapper) {

		if (chatMessage.getType() == MessageType.JOIN) {
			join(session);
			chatMessage.setMessage(chatMessage.getWriter() + "님이 입장했습니다.");
		}

		send(chatMessage, objectMapper);
	}

	private void join(WebSocketSession session) {
		sessions.add(session);
	}

	private <T> void send(T messageObject, ObjectMapper objectMapper) throws IOException {

		TextMessage message = new TextMessage(objectMapper.writeValueAsString(messageObject));
		for(WebSocketSession session : sessions)			
			session.sendMessage(message);
	}

}
