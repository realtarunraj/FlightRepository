import axios from 'axios';
import React, { useState } from 'react'
import { useLocation, useNavigate } from 'react-router-dom';
import AdminNavbar from '../component/adminnavbar';
import "../css/planetickets.css"

export default function PlaneTickets() {

    const [activities,setActivities]=useState([])

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
    <h1 className='ph1'>Get Tickets</h1>
    <form className='pform'>
      <label className='plabel' for="id">Plane Id:</label>
      <input className='pinput' type="text" id="id" name="id"/>

      <label className='plabel' for="start">Start Date:</label>
      <input className='pinput' type="date" id="start" name="start"/>

      <label className='plabel' for="end">End Date:</label>
      <input className='pinput' type="date" id="end" name="end"/>

      <button className='btn btn-primary' onClick={getTickets} type="button">Get Tickets</button>
    </form>
    <div>
    <div  className="container">
 
 <table className="table">
   <thead>
     <tr className="my-3">
        <th scope="col">Ticket Id</th>
       <th scope="col">Flight Id</th>
       <th scope="col">Customer Name </th>
       <th scope="col">Flight description</th>
       <th scope="col">Travel Date</th>
       <th scope="col">Price</th>
     </tr>
   </thead>
   <tbody>
     {activities?.map((activity) => (
       <tr key={activity.ticketId}>
         <th scope="row">{activity.ticketId}</th>
         <td>{activity.activities.activityId}</td>
         <td>{activity.customer.customerId}</td>
         <td>{activity.activities.description}</td>
         <td>{activity.dateTime}</td>
         <td>{activity.activities.charges}</td>
       </tr>
     ))}
   </tbody>
 </table>
</div>
    </div>
    </>
  )

  function getTickets(){
    var id=document.getElementById("id").value;
    var start=String(document.getElementById("start").value);
    var end=String(document.getElementById("end").value);

    if(start===""||end==="" ){
        alert("The Start or End date is not valid")
    }else{
    var url="http://localhost:8080/ticket/getTicketsOfDate/"+id+"/"+start+"/"+end;
    axios.get(url).then((res)=>{
        setActivities(res.data)
        console.log(res.data)
    }).catch(err=>{alert(err)})
    }
  }
}
