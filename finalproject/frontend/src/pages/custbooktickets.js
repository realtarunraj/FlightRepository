import React, { useEffect, useState } from "react";
import { useLocation, useNavigate } from "react-router-dom";
import axios from "axios";
import CustomerNavbar from "../component/CustomerNavbar";

export default function CustBookTickets() {
  const [activities, setActivities] = useState([]);
  var url = "http://localhost:8080/admin/allctivities";
  var info = axios.get(url);
  useEffect(() => {
    info.then((res) => {
      setActivities(res.data);
    });
  }, []);

  const navigate = useNavigate();
  try {
    const location = useLocation();
    var customer = location.state.data;
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
      <CustomerNavbar entity={customer} />
      <div className="container">
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
                <button
                  type="button"
                  class="btn btn-primary"
                  onClick={() => {
                    navigate("/customer/date",{state:{cus:customer,tik:activity}})
                  }}
                >
                  Book Ticket
                </button>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
  
}
