import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { useLocation, useNavigate } from 'react-router-dom';
import AdminNavbar from '../component/adminnavbar';

export default function ViewActivities() {
    const [activities,setActivities]=useState([])

    useEffect(()=>{
        var url="http://localhost:8080/admin/allctivities"
        axios.get(url).then(res=>{setActivities(res.data)})
    },[])

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
    <div>
      <AdminNavbar entity={user}/>
      <div  className="container">
 
        <table className="table">
          <thead>
            <tr className="my-3">
              <th scope="col">FlightId</th>
              <th scope="col">Flight description</th>
              <th scope="col">Price</th>
            </tr>
          </thead>
          <tbody>
            {activities?.map((activity) => (
              <tr key={activity.activityId}>
                <th scope="row">{activity.activityId}</th>
                <td>{activity.description}</td>
                <td>{activity.charges}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  )
}
