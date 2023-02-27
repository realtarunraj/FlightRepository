import React from "react";
import Footer from "../component/Footer";
import CustomNavbar from "../component/CustomNavbar";
import "../css/About.css";
import image1 from "../images/deepak.jpg";
import image2 from "../images/tarun.jpg";
import image3 from "../images/nilaj.jpg";

const About = () => {
  return (
    <>
      <CustomNavbar />
      <>
        <section id="page-header" className="about-header">
          <div className="page-header-hashtag">
            <h2>
              <b>#about_us</b>
            </h2>
            <p> Leave a Message, We love to hear from You !! </p>
          </div>
        </section>
        <section id="contact-details" className="section-p1">
          <div className="details">
            <span>
              <b> GET IN TOUCH</b>
            </span>
            <div>
              <li>
                <i className="fa fa-home" />
                <p> Jet Airlines, Whitefield, Banglore (Karnataka) </p>
              </li>
              <li>
                <i className="far fa-envelope" />
                <p> contact@jetairways.com </p>
              </li>
              <li>
                <i className="fas fa-phone-alt" />
                <p> +91 9876543210 </p>
              </li>
              <li>
                <i className="far fa-clock" />
                <p> Monday to Saturday: 9:00am to 8:00pm </p>
              </li>
            </div>
          </div>
          <div className="map">
            <iframe
              src="https://maps.google.com/maps?q=capgemini divyashree&t=&z=10&ie=UTF8&iwloc=&output=embed"
              width={600}
              height={450}
              style={{ border: 0 }}
              allowFullScreen=""
              loading="lazy"
              referrerPolicy="no-referrer-when-downgrade"
            />
          </div>
        </section>
        <section id="form-details">
          <form className="leave-message-form" action="">
            <span> LEAVE A MESSAGE </span>
            <h2> We love to hear from you. </h2>
            <input type="text" placeholder="Your Name" />
            <input type="text" placeholder="E-Mail" />
            <input type="text" placeholder="Subject" />
            <textarea
              name=""
              id=""
              cols={30}
              rows={3}
              placeholder="Your Message"
              defaultValue={""}
            />
            <button className="normal"> Submit </button>
          </form>
          <div className="people">
            <div>
              <img src={image1} alt="" />
              <p>
                <span> Deepak D </span> Analyst/Software Engineer
                <br /> Phone: +91 9876543210 <br /> E-Mail:
                deepak.b.d@jetairlines.com
              </p>
            </div>
            <div>
              <img src={image2} alt="" />
              <p>
                <span> Tarun Kumar Raj </span> Analyst/Software Engineer
                <br /> Phone: +91 9876543210 <br /> E-Mail:
                tarun.kumar-raj@jetairlines.com
              </p>
            </div>
            <div>
              <img src={image3} alt="" />
              <p>
                <span> Nilaj Chakraborty </span> Analyst/Software Engineer
                <br /> Phone: +91 9876543210 <br /> E-Mail:
                nilaj.chakraborty@jetairlines.com
              </p>
            </div>
          </div>
        </section>
      </>

      <Footer />
    </>
  );
};

export default About;
