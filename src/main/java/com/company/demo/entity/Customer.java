package com.company.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")

public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id")
	private Long customerId;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "gender")
	private String gender;
	@Column(name = "contact")
	private String phone;
	@Column(name = "email")
	private String email;
	private String password;
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
	private List<Address> addresses;
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(Long customerId, String firstName, String lastName, String gender, String phone, String email,
			String password, List<Address> addresses) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.addresses = addresses;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", gender=" + gender + ", phone=" + phone + ", email=" + email + ", password=" + password
				+ ", addresses=" + addresses + "]";
	}
   
	
	
}
