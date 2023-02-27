import React from "react";
import { useNavigate } from "react-router-dom";
import "../css/customernavbar.css";

const AdminNavbar = (props) => {
 const navigate= useNavigate()
  return (
    <>
      <div class="page">
        <header tabindex="0">
          {" "}
          <h3 onClick={()=>{
          navigate("/admin/home",{state:{data:props.entity}})
        }}  style={{marginLeft:"auto"}}> {props.entity.role} Dashboard</h3>{" "}
          <h4 style={{marginLeft:"31%",marginRight:"10px"}}>Hi {props.entity.userName} </h4>
        </header>
        
        <div id="nav-container">
          <div class="bg"></div>
          <div class="button" tabindex="0">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </div>
          <div id="nav-content" tabindex="0">
            <ul>
              <li>
                <a onClick={()=>{
                    navigate("/admin/profile",{ state: { data: props.entity }})
                  } }>
                  <span class="material-symbols-outlined" >person</span> Profile
                  </a>
              </li> 
              <li>
                <a onClick={()=>{
                    navigate("/admin/update",{ state: { data: props.entity }})
                  } }>
                  <span class="material-symbols-outlined">edit_note</span>
                  Update
                </a>
              </li>
              <li>
                <a onClick={()=>{
                  navigate("/admin/delete",{ state: { data: props.entity }})
                  
                }}>
                  <span class="material-symbols-outlined">delete</span>Delete
                </a>
              </li>

              <li>
                <a onClick={()=>{navigate("/")}}>
                  <span class="material-symbols-outlined">logout</span> Log Out
                </a>
              </li>
              <li class="small">
                <a href="#0">Facebook</a>
                <a href="#0">Instagram</a>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </>
  );

 
};

export default AdminNavbar;
