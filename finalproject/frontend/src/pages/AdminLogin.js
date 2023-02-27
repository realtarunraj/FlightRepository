import React, { useState } from "react";
import "../css/login.css";
import CustomNavbar from "../component/CustomNavbar";
import { useNavigate } from "react-router-dom";
import axios from "axios";

const AdminLogin = () => {
  const navigate = useNavigate();

  const adminlogin = () => {
    var url = "http://localhost:8080/admin/login/";
    var email = String(document.getElementById("email").value);
    var pass = String(document.getElementById("pass").value);
    url = url + email + "/" + pass;
    axios
      .get(url)
      .then((res) => {
        if (res.data) {
          navigate("/admin/home",{state:{data:res.data}})
        }
      })
      .catch((err) => {
        alert("invalid credentials");
      });
  };

  return (
    <>
      <CustomNavbar />
      <br></br>
      <div className="Auth-form-container">
        <form className="Auth-form">
          <div className="Auth-form-content">
            <h3 className="Auth-form-title">Admin Login</h3>
            <div className="text-center"></div>

            <div className="form-group mt-3">
              <label>E-Mail</label>
              <input
                type="email"
                id="email"
                className="form-control mt-1"
                placeholder="abcxyz@gmail.com"
              />
            </div>

            <div className="form-group mt-3">
              <label>Password</label>
              <input
                type="password"
                id="pass"
                className="form-control mt-1"
                placeholder="e.g rajtarun123"
              />
            </div>

            <div className="d-grid gap-2 mt-3">
              <button
                type="button"
                className="btn btn-primary"
                onClick={adminlogin}
              >
                Submit
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
  function gotoreset(){
    navigate("/aresetpassword")
  }
};

export default AdminLogin;
