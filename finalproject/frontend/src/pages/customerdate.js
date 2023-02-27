import axios from "axios";
import React from "react";
import { useLocation, useNavigate } from "react-router-dom";
import CustomerNavbar from "../component/CustomerNavbar";
import "../css/profile.css";

export default function CustomerDate() {
  const location = useLocation();
  const navigate = useNavigate();
  var customer = location.state.cus;
  var ticket = location.state.tik;
  return (
    <>
      <CustomerNavbar entity={customer} />
      <br />
      <div class="container">
        <div class="card">
          <div class="card-header">
            <h1>Ticket Details</h1>
          </div>
          <div class="card-body">
            <table class="table">
              <tr>
                <th>Name</th>
                <td>{customer.userName}</td>
              </tr>
              <tr>
                <th>ticket description</th>
                <td>{ticket.description}</td>
              </tr>
              <tr>
                <th>Price</th>
                <td>{ticket.charges}</td>
              </tr>
              <tr>
                <th>select date of travel</th>
                <td>
                  <form>
                    <input
                      type="date"
                      min={new Date().toISOString().split("T")[0]}
                      id="date"
                    />
                  </form>
                </td>
              </tr>
              <tr></tr>
            </table>
          </div>
          <div style={{ textAlign: "center", marginBottom: "2%" }}>
            <button
              style={{ marginRight: "2%" }}
              className="btn btn-secondary"
              onClick={() => {
                navigate("/customer/home", { state: { data: customer } });
              }}
            >
              Back
            </button>

            <button className="btn btn-primary" onClick={book} type="button">
              Book
            </button>
          </div>
        </div>
      </div>
    </>
  );

  function book() {
    var url = "http://localhost:8080/ticket/create";
    var payload = {
      ticketId: 0,
      customer: customer,
      activities: ticket,
      dateTime: document.getElementById("date").value,
    };
    if (payload.dateTime === "") {
      alert("please select a valid date");
    } else {
      setTimeout(() => {
        axios
          .post(url, payload)
          .then((res) => {
            alert("booked succesfully");
            navigate("/customer/home", { state: { data: customer } });
          })
          .catch((err) => {
            alert(err);
          });
      }, 500);
    }
  }
}
