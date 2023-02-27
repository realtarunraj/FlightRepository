import { useLocation, useNavigate } from "react-router-dom";
import "../../node_modules/bootstrap/dist/css/bootstrap.css";
import AdminNavbar from "../component/adminnavbar";
import "../css/button.css";

function AdminHome(props) {


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
    <>
      <AdminNavbar entity={customer} />
      <div style={{textAlign:"center"}} className="cont container-fluid">
      <br/>
     
        <div className="row">
          <div className="col-sm-12 col-md-12 col-lg-6">
            <button
               onClick={()=>(navigate("/admin/register",{state:{data:customer}}))} 
              type="button"
              className="btn-primary bigbutton"
            >
              <h2>
                Register admin &nbsp;
                <span className="icons material-symbols-outlined">
                person_add
                </span>
              </h2>
            </button>
          </div>
          <div className="col-sm-12 col-md-12 col-lg-6">
            <button type="button" onClick={()=>(navigate("/admin/addactivities",{state:{data:customer}}))} className="btn-primary bigbutton">
              <h2>
                Add activities &nbsp;
                <span className="icons material-symbols-outlined">
                flight_takeoff
                </span>
              </h2>
            </button>
          </div>
          <div className="col-sm-12 col-md-12 col-lg-6">
            <button
              onClick={() => {navigate("/admin/allactivities",{state:{data:customer}})
              }}
              type="button"
              className="btn-primary bigbutton"
            >
              <h2>
                View activities &nbsp;
                <span className="icons material-symbols-outlined">
                  flight_takeoff
                </span>
              </h2>
            </button>
          </div>
          <div className="col-sm-12 col-md-12 col-lg-6">
            <button onClick={()=>{navigate("/admin/planetickets",{state:{data:customer}})}} type="button"  className="btn-primary bigbutton">
              <h2>
                view tickets of dates &nbsp;
                <span className="icons material-symbols-outlined">
                  {" "}
                  airplane_ticket{" "}
                </span>
              </h2>
            </button>
          </div>
        </div>
        <br/><br/>
      </div>
    </>
  );
}

export default AdminHome;
