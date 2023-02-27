import React from "react";
import CustomNavbar from "../component/CustomNavbar";
import Footer from "../component/Footer";
import "../css/Home.css";
import imghome from "../images/banner4.jpeg";

const Home = () => {
  return (
    <>
      <CustomNavbar />
      <div className="homepage-items">
        <img className="homepage-image" src={imghome} alt="home-image" />
        <div className="home-titles">
          <div className="welcome-to">Welcome to</div>
          <div className="jet-airways"> Jet Airlines </div>
        </div>
      </div>
      <Footer />
    </>
  );
};

export default Home;
