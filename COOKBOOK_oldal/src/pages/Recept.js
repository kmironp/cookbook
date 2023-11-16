import { useCallback } from "react";
import { useNavigate } from "react-router-dom";
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

  return (
    <div className="recept">
      <div className="window2">
        <div className="window2">
          <img
            className="katie-smith-uqs1802d0cq-unspla-icon3"
            alt=""
            src="/katiesmithuqs1802d0cqunsplash-1@2x.png"
          />
          <div className="bgoverlay3" />
        </div>
        <div className="appwindow3">
          <div className="mainwindow3" />
        </div>
        <div className="window-child" />
        <div className="hozzavalok">hozzavalok</div>
        <div className="elkszts">Elkészítés:</div>
        <div className="elkeszites">elkeszites</div>
      </div>
      <div className="rec-card">
        <div className="rec-card-child" />
        <div className="rec-card-item" />
        <div className="recept-neve">recept neve</div>
      </div>
      <div className="hozzvalk">Hozzávalók:</div>
      <div className="adagok-szma">Adagok száma:</div>
      <div className="logo-group">
        <div className="logo3">
          <div className="foodtime3">
            <b>Food</b>
            <span className="time3">Time</span>
          </div>
        </div>
        <div className="menu3">
          <div className="receptek3" onClick={onReceptekTextClick}>
            Receptek
          </div>
          <div className="kaltab3" onClick={onKaltabTextClick}>
            Kalóriatáblázat
          </div>
          <div className="feltoltes3" onClick={onFeltoltesTextClick}>
            Feltöltés
          </div>
        </div>
        <img className="group-icon" alt="" src="/group-4.svg" />
      </div>
    </div>
  );
};

export default Recept;
