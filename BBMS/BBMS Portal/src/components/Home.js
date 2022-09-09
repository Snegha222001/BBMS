import React from "react";
import { Carousel } from "react-bootstrap";
import { Table } from "react-bootstrap";
import Navigationbar from './Navbar';
import Footerfunc from './Footer';

function Homepage(){
    return(
      <div>
<Navigationbar/>
      <div className="Homepage">
      <Carousel >
      <Carousel.Item interval={1000}>
        <img
          className="d-block w-100"
          src={require('../images/carousel-first-slide.jpg')}
          alt="First slide"
          height="500px"
          
          
        />
      
      </Carousel.Item>
      <Carousel.Item interval={1000}>
        <img
          className="d-block w-100 "
          src={require("../images/3.jpg")}
          alt="Second slide"
          height="500px"
         
        />
       
      </Carousel.Item>
      <Carousel.Item interval={1000}>
        <img
          className="d-block w-100 "
          src={require("../images/7.jpg")}
          alt="Third slide"
          height="500px"
          
        />
       
      </Carousel.Item>
    </Carousel>
    <div id="about">
    <div className="tableheader text-danger bg-dark">
     <h2 className="text-center p-3"> Learn About Donation</h2>
    </div>
    <div className="row">
    <div className="col-sm-6">
   <img className="w-100" src={require("../images/9.jpg")} alt="learnfact"/>
   
   <h4 className=" card-body text-center text-wrap">
     After donating blood, the body works to replenish the blood loss.
     This stimulates the production of new blood cells and in turn,
     helps in maintaining good health.
      </h4>
      
   </div>
    <div className="col-sm-6">
    <Table responsive bordered striped hover >
<tbody>
<tr>
<th colSpan="3" className="bg-danger text-center">Compatible Blood Type Donors</th>
</tr>
<tr>
<td><b>Blood Type</b></td>
<td><b>Donate Blood To</b></td>
<td><b>Receive Blood From</b></td>
</tr>
<tr>
<td><b>A+</b></td>
<td>A+ AB+</td>
<td>A+ A- O+ O-</td>
</tr>
<tr>
<td><b>O+</b></td>
<td>O+ A+ B+ AB+</td>
<td>O+ O-</td>
</tr>
<tr>
<td><b>B+</b></td>
<td>B+ AB+</td>
<td>B+ B- O+ O-</td>
</tr>
<tr>
<td><b>AB+</b></td>
<td>AB+</td>
<td>Everyone</td>
</tr>
<tr>
<td><b>A-</b></td>
<td>A+ A- AB+ AB-</td>
<td>A- O-</td>
</tr>
<tr>
<td><b>O-</b></td>
<td>Everyone</td>
<td>O-</td>
</tr>
<tr>
<td><b>B-</b></td>
<td>B+ B- AB+ AB-</td>
<td>B- O-</td>
</tr>
<tr>
<td><b>AB-</b></td>
<td>AB+ AB-</td>
<td>AB- A- B- O-</td>
</tr>
</tbody>
</Table>

  </div>
   </div>
   </div>
    </div>
    <Footerfunc/>
</div>
    );
};
export default Homepage;