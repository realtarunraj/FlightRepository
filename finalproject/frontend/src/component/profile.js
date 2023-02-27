import React, { useContext } from 'react'
import CustomerNavbar from './CustomerNavbar'
import "../css/profile.css"


export default function Profile(props) {


  return (
    <>
    <CustomerNavbar entity={props.data}/><br/>
    <div class="container">
      <div class="card">
        <div class="card-header">
          <h1>{props.data.role} Details</h1>
        </div>
        <div class="card-body">
          <table class="table">
            <tr>
              <th>Name</th>
              <td>{props.data.userName}</td>
            </tr>
            <tr>
              <th>Email</th>
              <td>{props.data.email}</td>
            </tr>
            <tr>
              <th>Phone</th>
              <td>{props.data.mobileNo}</td>
            </tr>
            <tr>
              <th>Address</th>
              <td>{props.data.address}</td>
            </tr>
            <tr>
            <th>Role</th>
              <td>{props.data.role}</td>
            </tr>
          </table>
        </div>
      </div>
    </div>
    </>
  )
}
