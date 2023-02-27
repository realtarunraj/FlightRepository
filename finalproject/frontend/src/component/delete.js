import axios from 'axios'
import React from 'react'
import { useNavigate } from 'react-router-dom'
import "../css/delete.css"
import CustomerNavbar from './CustomerNavbar'

export default function Delete(props) {
    const navigate = useNavigate()
    var cancelurl="/"+props.data.role+"/home"
    var delurl="/"
    var user=props.data
    console.log("hellao")
  return (
    <>
    <CustomerNavbar entity={user}/>
    <div id="deleteModal">
    <div class="borderline modal-content">
      <div class="modal-header">
        <h2>Delete User</h2>
      </div>
      <div class="modal-body">
        <p>Are you sure you want to delete this user?</p>
      </div>
      <div class="modal-footer">
        <button class="modal-btn" onClick={()=>{ navigate(cancelurl,{state:{data:user}})}} id="cancelBtn">Cancel</button>
        <button class="modal-btn" onClick={deleteuser} id="deleteBtn">Delete</button>
      </div>
    </div>
  </div>
  </>
  )

  function deleteuser(){
    var id;
    if(user.role==="customer"){
      id=user.customerId
    }
    else{
      id=user.adminId
    }
    var url="http://localhost:8080/"+user.role+"/delete/"+id
    axios.get(url).then((res)=>{
      alert(res.data)
      navigate(delurl)
    })
  }
}
