package com.boot.rest.controller;

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

import com.boot.rest.entity.Account;
import com.boot.rest.service.AccountService;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

	@Autowired
	AccountService service;
	
	@GetMapping("/{city}")
	public ResponseEntity<List<Account>> getAccountOnCity(@PathVariable String city){
		List<Account> accountsList = service.getAccountByCity(city);
		return new ResponseEntity<List<Account>>(accountsList,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Account>> getAccounts(){
		List<Account> accountsList = service.getAccounts();
		return new ResponseEntity<List<Account>>(accountsList, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Account> addAccount(@RequestBody Account account){
		Account accountData = service.addAccount(account);
		return new ResponseEntity<Account>(accountData,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteAccount(@PathVariable int id){
		List<Account> accountsList = service.deleteAccount(id);
		if(accountsList != null) {
			return new ResponseEntity<List<Account>>(accountsList, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("No record present with id: "+id, HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PutMapping
	public ResponseEntity<Account> updateAccount(@RequestBody Account account){
		Account accountData = service.updateAccount(account);
		return new ResponseEntity<Account>(accountData,HttpStatus.ACCEPTED);
	}
	
}
