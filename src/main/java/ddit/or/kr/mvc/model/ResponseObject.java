package ddit.or.kr.mvc.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="response")
public class ResponseObject {
	
	@XmlElement(name="users")
	private List<UserVo> userList;

	public List<UserVo> getUserList() {
		return userList;
	}

	public void setUserList(List<UserVo> userList) {
		this.userList = userList;
	}

	@Override
	public String toString() {
		return "ResponseObject [userList=" + userList + "]";
	}
	
}
