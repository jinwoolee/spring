package placeHolder;

public class DbProperties {
	private	String	url;
	private	String	driver;
	private	String	username;
	private	String	password;
	private String 	admin;
	private String 	town;
	
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
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}

	@Override
	public String toString() {
		return "DbProperties [url=" + url + ", driver=" + driver + ", username=" + username + ", password=" + password
				+ ", admin=" + admin + ", town=" + town + "]";
	}	
}
