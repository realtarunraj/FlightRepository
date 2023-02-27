import React from "react";
import "../css/Footer.css";
import appstore from "../images/app.jpg";
import googleplay from "../images/googleplay.jpg";
import paymentoption from "../images/payment.png";
import footerlogo from "../images/flightlogo.png";
import { Link } from "react-router-dom";

const Footer = () => {
  return (
    <footer className="section">
      <div className="col">
        <Link to="/">
          <img className="logo" src={footerlogo} alt="logo" />
        </Link>
        <h4>
          <strong> Contact </strong>
        </h4>
        <p>
          {" "}
          <strong> Address: </strong> Jet Airlines, Whitefield, Banglore
          (Karnataka)
          <br></br>Pin: 560066
        </p>
        <p>
          {" "}
          <strong> Phone: </strong> +91-945-123-4567{" "}
        </p>
        <p>
          {" "}
          <strong> Hours: </strong> 10:00 - 18:00, Mon-Sat{" "}
        </p>
        <div className="follow">
          <h4>
            {" "}
            <strong> Follow Us </strong>{" "}
          </h4>
          <div className="icon">
            <Link href="#">
              <i className="fab fa-facebook-f" />
            </Link>
            <Link href="#">
              <i className="fab fa-twitter" />
            </Link>
            <Link href="#">
              <i className="fab fa-instagram" />
            </Link>
            <Link href="#">
              <i className="fab fa-pinterest-p" />
            </Link>
            <Link href="#">
              <i className="fab fa-youtube" />
            </Link>
          </div>
        </div>
      </div>
      <div className="col">
        <h4>
          {" "}
          <strong> About </strong>{" "}
        </h4>
        <Link href="#"> About Us </Link>
        <Link href="#"> Current Offers </Link>
        <Link href="#"> Privacy Policy </Link>
        <Link href="#"> Terms &amp; Conditions </Link>
        <Link href="#"> Contact Us </Link>
      </div>
      <div className="col">
        <h4>
          {" "}
          <strong> My Account </strong>{" "}
        </h4>
        <Link href="#"> Sign In </Link>
        <Link href="#"> View Ticket </Link>
        <Link href="#"> Book Ticket </Link>
        <Link href="#"> Update Profile </Link>
        <Link href="#"> Help </Link>
      </div>
      <div className="col install">
        <h4>
          {" "}
          <strong> Install App </strong>{" "}
        </h4>
        <h4> From App Store or Google Play </h4>
        <div className="row">
          <img src={appstore} alt="AppStore" />
          <img src={googleplay} alt="GooglePlay" />
        </div>
        <h4> Secured payment Gateways </h4>
        <img src={paymentoption} alt="payment" />
      </div>
      <div className="copyright">
        <p> © 2023 Group-5</p>
      </div>
    </footer>
  );
};

export default Footer;
