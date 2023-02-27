import React, { useState } from "react";
import "../css/login.css";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import CustomNavbar from "../component/CustomNavbar";

const CustomerLogin = () => {
  const navigate = useNavigate();
  let [authMode, setAuthMode] = useState("signin");

  const changeAuthMode = () => {
    setAuthMode(authMode === "signin" ? "signup" : "signin");
  };

  const registerCustomer = () => {
    var payload = {
      customerId: 0,
      userName: String(document.getElementById("user").value),
      password: String(document.getElementById("pass").value),
      address: String(document.getElementById("address").value),
      mobileNo: String(document.getElementById("num").value),
      email: String(document.getElementById("email").value),
    };
    console.log(payload);
    var url = "http://localhost:8080/customer/create";
    axios
      .post(url, payload)
      .then((res) => {
        console.log(res.data);
      })
      .catch((err) => {
        console.log(err);
      });

    changeAuthMode();
  };

  const loginCustomer = () => {
    var url="http://localhost:8080/customer/login/"
    var email=String(document.getElementById("email").value);
    var pass=String(document.getElementById("pass").value);
    url=url+email+"/"+pass;
    axios.get(url).then(res=>{
      if(res.status===200){

        navigate("/customer/home",{state:{data:res.data}})
      }
    }).catch(err=>{
      alert("invalid ")
    })
  };

  if (authMode === "signin") {
    return (
      <>
        <CustomNavbar />
        <br></br>
        <div className="Auth-form-container">
          <form className="Auth-form Auth-form-signin">
            <div className="Auth-form-content">
              <h3 className="Auth-form-title"> Customer SignIn </h3>
              <div className="text-center">
                Not registered yet?{" "}
                <span className="link-primary" onClick={changeAuthMode}>
                  Sign Up
                </span>
              </div>

              <div className="form-group mt-3">
                <label> Email </label>
                <input
                  id="email"
                  type="email"
                  className="form-control mt-1"
                  placeholder="Enter email"
                />
              </div>

              <div className="form-group mt-3">
                <label>Password</label>
                <input
                  id="pass"
                  type="password"
                  className="form-control mt-1"
                  placeholder="Enter password"
                />
              </div>

              <div className="d-grid gap-2 mt-3">
                <button
                  type="button"
                  className="btn btn-primary"
                  onClick={loginCustomer}
                >
                  Login
                </button>
              </div>
              <p onClick={gotoreset} className="text-center mt-2">
                Forgot password?
              </p>
            </div>
          </form>
        </div>
      </>
    );
  }

  return (
    <>
      <CustomNavbar />
      <br></br>
      <div className="Auth-form-container">
        <form className="Auth-form">
          <div className="Auth-form-content">
            <h3 className="Auth-form-title"> Customer Registration </h3>
            <div className="text-center">
              Already registered?{" "}
              <span className="link-primary" onClick={changeAuthMode}>
                Sign In
              </span>
            </div>

            <div className="form-group mt-3">
              <label>UserName</label>
              <input
                id="user"
                type="text"
                className="form-control mt-1"
                placeholder="e.g Jane Doe"
              />
            </div>

            <div className="form-group mt-3">
              <label> Password </label>
              <input
                id="pass"
                type="password"
                className="form-control mt-1"
                placeholder="e.g Jane Doe"
              />
            </div>

            <div className="form-group mt-3">
              <label>Email address</label>
              <input
                id="email"
                type="email"
                className="form-control mt-1"
                placeholder="Email Address"
              />
            </div>

            <div className="form-group mt-3">
              <label>Mobile No</label>
              <input
                id="num"
                type="text"
                className="form-control mt-1"
                placeholder="mobile no"
              />
            </div>

            <div className="form-group mt-3">
              <label>Address</label>
              <input
                id="address"
                type="text"
                className="form-control mt-1"
                placeholder="Address"
              />
            </div>

            <div className="d-grid gap-2 mt-3">
              <button
                type="button"
                className="btn btn-primary"
                onClick={registerCustomer}
              >
                Register
              </button>
            </div>
          </div>
        </form>
      </div>
      <br></br>
    </>
  );

  function gotoreset(){
    navigate("/cresetpassword")
  }
};

export default CustomerLogin;
