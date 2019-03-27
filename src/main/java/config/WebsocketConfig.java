package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import kr.or.ddit.websocket.MyHandshakeInterceptor;
import kr.or.ddit.websocket.SocketHandler;




@Configuration
@EnableWebSocket
public class WebsocketConfig implements WebSocketConfigurer{

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {

		 registry.addHandler(socketHandler(), "/ws/chat")
		 			.setAllowedOrigins("*")
		 			.addInterceptors(new MyHandshakeInterceptor())
		 			.withSockJS();
	}

	@Bean
	public SocketHandler socketHandler(){
		return new SocketHandler();

	}
}
