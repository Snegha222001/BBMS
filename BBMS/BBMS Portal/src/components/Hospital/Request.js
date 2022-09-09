
import React , {Component}from "react";


import "../../css/Request.css";

import NavigationbarforHospital from "./NavbarforHospital";
import Footerfunc from "../Footer";
import HospitalService from "../../service/hospitalservice";

 

export default class Request extends Component{
    handleSubmit = e => {
    e.preventDefault();
    const data = {
      hospitalName:this.hospitalName,
      bloodgroup:this.bloodgroup,
      bloodQuantity:this.bloodQuantity,
      contactNumber:this.contactNumber,
      description:this.description
    };
    HospitalService.sendBloodRequest(data).then(
      (response) => {
        console.log(response.data);
        window.alert("Blood Request Sent!!!")
      },
      (error) => {
        console.log("blood request page error", error.response);
        
      }
    )
  
  };
  render(){
  return (
   
   <div>
    <NavigationbarforHospital />
    
    <div className="request-form-container">
      
    <form className="request-form" onSubmit={this.handleSubmit}>
      <div className="request-form-content">

        <h3 className="request-form-title" >Blood Request</h3>

        <div className="form-group mt-3">
          <label>Hospital Name</label>
          <input
            type="text"
            className="form-control mt-1"
            placeholder="Enter hospital_name"
            onChange={e =>this.hospitalName = e.target.value}
          />
        </div>
        <div className="form-group mt-3">
          <label>Blood Group</label>
          <input
            type="text"
            className="form-control mt-1"
            placeholder="Enter required blood group"
            onChange={e =>this.bloodgroup = e.target.value}
          />
        </div>

        <div className="form-group mt-3">
          <label>Blood Quantity</label>
          <input
            type="text"
            className="form-control mt-1"
            placeholder="Enter required blood quantity"
            onChange={e =>this.bloodQuantity = e.target.value}
          />
        </div>
 

        <div className="form-group mt-3">
          <label>Contact Number</label>
          <input
            type="number"
            className="form-control mt-1"
            placeholder="Enter mobile number"
            onChange={e =>this.contactNumber = e.target.value}
          />
        </div>

        

        <div className="form-group mt-3">
          <label>Description(Other Informations)</label>
          <input
            type="text"
            className="form-control mt-1"
            placeholder="Enter name who needs blood"
            onChange={e =>this.description = e.target.value}
          />
        </div>

     

        <div className="d-grid gap-2 mt-3">
          <button type="submit" className="btn btn-danger">
            Send Blood Request
          </button>
        </div>
      </div>
    </form>
   
 </div>
  
 <Footerfunc/>
    </div>
    
  );
}
}
