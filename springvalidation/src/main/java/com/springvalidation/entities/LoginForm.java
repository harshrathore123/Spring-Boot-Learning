package com.springvalidation.entities;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginForm {
	
	@NotBlank(message="User name should not be null!!")
	@Size(min=3,max=12,message="character should be between in range 3 - 12 !!")
	private String userName;
	
	@Email(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message="Invalid Email!")
	private String email;
	
	@AssertTrue(message="Must agree terms and conditions!")
	private boolean agreed;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

	public boolean isAgreed() {
		return agreed;
	}

	public void setAgreed(boolean agreed) {
		this.agreed = agreed;
	}

	@Override
	public String toString() {
		return "LoginForm [userName=" + userName + ", email=" + email + ", agreed=" + agreed + "]";
	}

	

}
