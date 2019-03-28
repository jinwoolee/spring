package kr.or.ddit.websocket;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SocketChatController {
	
	@Autowired
	private SocketChatHandler socketHandler;
	
	@RequestMapping("/socket/view")
	public String socketView(HttpSession session, String userId) {
		
		session.setAttribute("userId", userId);
		return "websocket/chatView";
	}
	
	@RequestMapping("/socket/serverToClient")
	public void serverToClient() throws IOException {
		socketHandler.serverToClient();
	}
	
//	@RequestMapping("/socket/serverToClient")
//	public void serverToClient(HttpSession session) throws IOException {
//		socketHandler.serverToClient(session);
//	}
}
