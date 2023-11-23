import { useCallback } from "react";
import { useNavigate } from "react-router-dom";
import "./Kedvencreceptek.css";

const Kedvencreceptek = () => {
  const navigate = useNavigate();

  const onRecCardContainerClick = useCallback(() => {
    navigate("/recept");
  }, [navigate]);

  const onRecCardContainer1Click = useCallback(() => {
    navigate("/recept");
  }, [navigate]);

  const onRecCardContainer2Click = useCallback(() => {
    navigate("/recept");
  }, [navigate]);

  const onReceptekTextClick = useCallback(() => {
    navigate("/receptek");
  }, [navigate]);

  const onKaltabTextClick = useCallback(() => {
    navigate("/kaloriatablazatok");
  }, [navigate]);

  const onGroupIconClick = useCallback(() => {
    navigate("/userpage");
  }, [navigate]);

  return (
    <div className="kedvencreceptek">
      <div className="deskbg3">
        <img
          className="katie-smith-uqs1802d0cq-unspla-icon3"
          alt=""
          src="/katiesmithuqs1802d0cqunsplash-11@2x.png"
        />
        <div className="bgoverlay3" />
      </div>
      <div className="mainwindow-container">
        <img className="mainwindow-icon" alt="" src="/mainwindow.svg" />
        <div className="rectangle-parent1">
          <div className="frame-child4" />
          <div className="kedvenc-receptjeim-wrapper">
            <div className="kedvenc-receptjeim">Kedvenc receptjeim</div>
          </div>
          <div className="rec-card6" onClick={onRecCardContainerClick}>
            <div className="rec-card-child4" />
            <div className="recept-neve7">recept neve</div>
          </div>
          <div className="rec-card7" onClick={onRecCardContainer1Click}>
            <div className="rec-card-child4" />
            <div className="recept-neve7">recept neve</div>
          </div>
          <div className="rec-card8" onClick={onRecCardContainer2Click}>
            <div className="rec-card-child4" />
            <div className="recept-neve7">recept neve</div>
          </div>
        </div>
        <div className="logo-parent1">
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
            <div className="feltoltes4">Feltöltés</div>
          </div>
          <img
            className="group-icon"
            alt=""
            src="/group-42.svg"
            onClick={onGroupIconClick}
          />
        </div>
      </div>
    </div>
  );
};

export default Kedvencreceptek;
