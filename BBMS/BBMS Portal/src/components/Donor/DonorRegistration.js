import "../../css/Donor.css";
import React, { Component } from "react";
import axios from "axios";
import Navigationbar from '../Navbar';
import Footerfunc from '../Footer';
export default class DonorRegistration extends Component {
  handleSubmit = e => {
    e.preventDefault();
    const data = {
      name:this.name,
      password:this.password,
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

   axios.post('http://localhost:9000/donor/register',data).then(
    res =>{
      console.log(res)
      window.alert("Registered Successfully");
    }
   ).catch(
    err => {
      console.log(err);
    }
   )

  };

  render() {
    return (
      <div>
        <Navigationbar />
        <div className="donor-form-container">
          <form className="donor-form" onSubmit={this.handleSubmit}>
            <div className="donor-form-content">

              <h3 className="donor-form-title" >Register as Donor</h3>
              <div className="form-group mt-3">
                <label>User Name</label>
                <input
                  type="text"
                  className="form-control mt-1"
                  placeholder="Enter user name"
                  onChange={e =>this.name = e.target.value}
                />
              </div>
              
              <div className="form-group mt-3">
                <label>Password</label>
                <input
                  type="password"
                  className="form-control mt-1"
                  placeholder="Enter password"
                  onChange={e =>this.password = e.target.value}
                />
              </div>

              <div className="form-group mt-3">
                <label>Email ID</label>
                <input
                  type="email"
                  className="form-control mt-1"
                  placeholder="Enter email"
                  onChange={e =>this.email = e.target.value}
                />
              </div>

              

              <div className="form-group mt-3">
                <label>Donor Blood Group</label>
                <input
                  type="text"
                  className="form-control mt-1"
                  placeholder="Enter blood group"
                  onChange={e =>this.bloodgroup = e.target.value}
                />
              </div>

              <div className="form-group mt-3">
                <label>Age</label>
                <input
                  type="number"
                  className="form-control mt-1"
                  placeholder="Enter Age"
                  onChange={e =>this.age = e.target.value}
                />
              </div>



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

              <div className="form-group mt-3">
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
                  type="text"
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
                  placeholder="Enter address"
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
                  Register
                </button>
              </div>
            </div>
          </form>
        </div>
        <Footerfunc />
      </div>
    )
  }
}
