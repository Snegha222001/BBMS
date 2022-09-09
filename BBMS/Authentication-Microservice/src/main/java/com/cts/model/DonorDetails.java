package com.cts.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonorDetails {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String password;
	private String email;
	private String bloodgroup;
	private int age;
	private long mobilenumber;
	private String country;
	private String state;
	private String city;
	private String area;
	private double weight;
	private String gender;

}
