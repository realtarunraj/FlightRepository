import React from 'react'
import "../css/login.css";
import { useLocation, useNavigate } from "react-router-dom";
import axios from "axios";
import CustomerNavbar from '../component/CustomerNavbar';


export default function CustomerUpdate() {
    const navigate=useNavigate()
    const location=useLocation()
  var customer = location.state.data;
  return (<>
    <CustomerNavbar entity={customer}/><br/>
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
                defaultValue={customer.userName}
              />
            </div>

            <div className="form-group mt-3">
              <label>Email address</label>
              <input
                id="email"
                type="email"
                className="form-control mt-1"
                placeholder="Email Address"
                value={customer.email}
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
                defaultValue={customer.mobileNo}
              />
            </div>

            <div className="form-group mt-3">
              <label>Address</label>
              <input
                id="address"
                type="text"
                className="form-control mt-1"
                placeholder="Address"
                defaultValue={customer.address}
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
        "customerId": customer.customerId,
        "userName": document.getElementById("user").value,
        "password": customer.password,
        "address": document.getElementById("address").value,
        "mobileNo": document.getElementById("num").value,
        "email": customer.email
      }
      var url="http://localhost:8080/customer/update"
      axios.post(url,payload).then((res)=>{
        alert("update successfull");
        navigate("/customer/home",{state:{data:res.data}})
      })
  }
}
