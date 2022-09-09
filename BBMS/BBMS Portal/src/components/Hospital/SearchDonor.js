import axios from "axios";
import {useEffect,useState} from "react";
import {Table} from "react-bootstrap";
import NavigationbarforHospital from "./NavbarforHospital";

import authHeader from "../../service/authheader";
function SearchRecord() {
 
    const[search,setSearch]=useState([]);
    const[record,setRecord]=useState("");
 

    const loadRecords = async () => {
      axios.get("http://localhost:9002/hospital/searchDonor?bloodgroup",{ headers: authHeader() })
        .then(response => {
          setSearch(response.data);
        });
       
    }
    useEffect(() => {
        loadRecords();
    }, []);
 

    const searchRecords = () =>
    {
        const last=record.charAt(record.length-1);
        if(last === '+'){
           const searchbg=record.slice(0,-1)+'%2B';
           axios.get(`http://localhost:9002/hospital/searchDonor?bloodgroup=${searchbg}`, { headers: authHeader() })
        .then(response => {
          setSearch(response.data);
        });
        }
        else{
        axios.get(`http://localhost:9002/hospital/searchDonor?bloodgroup=${record}`, { headers: authHeader() })
        .then(response => {
          setSearch(response.data);
        });
      }
    }
   
 
  return (
    <div>
        <NavigationbarforHospital/>
   
  <div className="container">
    
  <h4 className="text-center text-dark mt-5"><b>Search Donor by BloodGroup</b></h4>
    <div className="input-group mb-4 mt-3">
     <div className="form-outline">
        <input type="text" id="form1" onChange={(e)=>setRecord(e.target.value)} className="form-control" placeholder="Search here" style={{backgroundColor:"#ececec"}}/>
   </div>
   <button type="button" onClick={searchRecords} className="btn btn-danger">
       Search Blood Donor
   </button>
  </div>                   
  <Table striped bordered hover variant="dark">
    <thead>
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Bloodgroup</th>
            <th>Age</th>
            <th>Mobile Number</th>
            <th>Country</th>
            <th>State</th>
            <th>City</th>
            <th>Area</th>
            <th>Weight</th>
            <th>Gender</th>
        </tr>
    </thead>
    <tbody>
      {search.map((data)=>
      <tr>
      <td>{data.name}</td>
      <td>{data.email}</td>
      <td>{data.bloodgroup}</td>
      <td>{data.age}</td>
      <td>{data.mobilenumber}</td>
      <td>{data.country}</td>
      <td>{data.state}</td>
      <td>{data.city}</td>
      <td>{data.area}</td>
      <td>{data.weight}</td>
      <td>{data.gender}</td>
  </tr>
      )}  
 
    </tbody>
    </Table>
</div>

</div>
  );
}
 
export default SearchRecord;