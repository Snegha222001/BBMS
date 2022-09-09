package com.cts.model;

import javax.persistence.Column;
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
@ApiModel(description = "Model object that stores the blood request details.")
@Table(name="blood_request")
public class BloodRequest {
	@Id
	@Column(name="request_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int requestId;
	@ApiModelProperty(notes="Name of the hospital")
	private String hospitalName;
	@ApiModelProperty(notes="bloodgroup of the user")
	private String bloodgroup;
	@ApiModelProperty(notes="bloodQuantity")
	private String bloodQuantity;
	private long contactNumber;
	private String description;
	
	

}
