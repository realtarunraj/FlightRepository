import React from 'react'
import "../css/login.css";
import axios from "axios";
import { useLocation, useNavigate } from 'react-router-dom';
import AdminNavbar from '../component/adminnavbar';
import "../css/addactivities.css"


export default function AddActivities() {
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
    <AdminNavbar entity={user}/><br/>
    <h1>AddActivities </h1>
	<form>
		<label for="name">Description</label>
		<input type="text" id="name" name="name" placeholder="eg Bangalore to Uttar pradesh at 5pm"/>

		<label for="charges">Charges</label>
		<input type="email" id="charges" name="charges" placeholder="eg 1000"/>
        <div style={{textAlign:"center"}}>
		<button onClick={addactivity}  type="button" className='btn btn-primary' value="Add Activity">Add activity</button>
        </div>
        </form>
    </>
  )

  function addactivity(){
    var url="http://localhost:8080/activity/add"
    var payload={
        "activityId": 0,
  "description": document.getElementById("name").value,
  "charges": Number(document.getElementById("charges").value)
    }

    axios.post(url,payload).then((res)=>{
        alert("activity added succesfully")
        navigate("/admin/home",{state:{data:user}})
    }).catch(err=>{alert(err)})
  }
}
