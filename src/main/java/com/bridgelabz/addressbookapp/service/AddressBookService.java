package com.bridgelabz.addressbookapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookModel;

@Service
public class AddressBookService {
	
	List<AddressBookModel> DataList = new ArrayList<>();
	
	public List<AddressBookModel> getData() {
        return DataList;
    }

    public AddressBookModel getById(int Id) {
     return DataList.get(Id-1);
    }

    public AddressBookModel addContact(AddressBookDTO dto) {
        AddressBookModel model = new AddressBookModel(DataList.size()+1, dto);
        DataList.add(model);
        return model;
    }

    public AddressBookModel editContact(int Id, AddressBookDTO dto) {
        AddressBookModel model = this.getById(Id);
        model.setFullName(dto.getFullName());
        model.setAddress(dto.getAddress());
        model.setPhoneNumber(dto.getPhoneNumber());
        model.setCity(dto.getCity());
        model.setState(dto.getState());
        model.setZipCode(dto.getZipCode());
        model.setEmail(dto.getEmail());
        DataList.set(Id-1,model);
        return model;
    }

    public void deleteContact(int Id) {
    	DataList.remove(Id-1);
    }
}
