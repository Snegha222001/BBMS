import React from "react";
import DonorService from "../../service/donorservice";
import { useState,useEffect  } from "react";
import NavigationbarforDonor from "../Donor/NavbarforDonor";
import Footerfunc from "../Footer";
import { Table } from "react-bootstrap";
import "../../css/ViewProfile.css";
const ViewDonorProfile = () =>{
    
    const [donor, setDonor] = useState([]);
    useEffect(() => {
        DonorService.viewProfile().then(
          (response) => {
            setDonor(response.data);
          },
          (error) => {
            console.log("Private page error", error.response);
            
          }
        );
      }, []);
    return (
        <div>
            <NavigationbarforDonor />
            <div className="view-profile-container">
            <div className="view-profile">
                <div className="view-profile-content">
                <h2 className="view-profile-title"><center>Profile</center></h2>
                <Table borderless >
                <tbody>
                    
                        <tr >
                            <td>Name</td>
                            <td>{donor.name}</td>
                            </tr>
                            <tr >
                            <td>Email</td>
                            <td>{donor.email}</td>
                            </tr>
                    
                        <tr>
                            <td>Blood Group</td>
                            <td>{donor.bloodgroup}</td>
                            
                        </tr>
                        <tr>
                            <td>Age</td>
                            <td>{donor.age}</td>
                            
                        </tr>
                        <tr>
                            <td>Mobile Number</td>
                            <td>{donor.mobilenumber}</td>
                        </tr>
                        <tr>
                            <td>Country</td>
                            <td>{donor.country}</td>
                        </tr>
                        <tr>
                            <td>State</td>
                            <td>{donor.state}</td>
                        </tr>
                        <tr>
                            <td>City</td>
                            <td>{donor.city}</td>
                        </tr>
                        <tr>
                            <td>Area</td>
                            <td>{donor.area}</td>
                        </tr>
                        <tr>
                            <td>Weight</td>
                            <td>{donor.weight}</td>
                        </tr>
                        <tr>
                            <td>Gender</td>
                            <td>{donor.gender}</td>
                        </tr>
                        </tbody>
                        </Table>



                    
                </div>
            </div>
            </div>
            <Footerfunc />
       
        </div>
    );
}
export default ViewDonorProfile;