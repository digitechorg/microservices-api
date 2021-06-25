package com.digitechorg.app.ws.ui.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserDetailsRequestModel {
	@NotNull(message = "First name can't be null")
	@Size(min = 2, message = "First name must have alteast 2 charachers")
	private String firstName;

	@NotNull(message = "Last  name can't be null")
	@Size(min = 2, message = "Last name must have alteast 2 charachers")
	private String lastName;

}
