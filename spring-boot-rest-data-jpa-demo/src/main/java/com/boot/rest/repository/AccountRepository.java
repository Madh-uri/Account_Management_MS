package com.boot.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.rest.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer>{

	public List<Account> findByCity(String city);
}
