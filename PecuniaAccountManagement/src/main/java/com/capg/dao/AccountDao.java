package com.capg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capg.entity.Customer;

@Repository
public interface AccountDao extends JpaRepository<Customer,Integer> {
	
	@Query("select f from Customer f where account_Id=?1")
	Customer findByAccountId(long accountId);
	
	
	@Modifying
	@Query("update Customer SET customer_Name=?2 where account_Id=?1")
	void updateName(long accountId,String customerName);

	@Modifying
	@Query("update Customer SET contact_Number=?2 where account_Id=?1")
	void updateContact(long accountId,String customerName);

	@Modifying
	@Query("update Customer SET address=?2 where account_Id=?1")
	void updateAddress(long accountId,String customerName);
	
	@Modifying
	@Query("delete from Account e where account_Id=?1")
	void deleteAccount(long accountId);
	
	
	@Modifying
	@Query("delete from Customer e where account_Id=?1")
	void deletecustomer(long accountId);
    
}

