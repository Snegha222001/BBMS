import axios from "axios";
import authHeader from "./authheader";
const API_URL = "http://localhost:9002/hospital/";



const sendBloodRequest = (data) => {
  
  return axios.post(API_URL + "sendBloodRequest",data, { headers: authHeader() });
};
// const searchDonor = () => {
//   return axios.get(API_URL + "searchDonor/", { headers: authHeader() });
// };

const HospitalService = {
  //searchDonor,
  sendBloodRequest,
 
 
};
export default HospitalService;