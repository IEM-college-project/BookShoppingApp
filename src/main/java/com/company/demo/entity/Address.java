package com.company.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "address_id")
	private Long addressId;

	@Column(name = "state")
	private String state;

	@Column(name = "city")
	private String city;

	@Column(name = "address_line")
	private String addressLine;

	@Column(name = "pin_code")
	private String pinCode;

	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "addresses")
	private List<Customer> customers = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "address")
	private List<Order> orders = new ArrayList<>();

	public Address(String state, String city, String addressLine, String pinCode) {
		super();
		this.state = state;
		this.city = city;
		this.addressLine = addressLine;
		this.pinCode = pinCode;
	}

}
