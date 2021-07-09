package homework4.model;

public class User {
	String username;
	String firstName;
	String password;

	public User(String username, String firstName, String password) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
