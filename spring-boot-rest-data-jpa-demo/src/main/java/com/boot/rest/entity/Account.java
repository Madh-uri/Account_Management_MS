package com.boot.rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "accounts_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "acc_no")
	private int accountNumber;
	@Column(name = "customer_name")
	private String customerName;
	private double balance;
	@Column(name = "account_status")
	private String status;
	@Column(name = "user_type")
	private String userType;
	private String city;

}
