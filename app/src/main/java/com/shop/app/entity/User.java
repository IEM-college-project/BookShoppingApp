package com.shop.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String userId;

	@NotNull(message = "First Name cannot be empty")
	@Column(name = "First-Name", length = 20)
	private String userFname;

	@Column(name = "Middle-Name", length = 20)
	private String userMname;

	@NotNull(message = "Last Name cannot be empty")
	@Column(name = "Last-Name", length = 20)
	private String userLname;

	@NotNull(message = "Phone Number needed.")
	@Column(name = "Phone-Number", length = 15)
	@Pattern(regexp = "^\\d{10}$", message = "Phone number is not valid")
	private String userPhoneNo;

	@NotNull(message = "Email Needed")
	@Column(name = "Email", length = 50)
	private String userEmail;

	@NotNull(message = "Primary Address Needed")
	@Column(name = "Address1", length = 50)
	private String userAddress1;

	@NotNull(message = "Secondary Address Needed")
	@Column(name = "Address2", length = 50)
	private String userAddress2;

	@NotNull(message = "City Needed")
	@Column(name = "City", length = 50)
	private String usercity;

	@NotNull(message = "State Needed")
	@Column(name = "State", length = 50)
	private String userState;

	@NotNull(message = "Country Needed")
	@Column(name = "Country", length = 50)
	private String userCountry;

	@Column(name = "user_role")
	@NotBlank(message = "Role cannot be empty or null")
	private String userRole;

	@NotNull(message = "Password shouldn't be null")
	@Pattern(regexp = "((?=.*[@!#$%])(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,30})", message = "Should be 8 to 30 characters and must contain 1 uppercase, lowercase, number and special character")
	private String userPassword;

}
