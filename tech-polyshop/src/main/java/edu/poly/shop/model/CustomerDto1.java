package edu.poly.shop.model;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto1 {

	@NotEmpty
	@Length(min  = 3)
	private String name;
	@NotEmpty
	@Email
	private String email;
	@NotEmpty
	@Length(min  = 4)
	private String password;
	@NotEmpty
	@Length(min = 9 )
	@Length(max = 12)
	
	private String phone;
	
	private Date registeredDate;
	@NotEmpty
	private String status;
	
     private Boolean isEdit = false;
}
