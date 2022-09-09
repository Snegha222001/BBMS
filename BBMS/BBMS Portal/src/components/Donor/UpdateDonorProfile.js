
import React ,{Component} from "react";
import "../../css/UpdateProfile.css";
import Footerfunc from "../Footer";
import NavigationbarforDonor from "./NavbarforDonor";
import DonorService from "../../service/donorservice";

export default class UpdateDonorProfile extends Component{
    
  handleUpdate = (e) => {
    e.preventDefault();
    const data = {
     
      email:this.email,
      bloodgroup:this.bloodgroup,
      age:this.age,
      mobilenumber:this.mobilenumber,
      country:this.country,
      state:this.state,
      city:this.city,
      area:this.area,
      weight:this.weight,
      gender:this.gender
    };

        DonorService.updateProfile(data).then(
          (response) => {
            console.log(response.data);
            window.alert("Updated Successfully!!");
          },
          (error) => {
            console.log("Update page error", error.response);
            
          }
        )
        }; 
        render() {  
  return (
    <div>
   <NavigationbarforDonor/>
    
    <div className="update-form-container">
      <form className="update-form" onSubmit={this.handleUpdate}>
        <div className="update-form-content">
          <h3 className="update-form-title">Donor Profile Update</h3>
          <div className="update-group mt-3">

          <label>Email</label>
            <input
              type="text"
              className="form-control mt-1"
              placeholder="Enter Email Id"
              onChange={e =>this.email = e.target.value}
            />

          <label>Blood Group</label>
            <input
              type="text"
              className="form-control mt-1"
              placeholder="Enter blood_group"
              onChange={e =>this.bloodgroup = e.target.value}
            />

           <label>Age</label>
            <input
              type="number"
              className="form-control mt-1"
              placeholder="Enter age"
              onChange={e =>this.age = e.target.value}
            />

           <div className="form-group mt-3">
            <label>Mobile Number</label>
             <input
              type="number"
              className="form-control mt-1"
              placeholder="Enter mobile number"
              onChange={e =>this.mobilenumber = e.target.value}
            />
          </div>

          <div className="form-group mt-3">
            <label>Country</label>
             <input
              type="text"
              className="form-control mt-1"
              placeholder="Enter country"
              onChange={e =>this.country = e.target.value}
            />
          </div>


            <label>State</label>
            <input
              type="text"
              className="form-control mt-1"
              placeholder="Enter state"
              // eslint-disable-next-line react/no-direct-mutation-state
              onChange={e =>this.state = e.target.value}
            />
          </div>
          <div className="form-group mt-3">
            <label>City</label>
            <input
              type="city"
              className="form-control mt-1"
              placeholder="Enter city"
              onChange={e =>this.city = e.target.value}
            />
          </div>

          <div className="form-group mt-3">
            <label>Area</label>
             <input
              type="text"
              className="form-control mt-1"
              placeholder="Enter area"
              onChange={e =>this.area = e.target.value}
            />
          </div>

          <div className="form-group mt-3">
            <label>Weight</label>
             <input
              type="number"
              className="form-control mt-1"
              placeholder="Enter weight"
              onChange={e =>this.weight = e.target.value}
            />
          </div>

          <div className="form-group mt-3">
            <label>Gender</label>
             <input
              type="text"
              className="form-control mt-1"
              placeholder="Enter gender"
              onChange={e =>this.gender = e.target.value}
            />
          </div>

          


          <div className="d-grid gap-2 mt-3">
            <button type="submit" className="btn btn-danger">
              Update
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