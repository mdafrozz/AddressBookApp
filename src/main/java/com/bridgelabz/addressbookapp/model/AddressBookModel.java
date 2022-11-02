package com.bridgelabz.addressbookapp.model;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressBookModel {
	
	private int id;
	private String fullName;
	private String address;
	private String phoneNumber;
	private String city;
	private String state;
	private int zipCode;
	private String email;
	
	public AddressBookModel(int id,AddressBookDTO dto ) {
		
		this.id = id;
		this.fullName = dto.getFullName();
		this.address = dto.getAddress();
		this.phoneNumber = dto.getPhoneNumber();
		this.city = dto.getCity();
		this.state = dto.getState();
		this.zipCode = dto.getZipCode();
		this.email = dto.getEmail();
	}
	
	
}
