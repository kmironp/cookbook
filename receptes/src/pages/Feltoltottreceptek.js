import { useCallback } from "react";
import { useNavigate } from "react-router-dom";
import "./Feltoltottreceptek.css";

const Feltoltottreceptek = () => {
  const navigate = useNavigate();

  const onProf1IconClick = useCallback(() => {
    navigate("/userpage");
  }, [navigate]);

  const onRecCardContainerClick = useCallback(() => {
    navigate("/recept");
  }, [navigate]);

  const onRecCardContainer1Click = useCallback(() => {
    navigate("/recept");
  }, [navigate]);

  const onRecCardContainer2Click = useCallback(() => {
    navigate("/recept");
  }, [navigate]);

  const onRecCardContainer3Click = useCallback(() => {
    navigate("/recept");
  }, [navigate]);

  const onRecCardContainer4Click = useCallback(() => {
    navigate("/recept");
  }, [navigate]);

  const onRecCardContainer5Click = useCallback(() => {
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

  const onGroupIconClick = useCallback(() => {
    navigate("/userpage");
  }, [navigate]);

  return (
    <div className="feltoltottreceptek">
      <div className="deskbg2">
        <img
          className="katie-smith-uqs1802d0cq-unspla-icon2"
          alt=""
          src="/katiesmithuqs1802d0cqunsplash-12@2x.png"
        />
        <div className="bgoverlay2" />
      </div>
      <div className="mainwindow-group">
        <div className="mainwindow2" />
        <img
          className="prof1-icon"
          alt=""
          src="/prof1.svg"
          onClick={onProf1IconClick}
        />
        <div className="frame-div">
          <div className="frame-child3" />
          <div className="rec-card" onClick={onRecCardContainerClick}>
            <div className="rec-card-child" />
            <div className="recept-neve1">recept neve</div>
          </div>
          <div className="rec-card1" onClick={onRecCardContainer1Click}>
            <div className="rec-card-child" />
            <div className="recept-neve1">recept neve</div>
          </div>
          <div className="rec-card2" onClick={onRecCardContainer2Click}>
            <div className="rec-card-child" />
            <div className="recept-neve1">recept neve</div>
          </div>
          <div className="rec-card3" onClick={onRecCardContainer3Click}>
            <div className="rec-card-child" />
            <div className="recept-neve1">recept neve</div>
          </div>
          <div className="rec-card4" onClick={onRecCardContainer4Click}>
            <div className="rec-card-child" />
            <div className="recept-neve1">recept neve</div>
          </div>
          <div className="rec-card5" onClick={onRecCardContainer5Click}>
            <div className="rec-card-child" />
            <div className="recept-neve1">recept neve</div>
          </div>
          <div className="ltalam-feltlttt-receptek-wrapper">
            <div className="ltalam-feltlttt-receptek">
              Általam feltöltött receptek
            </div>
          </div>
        </div>
        <div className="logo-container">
          <div className="logo2">
            <div className="foodtime2">
              <b>Food</b>
              <span className="time2">Time</span>
            </div>
          </div>
          <div className="menu2">
            <div className="receptek2" onClick={onReceptekTextClick}>
              Receptek
            </div>
            <div className="kaltab2" onClick={onKaltabTextClick}>
              Kalóriatáblázat
            </div>
            <div className="feltoltes3" onClick={onFeltoltesTextClick}>
              Feltöltés
            </div>
          </div>
          <img
            className="instance-inner"
            alt=""
            src="/group-42.svg"
            onClick={onGroupIconClick}
          />
        </div>
      </div>
    </div>
  );
};

export default Feltoltottreceptek;
