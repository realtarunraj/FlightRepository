import React from 'react'
import "../css/login.css";
import { useLocation, useNavigate } from "react-router-dom";
import axios from "axios";
import AdminNavbar from '../component/adminnavbar';


export default function AdminUpdate() {
    const navigate=useNavigate()
    const location=useLocation()
  var admin = location.state.data;
  return (<>
    <AdminNavbar entity={admin}/><br/>
    <div className="Auth-form-container">
        <form className="Auth-form">
          <div className="Auth-form-content">
            <h3 className="Auth-form-title"> Update details </h3>
            <div className="text-center">
            </div>

            <div className="form-group mt-3">
              <label>UserName</label>
              <input
                id="user"
                type="text"
                className="form-control mt-1"
                placeholder="e.g Jane Doe"
                defaultValue={admin.userName}
              />
            </div>

            <div className="form-group mt-3">
              <label>Email address</label>
              <input
                id="email"
                type="email"
                className="form-control mt-1"
                placeholder="Email Address"
                value={admin.email}
                readOnly
              />
            </div>

            <div className="form-group mt-3">
              <label>Mobile No</label>
              <input
                id="num"
                type="text"
                className="form-control mt-1"
                placeholder="mobile no"
                defaultValue={admin.mobileNo}
              />
            </div>

            <div className="form-group mt-3">
              <label>Address</label>
              <input
                id="address"
                type="text"
                className="form-control mt-1"
                placeholder="Address"
                defaultValue={admin.address}
                contentEditable
              />
            </div>

            <div className="d-grid gap-2 mt-3">
              <button
                type="button"
                className="btn btn-primary"
                onClick={update}
              >
                update
              </button>
            </div>
          </div>
        </form>
      </div>
      </>
  )

  function update(){
    var payload={
        "adminId": admin.adminId,
        "userName": document.getElementById("user").value,
        "password": admin.password,
        "address": document.getElementById("address").value,
        "mobileNo": document.getElementById("num").value,
        "email": admin.email
      }

      var url="http://localhost:8080/admin/update"
      axios.post(url,payload).then((res)=>{
        alert("update successfull");
        navigate("/admin/home",{state:{data:res.data}})
      })
  }
}
