package com.company.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< HEAD
=======
import javax.persistence.JoinColumn;
>>>>>>> bugfix
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "customer")
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

	@Column(name = "phone")
	private String phone;

	@Column(name = "email")
	private String email;

<<<<<<< HEAD
	@Column(name = "password")
	private String password;
=======
	@JsonBackReference
	@OneToOne
	@JoinColumn(name = "username")
	private User user;
>>>>>>> bugfix

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
	private List<Address> addresses = new ArrayList<>();

<<<<<<< HEAD
	public Customer(String firstName, String lastName, String gender, String phone, String email, String password) {
=======
	public Customer(String firstName, String lastName, String gender, String phone, String email, User user) {
>>>>>>> bugfix
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
<<<<<<< HEAD
		this.password = password;
=======
		this.user = user;
>>>>>>> bugfix
	}

}
