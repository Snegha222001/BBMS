
import './App.css';
import { Routes,Route} from 'react-router-dom';
import "bootstrap/dist/css/bootstrap.css";
import Login from "./components/Login";
import Homepage from './components/Home';
import DonorRegistration from "./components/Donor/DonorRegistration";
import HospitalPortal from "./components/Hospital/HospitalPortal";
import DonorPortal from './components/Donor/DonorPortal';
import UpdateDonorProfile from './components/Donor/UpdateDonorProfile';
import ViewDonorProfile from './components/Donor/ViewDonorProfile.js';
import Request from "./components/Hospital/Request";
import ViewBloodRequest from './components/Donor/ViewBloodRequests';
import SearchDonor from './components/Hospital/SearchDonor';

function App() {
  return (
    
      <Routes>
        <Route path="/" element={<Homepage/>}/>
        <Route path="/login" element={<Login/>} />
        <Route path="/donorRegistration" element={<DonorRegistration/>} />
        <Route path="/hospital" element={<HospitalPortal/>} />
        <Route path="/donor" element={<DonorPortal/>} />
        <Route path="/donor/updateProfile" element={<UpdateDonorProfile/>} />
        <Route path="/donor/viewProfile" element={<ViewDonorProfile/>} />
        <Route path="/donor/viewBloodRequest" element={<ViewBloodRequest/>} />
        <Route path="/hospital/request" element={<Request/>} />
        <Route path="/hospital/search" element={<SearchDonor/>} />
      </Routes>
     
    
  );
};

export default App;

