import { useCallback } from "react";
import { useNavigate } from "react-router-dom";
import "./Receptek.css";

const Receptek = () => {
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

  const onTablTextClick = useCallback(() => {
    navigate("/kaloriatablazatok");
  }, [navigate]);

  const onUjrecTextClick = useCallback(() => {
    navigate("/feltoltes");
  }, [navigate]);

  return (
    <div className="receptek5">
      <div className="window4">
        <div className="window4">
          <img
            className="katie-smith-uqs1802d0cq-unspla-icon5"
            alt=""
            src="/katiesmithuqs1802d0cqunsplash-11@2x.png"
          />
          <div className="bgoverlay5" />
        </div>
        <div className="appwindow5">
          <div className="mainwindow5" />
        </div>
      </div>
      <img
        className="prof1-icon3"
        alt=""
        src="/prof11.svg"
        onClick={onProf1IconClick}
      />
      <div className="logo5">
        <div className="foodtime5">
          <b>Food</b>
          <span className="time5">Time</span>
        </div>
      </div>
      <div className="receptek-child" />
      <div className="receptek-inner">
        <div className="frame-child8" />
      </div>
      <div className="rec-card1" onClick={onRecCardContainerClick}>
        <div className="rec-card-inner" />
        <div className="rec-card-child1" />
        <div className="recept-neve2">recept neve</div>
      </div>
      <div className="rec-card2" onClick={onRecCardContainer1Click}>
        <div className="rec-card-inner" />
        <div className="rec-card-child1" />
        <div className="recept-neve2">recept neve</div>
      </div>
      <div className="rec-card3" onClick={onRecCardContainer2Click}>
        <div className="rec-card-inner" />
        <div className="rec-card-child1" />
        <div className="recept-neve2">recept neve</div>
      </div>
      <div className="menu5">
        <div className="menu6">
          <div className="rec">Receptek</div>
          <div className="tabl" onClick={onTablTextClick}>
            Kalóriatáblázat
          </div>
          <div className="ujrec" onClick={onUjrecTextClick}>
            Feltöltés
          </div>
        </div>
      </div>
      <div className="hatter-kereseshez" />
      <div className="receptek-item" />
      <div className="receptek-child1" />
      <div className="receptek-child2" />
      <div className="receptek-child3" />
      <b className="glutnmentes">gluténmentes</b>
      <b className="laktzmentes">laktózmentes</b>
      <b className="vegetrinus">vegetáriánus</b>
      <b className="vegn">vegán</b>
      <div className="hozzavalo-beirasa">
        <div className="hozzval-neve">Hozzávaló_neve</div>
      </div>
      <div className="kereso-gomb">
        <div className="searchoutline-parent">
          <img className="searchoutline-icon" alt="" src="/searchoutline.svg" />
          <div className="search">Keresés</div>
        </div>
      </div>
      <div className="receptek-keresse">Receptek keresése</div>
      <div className="elvalaszto" />
      <div className="tart-kihagy-kivalasztva">
        <div className="kihagy-kivalasztva">
          <div className="radiogombok1">
            <div className="circle5">
              <div className="circle-child2" />
            </div>
            <div className="tartalmazza2">Tartalmazza</div>
          </div>
          <div className="radiogombok1">
            <div className="circle6">
              <div className="circle-child3" />
            </div>
            <div className="tartalmazza2">Kihagyja</div>
          </div>
        </div>
      </div>
      <div className="tart-tart-kivalasztva">
        <div className="kihagy-kivalasztva">
          <div className="radiogombok1">
            <div className="circle6">
              <div className="circle-child3" />
            </div>
            <div className="tartalmazza2">Tartalmazza</div>
          </div>
          <div className="radiogombok1">
            <div className="circle5">
              <div className="circle-child2" />
            </div>
            <div className="tartalmazza2">Kihagyja</div>
          </div>
        </div>
      </div>
      <div className="tart-alap">
        <div className="kihagy-kivalasztva">
          <div className="radiogombok1">
            <div className="circle5">
              <div className="circle-child2" />
            </div>
            <div className="tartalmazza2">Tartalmazza</div>
          </div>
          <div className="radiogombok1">
            <div className="circle5">
              <div className="circle-child2" />
            </div>
            <div className="tartalmazza2">Kihagyja</div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Receptek;
