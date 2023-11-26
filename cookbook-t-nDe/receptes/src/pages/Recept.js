import { useCallback, useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import "./Recept.css";

const Recept = () => {
  const navigate = useNavigate();

  const onReceptekTextClick = useCallback(() => {
    navigate("/receptek");
  }, [navigate]);

  const onKaltabTextClick = useCallback(() => {
    navigate("/kaloriatablazatok");
  }, [navigate]);

  const onFeltoltesTextClick = useCallback(() => {
    navigate("/feltoltes");
  }, [navigate]);

  const onGroupIconClick = useCallback(() => {
    navigate("/userpage");
  }, [navigate]);

  const OneMorePerson = async () => {

  };

  const OneLessPerson = async () => {

  };


  // SZERINTEM TÁBLÁZATOKBA KÉNE !!!!!

  return (
    <div className="recept">
      <div className="deskbg4">
        <img
          className="katie-smith-uqs1802d0cq-unspla-icon4"
          alt=""
          src="/katiesmithuqs1802d0cqunsplash-11@2x.png"
        />
        <div className="bgoverlay4" />
      </div>
      <div className="mainwindow-parent1">
        <div className="mainwindow3" />
        <div className="frame-child5" />
        <div className="hozzavalok">Hozzávalók:</div>
        <div className="elkszts1">Elkészítés:</div>
        <div className="rec-card9">
          <div className="rec-card-child7" />
          <div className="recept-neve10">recept neve</div>
        </div>
        <div className="hozzvalk1">Leírás:</div>
        <div className="adagok-szma1">Adagok száma:</div>
        <div className="logo-parent2">
          <div className="logo4">
            <div className="foodtime4">
              <b>Food</b>
              <span className="time4">Time</span>
            </div>
          </div>
          <div className="menu4">
            <div className="receptek4" onClick={onReceptekTextClick}>
              Receptek
            </div>
            <div className="kaltab4" onClick={onKaltabTextClick}>
              Kalóriatáblázat
            </div>
            <div className="feltoltes5" onClick={onFeltoltesTextClick}>
              Feltöltés
            </div>
          </div>
          <img
            className="instance-child1"
            alt=""
            src="/group-42.svg"
            onClick={onGroupIconClick}
          />
        </div>
        <div className="add">
              {/* Add the button here */}
              <button className="add-button" onClick={OneMorePerson}>+</button>
            </div>
        <div className="notadd">
              {/* Add the button here */}
              <button className="notadd-button" onClick={OneLessPerson}>-</button>
            </div>
        <div className="addbtn1">
          <img className="addbtn-child" alt="" src="/star-1.svg" />
        </div>
      </div>
    </div>
  );
};

export default Recept;
