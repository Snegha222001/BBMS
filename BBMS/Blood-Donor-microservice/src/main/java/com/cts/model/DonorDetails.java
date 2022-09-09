package com.cts.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Model object that stores the donor details.")
@Table(name="donor_details")
public class DonorDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ApiModelProperty(notes="Name of the Donor")
	private String name;
	private String password;
	@ApiModelProperty(notes="Email of the Donor")
	private String email;
	@ApiModelProperty(notes="Bloodgroup of the Donor")
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
