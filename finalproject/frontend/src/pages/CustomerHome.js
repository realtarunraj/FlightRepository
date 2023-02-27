import React, { useEffect } from "react";
import { useLocation, useNavigate } from "react-router-dom";
import "../../node_modules/bootstrap/dist/css/bootstrap.css";
import CustomerNavbar from "../component/CustomerNavbar";
import "../css/button.css";

function CustomerHome(props) {


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

  function booking() {
    navigate("/customer/booking", { state: { data: customer } });
  }

  function tickets() {
    navigate("/customer/tickets", { state: { data: customer } });
  }

  return (
    <>
      <CustomerNavbar entity={customer} />
      <div className="cont container-fluid">
      <br/>
        <div className="row">
          <div className="col-sm-12 col-md-12 col-lg-6">
            <button
              onClick={() => {
                booking();
              }}
              type="button"
              className="btn-primary bigbutton"
            >
              <h2>
                Book Tickets &nbsp;
                <span className="icons material-symbols-outlined">
                  flight_takeoff
                </span>
              </h2>
            </button>
          </div>
          <div className="col-sm-12 col-md-12 col-lg-6">
            <button type="button" onClick={tickets} className="btn-primary bigbutton">
              <h2>
                View Ticket &nbsp;
                <span className="icons material-symbols-outlined">
                  {" "}
                  airplane_ticket{" "}
                </span>
              </h2>
            </button>
          </div>
        </div>
      </div>
    </>
  );
}

export default CustomerHome;
