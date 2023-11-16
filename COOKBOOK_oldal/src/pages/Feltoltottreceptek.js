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
    <div className="feltoltottreceptek">
      <div className="window7">
        <div className="window7">
          <img
            className="katie-smith-uqs1802d0cq-unspla-icon9"
            alt=""
            src="/katiesmithuqs1802d0cqunsplash-11@2x.png"
          />
          <div className="bgoverlay9" />
        </div>
        <div className="appwindow9">
          <div className="mainwindow9" />
        </div>
      </div>
      <img
        className="prof1-icon4"
        alt=""
        src="/prof12.svg"
        onClick={onProf1IconClick}
      />
      <div className="logo9">
        <div className="foodtime9">
          <b>Food</b>
          <span className="time9">Time</span>
        </div>
      </div>
      <div className="rectangle-parent7">
        <div className="frame-child11" />
        <div className="rec-card7" onClick={onRecCardContainerClick}>
          <div className="rec-card-child12" />
          <div className="rec-card-child13" />
          <div className="recept-neve8">recept neve</div>
        </div>
        <div className="rec-card8" onClick={onRecCardContainer1Click}>
          <div className="rec-card-child12" />
          <div className="rec-card-child13" />
          <div className="recept-neve8">recept neve</div>
        </div>
        <div className="rec-card9" onClick={onRecCardContainer2Click}>
          <div className="rec-card-child12" />
          <div className="rec-card-child13" />
          <div className="recept-neve8">recept neve</div>
        </div>
        <div className="ltalam-feltlttt-receptek-wrapper">
          <div className="ltalam-feltlttt-receptek">
            Általam feltöltött receptek
          </div>
        </div>
      </div>
      <div className="logo-parent4">
        <div className="logo10">
          <div className="foodtime10">
            <b>Food</b>
            <span className="time9">Time</span>
          </div>
        </div>
        <div className="menu10">
          <div className="receptek9" onClick={onReceptekTextClick}>
            Receptek
          </div>
          <div className="kaltab8" onClick={onKaltabTextClick}>
            Kalóriatáblázat
          </div>
          <div className="feltoltes9" onClick={onFeltoltesTextClick}>
            Feltöltés
          </div>
        </div>
        <img className="instance-child5" alt="" src="/group-4.svg" />
      </div>
    </div>
  );
};

export default Feltoltottreceptek;
