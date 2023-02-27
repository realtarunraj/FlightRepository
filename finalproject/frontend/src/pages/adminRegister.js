import React from 'react'
import "../css/login.css";
import axios from "axios";
import { useLocation, useNavigate } from 'react-router-dom';
import AdminNavbar from '../component/adminnavbar';

export default function AdminRegister() {
    const navigate = useNavigate();
  try {
   
    const location = useLocation();
    var user = location.state.data;
  } catch (err) {
    return (
      <>
        <h1> login and come back </h1>
        <button
          onClick={() => {
            navigate("/home");
          }}
        >
          {" "}
          login
        </button>
      </>
    );
  }
  return (
    <>
    <AdminNavbar entity={user}/>
    <br/>
    <div className="Auth-form-container">
        <form className="Auth-form">
          <div className="Auth-form-content">
            <h3 className="Auth-form-title">Admin Registration </h3>
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
        <br/>
        <br/>
      </div>
    </>
  )

  function registerCustomer(){
    var url="http://localhost:8080/admin/create"
    var payload={
        adminId: 0,
        userName: String(document.getElementById("user").value),
        password: String(document.getElementById("pass").value),
        address: String(document.getElementById("address").value),
        mobileNo: String(document.getElementById("num").value),
        email: String(document.getElementById("email").value),
      }

      axios.post(url,payload).then(res=>{
        alert("admin registered succesfully")
        navigate("/admin/home",{state:{data:user}})
      }).catch(err=>{
        alert(err)
      })
  }
}
