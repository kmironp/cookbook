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

  const onFeltoltesTextClick = useCallback(() => {
    navigate("/feltoltes");
  }, [navigate]);

  return (
    <div className="kedvencreceptek">
      <div className="deskbg6">
        <img
          className="katie-smith-uqs1802d0cq-unspla-icon6"
          alt=""
          src="/katiesmithuqs1802d0cqunsplash-1@2x.png"
        />
        <div className="bgoverlay6" />
      </div>
      <div className="appwindow6">
        <div className="mainwindow6" />
        <div className="appwindow-inner">
          <div className="frame-child9" />
        </div>
        <div className="kedvenc-receptjeim-wrapper">
          <div className="kedvenc-receptjeim">Kedvenc receptjeim</div>
        </div>
        <div className="rec-card4" onClick={onRecCardContainerClick}>
          <div className="rec-card-child6" />
          <div className="rec-card-child7" />
          <div className="recept-neve5">recept neve</div>
        </div>
        <div className="rec-card5" onClick={onRecCardContainer1Click}>
          <div className="rec-card-child6" />
          <div className="rec-card-child7" />
          <div className="recept-neve5">recept neve</div>
        </div>
        <div className="rec-card6" onClick={onRecCardContainer2Click}>
          <div className="rec-card-child6" />
          <div className="rec-card-child7" />
          <div className="recept-neve5">recept neve</div>
        </div>
      </div>
      <div className="logo-parent1">
        <div className="logo6">
          <div className="foodtime6">
            <b>Food</b>
            <span className="time6">Time</span>
          </div>
        </div>
        <div className="menu7">
          <div className="receptek6" onClick={onReceptekTextClick}>
            Receptek
          </div>
          <div className="kaltab5" onClick={onKaltabTextClick}>
            Kalóriatáblázat
          </div>
          <div className="feltoltes6" onClick={onFeltoltesTextClick}>
            Feltöltés
          </div>
        </div>
        <img className="instance-child2" alt="" src="/group-4.svg" />
      </div>
    </div>
  );
};

export default Kedvencreceptek;
