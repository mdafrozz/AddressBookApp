package com.bridgelabz.addressbookapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.exception.AddressBookException;
import com.bridgelabz.addressbookapp.model.AddressBookModel;
import com.bridgelabz.addressbookapp.repository.AddressBookRepository;

@Service
public class AddressBookService implements IAddressBookService {
	
	@Autowired
	AddressBookRepository repo;
	
	public String getData() {
        return "Welcome to AddressBook App..!!";
    }

	public AddressBookModel findById(int id) {
        return repo.findById(id).stream()
                .filter(data -> data.getId() == id)
                .findFirst()
                .orElseThrow(() -> new AddressBookException("Contact Not Found/ Incorrect ID"));
    }
	
	public List<AddressBookModel> getAll() {
        return repo.findAll();
    }
	
	public AddressBookModel addContact(AddressBookDTO dto) {
        AddressBookModel model = new AddressBookModel(dto);
        repo.save(model);
        return model;
    }

    public AddressBookModel editContact(int Id, AddressBookDTO dto) {
        AddressBookModel model = this.findById(Id);
        model.setFullName(dto.getFullName());
        model.setAddress(dto.getAddress());
        model.setPhoneNumber(dto.getPhoneNumber());
        model.setCity(dto.getCity());
        model.setState(dto.getState());
        model.setZipCode(dto.getZipCode());
        model.setEmail(dto.getEmail());
        repo.save(model);
        return model;
    }

    public String deleteContact(int Id) {
    	 AddressBookModel data = this.findById(Id);
         if(data.equals(data)) {
         	repo.deleteById(Id);
         	return "Contact ID : "+Id;}
         else
         	return "Incorrect ID";
    }
    
    public AddressBookModel getByEmail(String email) {
        return repo.findByEmail(email);
    }
}
