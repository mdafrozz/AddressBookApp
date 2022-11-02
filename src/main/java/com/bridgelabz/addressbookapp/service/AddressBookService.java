package com.bridgelabz.addressbookapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookModel;

@Service
public class AddressBookService {
	
	public List<AddressBookModel> getData() {
        List<AddressBookModel> AddressBookModelList = new ArrayList<>();
        AddressBookModelList.add(new AddressBookModel(1, new AddressBookDTO("Mdafroz",
                "Gadag","8553304009", "Gadag","Karnataka",582101,"mdafroz.gm@gmail.com")));
        return AddressBookModelList;
    }

    public AddressBookModel getById(int Id) {
        AddressBookModel AddressBookModel = new AddressBookModel(Id, new AddressBookDTO("Mdafroz",
                "Gadag","8553304009", "Gadag","Karnataka",582101,"mdafroz.gm@gmail.com"));
        return AddressBookModel;
    }

    public AddressBookModel addContact(AddressBookDTO addressBookDTO) {
        AddressBookModel model = new AddressBookModel(1, addressBookDTO);
        return model;
    }

    public AddressBookModel editContact(int Id, AddressBookDTO addressBookDTO) {
        AddressBookModel model = new AddressBookModel(Id, addressBookDTO);
        return model;
    }

    public void deleteContact(int personId) {

    }
}
