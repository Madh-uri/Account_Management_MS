package com.boot.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.rest.entity.Account;
import com.boot.rest.repository.AccountRepository;

import java.util.Optional;



@Service
public class AccountService {

	@Autowired
	AccountRepository repository;
	
	public List<Account> getAccounts(){
		return repository.findAll();
	}
	
	public Account addAccount(Account account) {
		repository.save(account);
		return account;
	}

	public List<Account> deleteAccount(int id) {
		List<Account> accountsList = null;
		Optional<Account>  optional = repository.findById(id);
		if(optional.isPresent()) {
			Account account = optional.get();
			repository.delete(account);
			accountsList = getAccounts();
		}
		return accountsList;
		
		
	}

	public Account updateAccount(Account account) {
		// TODO Auto-generated method stub
		Account accountData = null;
		Optional<Account>  optional = repository.findById(account.getAccountNumber());
		if(optional.isPresent()) {
			accountData = optional.get();
			accountData.setBalance(account.getBalance());
			accountData.setCity(account.getCity());
			accountData.setCustomerName(account.getCustomerName());
			accountData.setStatus(account.getStatus());
			accountData.setUserType(account.getUserType());
			repository.save(accountData);
		}
		
		return accountData;
	}
	
	public List<Account> getAccountByCity(String city){
		return repository.findByCity(city);
	}
}
