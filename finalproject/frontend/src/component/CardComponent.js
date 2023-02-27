import React from "react";
import "../css/card.css";

const CardComponent = (props) => {
  return (
    <div className="card">
      <img src={props.img} className="card-img-top" alt="cardimage" />
      <div className="card-body">
        <p className="card-text">{props.title}</p>
        <button onClick={props.cardactivity}> {props.button} </button>
      </div>
    </div>
  );
};

export default CardComponent;
