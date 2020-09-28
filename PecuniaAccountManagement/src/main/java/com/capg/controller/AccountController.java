package com.capg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.entity.Customer;
import com.capg.exceptions.IdAlreadyExistException;
import com.capg.exceptions.IdNotFoundException;
import com.capg.service.AccountService;

@RestController
@RequestMapping("/bank")
@CrossOrigin("http://localhost:4200")
public class AccountController {

	@Autowired
	private AccountService service;
	
	
	
	@PostMapping("/create")
	public ResponseEntity<Customer> addAccount(@RequestBody Customer customer ){
		
		Customer cust= service.addAccount(customer);
		ResponseEntity<Customer> responseEntity = new ResponseEntity<Customer>(cust,HttpStatus.OK);
		return responseEntity;
		
		
	}
	//creating a get mapping that retrieves the detail of a specific account
		@GetMapping("/find/{accountId}")
		public Customer findByAccountId(@PathVariable long accountId)  {
			return service.findByAccountId(accountId);
		}
		
		@PutMapping("/updateName/{accountId}/{customerName}")
		public void updateName(@PathVariable long accountId,@PathVariable String customerName) {
			service.updateName(accountId,customerName);
		}
		
		@PutMapping("/updateContact/{accountId}/{customerContact}")
		 public void updateContact(@PathVariable long accountId ,@PathVariable String customerContact) {
			service.updateContact(accountId,customerContact);
		}
		@PutMapping("/updateAddress/{accountId}/{Address}")
		public void updateAddress(@PathVariable long accountId ,@PathVariable String Address) {
	          service.updateAddress(accountId,Address);
	}
	
	@DeleteMapping("/delete/{accountId}")
	public ResponseEntity<String> deleteAccount(@PathVariable("accountId") long accountId) throws IdNotFoundException 
	{
		Customer customer=service.findByAccountId(accountId);
		//if the accountId is equal to null it throws id not found exception
		if(customer==null) {
			throw new IdNotFoundException("AccountId does not exist");
		}
		else {
			ResponseEntity<String> rs =  new ResponseEntity<String>(service.deleteAccount(accountId),HttpStatus.OK);
			return rs;
		}
	}
	
	
}