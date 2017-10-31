package placeHolder;

public class DbProperties {
	private	String	url;
	private	String	driver;
	private	String	username;
	private	String	password;
	
	public DbProperties() {
		
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "DbProperties [url=" + url + ", driver=" + driver + ", username=" + username
				+ ", password=" + password + "]";
	}	
}
