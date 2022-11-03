package com.bridgelabz.addressbookapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bridgelabz.addressbookapp.model.AddressBookModel;

public interface AddressBookRepository extends JpaRepository<AddressBookModel, Integer>{
	@Query(value = "select * from addressbook where email = :email",nativeQuery = true)
	AddressBookModel findByEmail(String email);

}
