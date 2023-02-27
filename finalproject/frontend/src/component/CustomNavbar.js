import React, { useState } from "react";
import { NavLink as ReactLink } from "react-router-dom";
import "../css/customNavbar.css";

import {
  Collapse,
  Navbar,
  NavbarToggler,
  NavbarBrand,
  Nav,
  NavItem,
  NavLink,
  UncontrolledDropdown,
  DropdownToggle,
  DropdownMenu,
  DropdownItem,
  NavbarText,
} from "reactstrap";

import img from "../images/flightlogo.png";

const CustomNavbar = () => {
  const [isOpen, setIsOpen] = useState(false);

  const [user, setUser] =
    useState(
      ""
    ); /**  This will show the name of User if they have entered correct authentication. */

  return (
    <div>
      <Navbar className="navbarflex" color="primary" expand="md" fixed="">
        <NavbarBrand
          className="home-list home-list-brand"
          tag={ReactLink}
          to="/"
        >
          <img
            alt="logo"
            src={img}
            style={{
              height: 40,
              width: 40,
              marginRight: 10,
            }}
          />
          <b className="logonavbar"> Jet Airlines </b>
        </NavbarBrand>

        <NavbarToggler
          onClick={() => setIsOpen(!isOpen)}
          className="me-2 navbar-toggler"
        />
        <Collapse isOpen={isOpen} navbar>
          <Nav className="me-auto" navbar>
            <NavItem>
              <NavLink className="home-list" tag={ReactLink} to="/home">
                Home
              </NavLink>
            </NavItem>
            <NavItem>
              <NavLink className="home-list" tag={ReactLink} to="/about">
                About Us
              </NavLink>
            </NavItem>
            <UncontrolledDropdown nav inNavbar>
              <DropdownToggle nav caret className="home-list">
                Login
              </DropdownToggle>
              <DropdownMenu right className="home-list">
                <DropdownItem>
                  <NavLink tag={ReactLink} to="/customer" className="m-0 p-1">
                    Customer Login
                  </NavLink>
                </DropdownItem>
                <DropdownItem>
                  <NavLink tag={ReactLink} to="/admin" className="m-0 p-1">
                    Admin Login
                  </NavLink>
                </DropdownItem>
                <DropdownItem divider />
                <DropdownItem>
                  <NavLink tag={ReactLink} to="/contactus" className="m-0 p-1">
                    Contact Us
                  </NavLink>
                </DropdownItem>
              </DropdownMenu>
            </UncontrolledDropdown>
          </Nav>
          <NavbarText className="home-list"></NavbarText>
        </Collapse>
      </Navbar>
    </div>
  );
};

export default CustomNavbar;
