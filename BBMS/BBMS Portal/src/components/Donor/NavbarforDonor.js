import React from "react";
import { useNavigate } from 'react-router-dom';
import { Navbar,Nav,Container} from "react-bootstrap";
import AuthService from "../../service/authservice";

const NavigationbarforDonor = () =>{
  let navigate = useNavigate();
  const handleLogout = (e) => {
    e.preventDefault();

    AuthService.logout();
    navigate("/");


  };

    return(
        <Navbar  expand="lg" bg="dark" variant="dark" >
          <Container>
            <Navbar.Brand href="/">BBMS</Navbar.Brand>
              <Navbar.Toggle aria-controls="responsive-navbar-nav" />
              <Navbar.Collapse id="responsive-navbar-nav">
                <Nav >
                <Nav.Link href="/donor/viewProfile">View Profile</Nav.Link>
                  <Nav.Link href="/donor/updateProfile">Update Profile</Nav.Link>
                  <Nav.Link href="/donor/viewBloodRequest">View Blood Requests</Nav.Link>
                 
                  
                  </Nav>
                <Nav className="ms-auto">
                <Nav.Link href="/" onClick={handleLogout} >Sign out</Nav.Link>
                </Nav>  
             
              </Navbar.Collapse>
          </Container>
        </Navbar>
    );
};
export default NavigationbarforDonor;
