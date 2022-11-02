package com.bridgelabz.addressbookapp.service;

import java.util.List;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookModel;

public interface IAddressBookService {
	public String getData();
	public AddressBookModel findById(int id);
	public List<AddressBookModel> getAll();
	public AddressBookModel addContact(AddressBookDTO dto);
	public AddressBookModel editContact(int Id, AddressBookDTO dto);
	public String deleteContact(int Id);
}
