import React, { Component } from "react";
import Footerfunc from '../Footer';
import NavigationbarforDonor from "./NavbarforDonor";
import "../../css/Welcome.css"
export default class DonorPortal extends Component{
    render(){
    return(
        <div>
            <NavigationbarforDonor/>
            <div>
            <img className="w-100 " src={require("../../images/11.jpg")} alt="welcome"/>
            </div>
  
            <Footerfunc />
        </div>
)
}
}
