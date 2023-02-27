import { useLocation, useNavigate } from "react-router-dom";
import axios from "axios";
import CustomerNavbar from "../component/CustomerNavbar";
import { useEffect, useState } from "react";

export default function CustomerTickets() {
  
  const [ticket, setTicket] = useState([]);
  const [loading,setLoading]=useState([]);
  const [isWindowReloaded, setIsWindowReloaded] = useState(false);

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

  var id=customer.customerId
  fetchData(id)

  return (
    <div>
      <CustomerNavbar entity={customer} />
      <br/>
        
      <div style={{width:"80%"}} className="container">
        <table className="table">
          <thead style={{textAlign:"center"}}>
          <h3>Your tickets</h3> <br/>
            <tr className="my-3">
              <th scope="col">TicketId</th>
              <th scope="col">FlightId</th>
              <th scope="col">Flight description</th>
              <th scope="col">Tracel date</th>
              <th scope="col">Price</th>
              <th scope="col">Cancel booking</th>
            </tr>
          </thead>
          <tbody style={{textAlign:"center"}}>
            {ticket?.map((activity) => (
              <tr key={activity.ticketId}>
                <th scope="row">{activity.ticketId}</th>
                <td>{activity.activities.activityId}</td>
                <td>{activity.activities.description}</td>
                <td>{activity.dateTime}</td>
                <td>{activity.activities.charges}</td>
                <button
                  type="button"
                  class="btn btn-danger"
                  style={{marginTop:"10px"}}
                  onClick={() => {
                    deleteticket(activity.ticketId);
                  }}
                  data-toggle="modal"
                  data-target="#exampleModalCenter"
                >
                  cancel
                </button>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
      <br></br>
    </div>
  );
  
  function fetchData(id) {
    if (loading) {
      var url = "http://localhost:8080/ticket/viewall/" + id;
    axios.get(url).then((res) => {
      setTicket(res.data);
    }).finally(setLoading(false))
  }
}

  function deleteticket(id) {
    var url = "http://localhost:8080/ticket/delete/" + id;
    console.log(url);
    axios
      .get(url)
      .then((res) => {
        alert(res.data);
        if (!isWindowReloaded) {
          setIsWindowReloaded(true);
          window.location.reload();
        }
      })
      .catch((err) => {
        alert(err);
      });
  }
}
