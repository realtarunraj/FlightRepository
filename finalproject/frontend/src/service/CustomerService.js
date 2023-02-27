import React from "react";
import Base from "../component/Base";
import "../css/customerservice.css";
import "bootstrap/dist/css/bootstrap.css";
import CardComponent from "../component/CardComponent";
import image from "../images/banner3.jpg";
import banner from "../images/banner3.jpg";
import { useNavigate } from "react-router-dom";

const CustomerService = () => {
  const navigate = useNavigate();

  const bookticket = () => {
    navigate("/ticketbooking", { replace: true });
  };

  const viewticket = () => {
    navigate("/viewticket", { replace: true });
  };

  const viewprofile = () => {
    navigate("/viewprofile", { replace: true });
  };

  const updateprofile = () => {
    navigate("/updateprofile", { replace: true });
  };

  const deleteprofile = () => {
    navigate("/deleteprofile", { replace: true });
  };

  return (
    <Base>
      <div className="card-group banner-image">
        <img src={banner} alt="bannerimage" />
      </div>
      <div className="card-group">
        <CardComponent
          img={image}
          title="Click Here to book Your Ticket."
          button="Book Ticket"
          cardactivity="bookticket"
        />

        <CardComponent
          img={image}
          title="Click To view Your Tickets."
          button="View Ticket"
          cardactivity="viewticket"
        />

        <CardComponent
          img={image}
          title="Click to view your profile."
          button="View Profile"
          viewticket="viewprofile"
        />

        <CardComponent
          img={image}
          title="Click to view your profile."
          button="View Profile"
          viewticket="updateprofile"
        />
      </div>
    </Base>
  );
};

export default CustomerService;
