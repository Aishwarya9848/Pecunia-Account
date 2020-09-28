package com.capg.service;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.dao.AccountDao;
import com.capg.entity.Account;
import com.capg.entity.Customer;



@Service
@Transactional
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountDao dao;
	
	//post the account detail in the database
	@Override
	public Customer addAccount(Customer customer) {
	 return dao.save(customer);
	 
	}
		//retrieves the detail of a specific account
		@Override
		public Customer findByAccountId(long accountId){
			return dao.findByAccountId(accountId);
		}

		//deletes a specified account 
		@Override
		public String deleteAccount(long accountId){


			dao.deletecustomer(accountId);
			dao.deleteAccount(accountId);
			return "account deleted";

		}
		
		@Override
		public void updateName(long accountId, String customerName) {
			dao.updateName(accountId, customerName);
			
		}	
		@Override
		public void updateContact(long accountId, String customerContact) {
			dao.updateContact(accountId, customerContact);
		}
		@Override
		public void updateAddress(long accountId, String Address) {
			dao.updateAddress(accountId, Address);
			
			
		
			
		}

}


