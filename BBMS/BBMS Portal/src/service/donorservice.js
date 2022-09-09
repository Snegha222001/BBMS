import axios from "axios";
import AuthService from "./authservice";
import authHeader from "./authheader";
const API_URL = "http://localhost:9000/donor/";

const currentUser = AuthService.getCurrentUser();

const viewProfile = () => {
  
  return axios.get(API_URL + currentUser.user.userId, { headers: authHeader() });
};
const updateProfile = (data) => {
  return axios.put(API_URL + "update/"+ currentUser.user.userId,data, { headers: authHeader() });
};
const viewRequest = () => {
  return axios.get(API_URL + "viewRequests", { headers: authHeader() });
};
const DonorService = {
  viewProfile,
  updateProfile,
  viewRequest
 
};
export default DonorService;