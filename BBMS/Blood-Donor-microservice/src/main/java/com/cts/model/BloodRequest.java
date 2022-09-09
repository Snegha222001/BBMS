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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ApiModel(description = "Model object that stores the blood request.")
@Table(name="blood_request")
public class BloodRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int requestId;
	@ApiModelProperty(notes="Name of the Hospital requesting for blood")
	private String hospitalName;
	private String bloodgroup;
	private String bloodQuantity;
	private long contactNumber;
	private String description;
	
	

}
