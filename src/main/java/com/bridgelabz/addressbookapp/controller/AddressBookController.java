package com.bridgelabz.addressbookapp.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
    
	@RequestMapping(value = {"", "/", "/get"})
    public String welcomeUser() {
        return "Welcome to Address Book App..!!";
    }

    @GetMapping("/get/{id}")
    public String welcomeSpecificUser(@PathVariable int id) {
        return "Welcome, User " + id;
    }

    @PostMapping("/add")
    public String createContact(@RequestParam String name) {
        return "Added " +name+ " to addressbook";
    }

    @PutMapping("/update/{id}")
    public String updateContact(@PathVariable int id, @RequestBody String name  ) {
        return "Updated id: " + id + " with "+name+" in addressbook";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteContact(@PathVariable String id) {
        return "Deleted contact " + id;
    }
}