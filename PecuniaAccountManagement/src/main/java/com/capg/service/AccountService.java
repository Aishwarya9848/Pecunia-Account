package com.capg.service;

import com.capg.entity.Customer;

public interface AccountService {

	Customer addAccount(Customer customer);

	Customer findByAccountId(long accountId);

	

	String deleteAccount(long accountId);
	
	void updateName(long accountId, String customerName);

	

	void updateContact(long accountId, String customerContact);
	void updateAddress(long accountId, String address);
}
