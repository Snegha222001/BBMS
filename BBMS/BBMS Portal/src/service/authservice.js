import axios from "axios";

const login = (userName, password) => {
  return axios
    .post("http://localhost:9001/auth/login", {
      userName,
      password,
    })
    .then((response) => {
      if (response.data.jwtToken) {
        localStorage.setItem("user", JSON.stringify(response.data));
        localStorage.setItem("role", JSON.stringify(response.data.user.role[0].roleName));
        
      }
      return response.data;
    });
};
const logout = () => {
  localStorage.removeItem("user");
  localStorage.removeItem("role");
};
const getCurrentUser = () => {
  return JSON.parse(localStorage.getItem("user"));
};
const AuthService = {
  
  login,
  logout,
  getCurrentUser,
};
export default AuthService;