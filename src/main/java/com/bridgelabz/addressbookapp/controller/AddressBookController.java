package com.bridgelabz.addressbookapp.controller;

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

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
	
	@GetMapping(value = {"/get"})
    public ResponseEntity<ResponseDTO> getmsg() {
		AddressBookModel model = new AddressBookModel();
		ResponseDTO responseDTO = new ResponseDTO("Success Call!!!",model);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @GetMapping(value = {"/get/{Id}"})
    public ResponseEntity<ResponseDTO> GetContact(@PathVariable int Id) {
        AddressBookModel model = new AddressBookModel(Id,new AddressBookDTO("Mdafroz",
                "Gadag","8553304009", "Gadag","Karnataka",582101,"mdafroz.gm@gmail.com"));
        ResponseDTO responseDTO = new ResponseDTO("Success Call for Person Id!!!",model);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    
    @PostMapping(value = {"/add"})
    public ResponseEntity<ResponseDTO> AddContact(@RequestBody AddressBookDTO addressBookDTO) {
        AddressBookModel AddressBookModel = new AddressBookModel(2,addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Data ADDED Successfully!!!",AddressBookModel);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping(value = {"/update/{Id}"})
    public ResponseEntity<ResponseDTO> UpdateContact(@PathVariable int Id,
                                                           @RequestBody AddressBookDTO addressBookDTO) {
        AddressBookModel AddressBookModel = new AddressBookModel(Id, addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Data UPDATED Successfully!!!",AddressBookModel);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = {"/delete/{Id}"})
    public ResponseEntity<ResponseDTO> DeleteContact(@PathVariable int Id) {
        ResponseDTO responseDTO = new ResponseDTO("Data DELETED Successfully!!!",
                "ID number: "+Id + " DELETED!!!");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}