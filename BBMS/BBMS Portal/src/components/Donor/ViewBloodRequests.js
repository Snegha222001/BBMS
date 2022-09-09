import NavigationbarforDonor from "../Donor/NavbarforDonor";
import Footerfunc from "../Footer";
import { Table } from "react-bootstrap";
import "../../css/viewRequest.css";
import DonorService from "../../service/donorservice";
import { useState, useEffect } from "react";

const ViewBloodRequest = () => {
  const [request, setRequest] = useState([]);
  useEffect(() => {
    DonorService.viewRequest().then(
      (response) => {
        setRequest(response.data);

      },
      (error) => {
        console.log("request page error", error.response);

      }
    );
  }, []);
  const listItems = request.map(
    (element) => {
      return (
        // <ul key={element.requestId} type="disc">
        //     <li key={element.hospitalName}>{element.hospitalName}</li>
        //     <li key={element.bloodgroup}>{element.bloodgroup}</li>
        //     <li key={element.bloodQuantity}>{element.bloodQuantity}</li>
        //     <li key={element.contactNumber}>{element.contactNumber}</li>
        //     <li key={element.description}>{element.description}</li>
        //     <hr></hr>
        // </ul>
        
          <div className="req-form">
            <div className="req-form-content">
              <h2 className="req-form-title ">Donate Now!!! {element.description}</h2>
              <Table borderless>

                <tbody>

                  <tr >
                    <td>Hospital Name</td>
                    <td>{element.hospitalName}</td>
                  </tr>


                  <tr>
                    <td>Blood Group</td>
                    <td>{element.bloodgroup}</td>

                  </tr>
                  <tr>
                    <td>Blood Quantity needed</td>
                    <td>{element.bloodQuantity}</td>

                  </tr>
                  <tr>
                    <td>Contact Number</td>
                    <td>{element.contactNumber}</td>
                  </tr>
                  <tr>
                    <td>Description</td>
                    <td>{element.description}</td>
                  </tr>




                </tbody>
              </Table>



            </div>
          </div>
        

      )
    }
  )
  return (
    <div>
      <NavigationbarforDonor />
      <div className="req-form-container">
      <div>{listItems}
      </div>
      </div>
      <Footerfunc />
    </div>
  );
}
export default ViewBloodRequest;