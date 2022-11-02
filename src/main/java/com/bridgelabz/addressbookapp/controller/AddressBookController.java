package com.bridgelabz.addressbookapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.model.AddressBookModel;
import com.bridgelabz.addressbookapp.service.AddressBookService;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
	
    @Autowired
    AddressBookService service;
    
	@GetMapping(value = {"/get"})
    public ResponseEntity<ResponseDTO> getmsg() {
		List<AddressBookModel> data = service.getData();
		ResponseDTO responseDTO = new ResponseDTO("Success Call!!!",data);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
	
    @GetMapping(value = {"/get/{Id}"})
    public ResponseEntity<ResponseDTO> GetContact(@PathVariable int Id) {
    	AddressBookModel data = service.getById(Id);
        ResponseDTO responseDTO = new ResponseDTO("Success Call for Person Id!!!",data);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    
    @PostMapping(value = {"/add"})
    public ResponseEntity<ResponseDTO> AddContact(@RequestBody AddressBookDTO addressBookDTO) {
        AddressBookModel data = service.addContact(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Data ADDED Successfully!!!",data);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping(value = {"/edit/{Id}"})
    public ResponseEntity<ResponseDTO> EditContact(@PathVariable int Id,
                                                           @RequestBody AddressBookDTO addressBookDTO) {
    	AddressBookModel data = service.editContact(Id,addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Data UPDATED Successfully!!!",data);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = {"/delete/{Id}"})
    public ResponseEntity<ResponseDTO> DeleteContact(@PathVariable int Id) {
    	 service.deleteContact(Id);
        ResponseDTO responseDTO = new ResponseDTO("Data DELETED Successfully!!!",
                "ID number: "+Id + " DELETED!!!");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}