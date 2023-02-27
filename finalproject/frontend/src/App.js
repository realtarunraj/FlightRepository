import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Home from "./pages/Home";
import About from "./pages/About";
import Offer from "./pages/Offer";
import CustomerLogin from "./pages/CustomerLogin";
import AdminLogin from "./pages/AdminLogin";
import Contactus from "./pages/Contactus";
import CustomerHome from "./pages/CustomerHome";
import CustomerNavbar from "./component/CustomerNavbar";
import CustBookTickets from "./pages/custbooktickets";
import CustomerResetPass from "./pages/cresetpass";
import AResetPass from "./pages/adminresetpassword";
import CustomerTickets from "./pages/customertickets";
import CustomerPofile from "./pages/customerprofile";
import AdminProfile from "./pages/adminprofile";
import CustomerUpdate from "./pages/customerupdate";
import CustomerDelete from "./pages/customerdelete";
import CustomerDate from "./pages/customerdate";
import AdminHome from "./pages/adminhome";
import AdminUpdate from "./pages/adminupdate";
import AdminDelete from "./pages/admindelete";
import AdminRegister from "./pages/adminRegister";
import AddActivities from "./pages/addactivities";
import ViewActivities from "./pages/viewactivities";
import PlaneTickets from "./pages/planetickets";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/home" element={<Home />} />
        <Route path="/about" element={<About />} />
        <Route path="/admin" element={<AdminLogin />} />
        <Route path="/customer" element={<CustomerLogin />} />
        <Route path="/offer" element={<Offer />} />
        <Route path="/contactus" element={<Contactus />} />
        <Route path="/customer/home" element={<CustomerHome />} />
        <Route path="/customernavbar" element={<CustomerNavbar />} />
        <Route path="/customer/booking" element={<CustBookTickets/>}/>
        <Route path="/cresetpassword" element={<CustomerResetPass/>}/>
        <Route path="/aresetpassword" element={<AResetPass/>}/>
        <Route path="/customer/tickets" element={<CustomerTickets/>}/>
        <Route path="/customer/profile" element={<CustomerPofile/>}/>
        <Route path="/admin/profile" element={<AdminProfile/>}/>
        <Route path="/customer/update" element={<CustomerUpdate/>}/>
        <Route path="/customer/delete" element={<CustomerDelete/>}/>
        <Route path="/customer/date" element={<CustomerDate/>}/>
        <Route path="/admin/home" element={<AdminHome/>}/>
        <Route path="/admin/update" element={<AdminUpdate/>}/>
        <Route path="/admin/delete" element={<AdminDelete/>}/>
        <Route path="/admin/register" element={<AdminRegister/>}/>
        <Route path="/admin/addactivities" element={<AddActivities/>}/>
        <Route path="/admin/allactivities" element={<ViewActivities/>}/>
        <Route path="/admin/planetickets" element={<PlaneTickets/>}/>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
