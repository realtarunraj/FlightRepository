import React from "react";
import CustomNavbar from "./CustomNavbar";
import "bootstrap/dist/css/bootstrap.min.css";

const Base = ({ title = "Welcome to our Website", children }) => {
  return (
    <div className="container-fluid p-0 m-0">
      <CustomNavbar />

      {children}

      <h1> This is footer</h1>
    </div>
  );
};

export default Base;
