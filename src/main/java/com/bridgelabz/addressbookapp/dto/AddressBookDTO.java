package com.bridgelabz.addressbookapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressBookDTO {

	private String fullName;
	private String address;
	private String phoneNumber;
	private String city;
	private String state;
	private int zipCode;
	private String email;
}
