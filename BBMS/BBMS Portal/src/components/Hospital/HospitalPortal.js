import React from "react";
import Footerfunc from '../Footer';
import NavigationbarforHospital from "./NavbarforHospital";

function HospitalPortal(){
    return(
        <div>
            <NavigationbarforHospital/>
            <div>
            <img className="w-100" src={require("../../images/14.jpg")} alt="welcome"/>
            </div>
            
  
<Footerfunc />
</div>
);
}
export default HospitalPortal;