import React from "react";
import { Navbar,Nav,NavDropdown,Container} from "react-bootstrap";
function Navigationbar(){
    return(
      
        <Navbar  expand="lg" bg="dark" variant="dark" >
          <Container>
            <Navbar.Brand href="/">BBMS</Navbar.Brand>
              <Navbar.Toggle aria-controls="responsive-navbar-nav" />
              <Navbar.Collapse id="responsive-navbar-nav">
                <Nav className="ms-auto">
                  <Nav.Link href="/">Home</Nav.Link>
                  {/* <Nav.Link href="#about">Learn about donation</Nav.Link> */}
                  <Nav.Link href="#contact">Contact</Nav.Link>
                </Nav>
                <Nav>
                    
                    <NavDropdown title="Login / Register" id="collasible-nav-dropdown">
                    <NavDropdown.Item href="#action"></NavDropdown.Item>
                    {/* <NavDropdown.Item href="/hospitalRegistration">Register as Hospital</NavDropdown.Item> */}
                    <NavDropdown.Item href="/donorRegistration">Register as Donor</NavDropdown.Item>
                    <NavDropdown.Divider />
                    <NavDropdown.Item href="/Login">Login </NavDropdown.Item>
                    {/* <NavDropdown.Item href="/hospitalLogin">Hospital Login</NavDropdown.Item> */}
                    </NavDropdown>
                </Nav>
              </Navbar.Collapse>
          </Container>
        </Navbar>
       
    );
};
export default Navigationbar;
