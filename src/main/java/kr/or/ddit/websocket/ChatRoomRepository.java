package kr.or.ddit.websocket;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class ChatRoomRepository {
    private Map<String, ChatRoom> chatRoomMap;

    public ChatRoomRepository() {
    	chatRoomMap = new HashMap<String, ChatRoom>(); 
    	chatRoomMap.put("1번방", ChatRoom.create("1번방"));
    	chatRoomMap.put("2번방", ChatRoom.create("2번방"));        
    }

    public ChatRoom getChatRoom(String id) {
        return chatRoomMap.get(id);
    }
    
    public Collection<ChatRoom> getChatRooms() {
        return chatRoomMap.values();
    }
}
