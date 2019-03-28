package kr.or.ddit.websocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class SocketChatHandler extends TextWebSocketHandler {

	private static final Logger logger = LoggerFactory.getLogger(SocketChatHandler.class);

	private List<WebSocketSession> sessionList;

	public SocketChatHandler() {
		sessionList = new ArrayList<>();
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		String user = getUser(session);
		sessionList.add(session);
		logger.debug("채팅 접속 : {}", user);
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String user = getUser(session);
		logger.debug("메세지전송 = {} : {}", user, message.getPayload());
		for (WebSocketSession currentSession : sessionList) {
			currentSession.sendMessage(new TextMessage(user + " : " + message.getPayload()));
		}
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		String user = getUser(session);
		sessionList.remove(session);
		logger.debug("연결 끊김 : {}", user);
	}

	private String getUser(WebSocketSession session) {
		return (String) session.getAttributes().get("userId");
	}

	public void serverToClient() throws IOException {
		for(WebSocketSession wSession : sessionList)
			wSession.sendMessage(new TextMessage("서버 전송 메세지"));				
	}
	
//	public void serverToClient(HttpSession session) throws IOException {
//		for(WebSocketSession wSession : sessionList)
//			if(wSession.getId().equals(session.getId()))
//				wSession.sendMessage(new TextMessage("서버 전송 메세지"));				
//	}

}
