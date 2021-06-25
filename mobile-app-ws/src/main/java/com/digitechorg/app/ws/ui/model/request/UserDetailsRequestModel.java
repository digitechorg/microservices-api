package com.digitechorg.app.ws.ui.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDetailsRequestModel {
	@NotNull(message = "First name can't be null")
	@Size(min = 2, message = "First name must have alteast 2 charachers" )
	private String firstName;
	
	@NotNull(message = "Last  name can't be null")
	@Size(min = 2, message = "Last name must have alteast 2 charachers" )
	private String lastName;
	
	@NotNull(message = "Email name can't be null")
	@Email
	private String email;
	
	@NotNull(message = "Password name can't be null")
	@Size(min = 8,max = 16,message = "Password must be equal or greater than 8 characters and less than 16 characters")
	private String password;
}
