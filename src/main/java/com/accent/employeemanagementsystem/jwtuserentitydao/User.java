package com.accent.employeemanagementsystem.jwtuserentitydao;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*@Data

@AllArgsConstructor

@NoArgsConstructor
*/
@Entity
@Table(name = "usertb")
public class User {
	@Id
	private int id;
	private String username;
	private String password;
	private boolean enabled;
	private String role;
	private String email;

	public User() {
	}

	public User(int id, String username, String password, boolean enabled, String role, String email) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.role = role;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
