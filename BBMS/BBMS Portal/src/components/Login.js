
import React, { useState } from "react";
import { useNavigate } from 'react-router-dom';
import "../css/Login.css";
import Navigationbar from './Navbar';
import Footerfunc from './Footer';
import AuthService from "../service/authservice";


const Login = () => {
  let navigate = useNavigate();
  const [userName, setUserName] = useState("");
  const [password, setPassword] = useState("");
  const onChangeUsername = (e) => {
    const userName = e.target.value;
    setUserName(userName);
  };
  const onChangePassword = (e) => {
    const password = e.target.value;
    setPassword(password);
  };
  const handleLogin = (e) => {
    e.preventDefault();

    AuthService.login(userName, password).then(
      () => {
        const role= localStorage.getItem('role');
        console.log(role);
        if(localStorage.getItem('role')==='"USER"'){
          navigate("/donor");
          window.location.reload();
        }
        else{
        navigate("/hospital");
        window.location.reload();
      }
    }
    ).catch(
      err => {
        console.log(err);
        window.alert("Invalid Credentials");
      }
    )

  };
return (
  <div>
    <Navigationbar />

    <div className="login-form-container">
      <form className="login-form" onSubmit={handleLogin}>
        <div className="login-form-content">
          <h3 className="login-form-title"> Login</h3>
          <div className="form-group mt-3">
            <label>User Name</label>
            <input
              type="text"
              className="form-control mt-1"
              placeholder="Enter user_name"
              value={userName}
              onChange={onChangeUsername}
            />
          </div>
          <div className="form-group mt-3">
            <label>Password</label>
            <input
              type="password"
              className="form-control mt-1"
              placeholder="Enter password"
              value={password}
              onChange={onChangePassword}
            />
          </div>
          <div className="d-grid gap-2 mt-3">
            <button type="submit" className="btn btn-danger">
              Submit
            </button>
          </div>
        </div>
      </form>
    </div>
    <Footerfunc />
  </div>
);
  
};
export default Login;