import React from "react";
import CustomNavbar from "./CustomNavbar";
import "../css/login.css";
import axios from "axios";
import { useNavigate } from "react-router-dom";

export default function ResetPass(props) {
  const navigate = useNavigate();
  return (
    <>
      <CustomNavbar />
      <br></br>
      <div className="Auth-form-container">
        <form className="Auth-form">
          <div className="Auth-form-content">
            <h3 className="Auth-form-title">Reset password</h3>
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
              <label>New Password</label>
              <input
                type="password"
                id="pass"
                className="form-control mt-1"
                placeholder="e.g rajtarun123"
              />
            </div>

            <div className="d-grid gap-2 mt-3">
              <button type="button" className="btn btn-primary" onClick={reset}>
                Reset
              </button>
            </div>
          </div>
        </form>
      </div>
    </>
  );

  function reset() {
    var email = document.getElementById("email").value;
    var pass = document.getElementById("pass").value;
    var url =
      "http://localhost:8080/" +
      props.user +
      "/setpassword/" +
      email +
      "/" +
      pass;
    axios
      .post(url)
      .then((res) => {
        if (res.status === 200) navigate("/home");
      })
      .catch((err) => {
        alert(err);
      });
  }
}
