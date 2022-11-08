package com.company.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "addresses")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "address_id")
	private Long addressId;
	private String state;
	private String city;
	private String locality;
	@Column(name = "address_line")
	private String addressLine;
	private String landmark;
	@Column(name = "pin_code")
	private String pinCode;
	private String phone;
	@Column(name = "alternate_phone")
	private String alternatePhone;
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	public Long getAddressId() {
		return addressId;
	}
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public String getAddressLine() {
		return addressLine;
	}
	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAlternatePhone() {
		return alternatePhone;
	}
	public void setAlternatePhone(String alternatePhone) {
		this.alternatePhone = alternatePhone;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(Long addressId, String state, String city, String locality, String addressLine, String landmark,
			String pinCode, String phone, String alternatePhone, Customer customer) {
		super();
		this.addressId = addressId;
		this.state = state;
		this.city = city;
		this.locality = locality;
		this.addressLine = addressLine;
		this.landmark = landmark;
		this.pinCode = pinCode;
		this.phone = phone;
		this.alternatePhone = alternatePhone;
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", state=" + state + ", city=" + city + ", locality=" + locality
				+ ", addressLine=" + addressLine + ", landmark=" + landmark + ", pinCode=" + pinCode + ", phone="
				+ phone + ", alternatePhone=" + alternatePhone + ", customer=" + customer + "]";
	}
	
	

}
