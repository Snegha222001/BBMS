package com.cts.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Model object that stores the donor details.")
public class DonorDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ApiModelProperty(notes="Name of the donor")
	private String name;
	@ApiModelProperty(notes="Password of the donor")
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
