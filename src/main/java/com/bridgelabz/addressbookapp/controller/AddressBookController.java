package com.bridgelabz.addressbookapp.controller;

import java.util.List;

import javax.validation.Valid;

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
import com.bridgelabz.addressbookapp.service.IAddressBookService;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

	@Autowired
	IAddressBookService iservice;
    
	@GetMapping(value = {"/get"})
    public ResponseEntity<ResponseDTO> getmsg() {
		String data = iservice.getData();
		ResponseDTO responseDTO = new ResponseDTO("GET Call Success..!!!",data);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
	
	@GetMapping(value = {"/getbyid/{Id}"}) 
	public ResponseEntity<ResponseDTO> getById(@PathVariable int Id) { 
	  AddressBookModel data = iservice.findById(Id); 
	  ResponseDTO responseDTO = new ResponseDTO("GET Call for ID Successfull!!",data); 
	  return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK); }
	 
    
    @GetMapping(value = {"/getbyemail/{email}"})
    public ResponseEntity<ResponseDTO> getByEmail(@PathVariable String email) {
       AddressBookModel DataList = iservice.getByEmail(email);
       ResponseDTO responseDTO = new ResponseDTO("Success call for email..!!", DataList);
       return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    
    @GetMapping("/getall")
    public List<AddressBookModel> showAll() {
        List<AddressBookModel> response = iservice.getAll();
        return response;
    }
    
    @PostMapping(value = {"/add"})
    public ResponseEntity<ResponseDTO> AddContact(@Valid @RequestBody AddressBookDTO addressBookDTO) {
        AddressBookModel data = iservice.addContact(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Contact Saved Successfully!!!",data);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PutMapping(value = {"/edit/{Id}"})
    public ResponseEntity<ResponseDTO> EditContact(@Valid @RequestBody AddressBookDTO addressBookDTO,
    		@PathVariable int Id){
    	AddressBookModel data = iservice.editContact(Id,addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Contact Updated Successfully!!!",data);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = {"/delete/{Id}"})
    public ResponseEntity<ResponseDTO> DeleteContact(@PathVariable int Id) {
    	 iservice.deleteContact(Id);
        ResponseDTO responseDTO = new ResponseDTO("Contact Deleted Successfully!!!",
                "ContactID: "+Id + " DELETED!!!");
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

}