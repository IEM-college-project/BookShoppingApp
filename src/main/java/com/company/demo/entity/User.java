package com.company.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "my_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Long userId;

//	@Column(name = "phone_number")
//	@NotNull(message = "Phone number cannot be null")
//	@Pattern(regexp = "^\\d{10}$", message = "Phone number is not valid")
	private String phone;

//	@NotNull(message = "Password shouldn't be null")
//	@Pattern(regexp = "((?=.*[@!#$%])(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,30})", message = "Should be 8 to 30 characters and must contain 1 uppercase, lowercase, number and special character")
	private String password;

//	@NotBlank(message = "Role cannot be empty or null")
	@Column(name = "user_role")
	private String userRole;

}
