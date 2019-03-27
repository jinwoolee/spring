package kr.or.ddit.websocket;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
public class ChatController {
	private final ChatRoomRepository repository;
	private final AtomicInteger seq = new AtomicInteger(0);

	@Autowired
    public ChatController(ChatRoomRepository repository) {
        this.repository = repository;
    }

	@GetMapping("/rooms")
	public String rooms(Model model) {
		model.addAttribute("rooms", repository.getChatRooms());
		return "/websocket/room-list";
	}

	@GetMapping("/rooms/{id}")
	public String room(@PathVariable String id, Model model) {
		ChatRoom room = repository.getChatRoom(id);
		model.addAttribute("room", room);
		model.addAttribute("member", "member" + seq.incrementAndGet()); // 회원 이름
																		// 부여
		return "/chat/room";
	}
}
