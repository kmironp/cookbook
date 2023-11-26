import { useCallback } from "react";
import { useNavigate } from "react-router-dom";
import "./Receptek.css";

const Receptek = () => {
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

  const onRecCardContainer3Click = useCallback(() => {
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
    <div className="receptek8">
      <div className="deskbg9">
        <img
          className="katie-smith-uqs1802d0cq-unspla-icon9"
          alt=""
          src="/katiesmithuqs1802d0cqunsplash-13@2x.png"
        />
        <div className="bgoverlay9" />
      </div>
      <div className="mainwindow-parent4">
        <div className="mainwindow8" />
        <div className="frame-child12" />
        <div className="rectangle-parent6">
          <div className="frame-child13" />
          <div className="rec-card10" onClick={onRecCardContainerClick}>
            <div className="rec-card-child8" />
            <div className="recept-neve11">recept neve</div>
          </div>
          <div className="rec-card11" onClick={onRecCardContainer1Click}>
            <div className="rec-card-child8" />
            <div className="recept-neve11">recept neve</div>
          </div>
          <div className="rec-card12" onClick={onRecCardContainer2Click}>
            <div className="rec-card-child8" />
            <div className="recept-neve11">recept neve</div>
          </div>
          <div className="rec-card13" onClick={onRecCardContainer3Click}>
            <div className="rec-card-child8" />
            <div className="recept-neve11">recept neve</div>
          </div>
        </div>
        <div className="hatter-kereseshez-parent">
          <div className="hatter-kereseshez" />
          <div className="frame-child14" />
          <div className="frame-child15" />
          <div className="frame-child16" />
          <div className="frame-child17" />
          <b className="glutnmentes">gluténmentes</b>
          <b className="laktzmentes">laktózmentes</b>
          <b className="vegetrinus">vegetáriánus</b>
          <b className="vegn">vegán</b>
            <input
              className="hozzavalo-beirasa"
              type="text"
              name="hozzval-neve"
              placeholder="Hozzávaló neve"
              // megoldani a beolvasást
            />
            <input
              className="recept-beirasa"
              type="text"
              name="recept-neve"
              placeholder="Recept neve"
              // megoldani a beolvasást
            />
          <div className="kereso-gomb">
            <div className="searchoutline-parent">
              <img
                className="searchoutline-icon"
                alt=""
                src="/searchoutline.svg"
              />
              <div className="search">Keresés</div>
            </div>
          </div>
          <div className="receptek-keresse-hozzval">
            RECEPTEK KERESÉSE HOZZÁVALÓ ALAPJÁN:
          </div>
          <img className="elvalaszto-icon" alt="" src="/elvalaszto.svg" />
          <div className="tart-alap">
            <div className="alap">
              <div className="radiogombokdefaulttart1">
                <div className="circle3">
                  <div className="ellipse-div" />
                </div>
                <div className="tartalmazza1">Tartalmazza</div>
              </div>
              <div className="radiogombokdefaulttart1">
                <div className="circle3">
                  <div className="ellipse-div" />
                </div>
                <div className="tartalmazza1">Kihagyja</div>
              </div>
            </div>
          </div>
        </div>
        <div className="logo-parent5">
          <div className="logo9">
            <div className="foodtime9">
              <b>Food</b>
              <span className="time9">Time</span>
            </div>
          </div>
          <div className="menu8">
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
          <img
            className="instance-child7"
            alt=""
            src="/group-42.svg"
            onClick={onGroupIconClick}
          />
        </div>
      </div>
    </div>
  );
};

export default Receptek;
