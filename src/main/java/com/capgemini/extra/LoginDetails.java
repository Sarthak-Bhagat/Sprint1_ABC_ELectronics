package com.capgemini.extra;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class LoginDetails {
	private long userId;
	@ToString.Exclude
	private String password;
	private boolean admin;
	private boolean engineer;
	private boolean client;

	public LoginDetails(long userId, String password) {
		this.userId = userId;
		this.password = password;
		this.admin = false;
		this.engineer = false;
		this.client = false;
	}
}
