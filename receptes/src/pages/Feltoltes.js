import { useCallback } from "react";
import { useNavigate } from "react-router-dom";
import "./Feltoltes.css";

const Feltoltes = () => {
  const navigate = useNavigate();

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
    <div className="feltoltes1">
      <div className="deskbg-parent">
        <div className="deskbg1">
          <img
            className="katie-smith-uqs1802d0cq-unspla-icon1"
            alt=""
            src="/katiesmithuqs1802d0cqunsplash-11@2x.png"
          />
          <div className="bgoverlay1" />
        </div>
        <div className="mainwindow1" />
        <div className="frame-inner" />
        <div className="rectangle-parent">
          <div className="rectangle-div" />
          <div className="hvhozzaadas">
            <div className="div">+</div>
          </div>
          <div className="nyilvnos-parent">
            <div className="nyilvnos">Nyilvános?</div>
            <div className="circle2">
              <div className="circle-inner" />
            </div>
          </div>
          <div className="elkszts">{`Elkészítés: `}</div>
          <div className="recept-neve-parent">
            <div className="recept-neve">Recept neve:</div>
            <div className="recept-neve">Adagok száma:</div>
            <div className="recept-neve">Hozzávalók:</div>
          </div>
          <div className="frame-child1" />
          <div className="frame-child2" />
          <div className="receptnev">receptnev</div>
          <div className="adagszam">adagszam</div>
          <div className="hozzavalosor">
            <div className="rectangle-group">
              <div className="group-child" />
              <div className="hozzavalo">hozzavalo</div>
            </div>
            <div className="rectangle-container">
              <div className="group-item" />
              <div className="mnnysg">mnnysg</div>
            </div>
            <div className="group-div">
              <div className="group-inner" />
              <div className="mrtg">mrtg</div>
            </div>
          </div>
          <div className="vector-parent">
            <img className="rectangle-icon" alt="" src="/rectangle-82.svg" />
            <div className="szoveg">szoveg</div>
          </div>
          <div className="feltlts-wrapper">
            <div className="feltlts">Feltöltés</div>
          </div>
          <div className="recept-feltltse">Recept feltöltése</div>
        </div>
        <div className="logo-group">
          <div className="logo1">
            <div className="foodtime1">
              <b>Food</b>
              <span className="time1">Time</span>
            </div>
          </div>
          <div className="menu1">
            <div className="receptek1" onClick={onReceptekTextClick}>
              Receptek
            </div>
            <div className="kaltab1" onClick={onKaltabTextClick}>
              Kalóriatáblázat
            </div>
            <div className="feltoltes2">Feltöltés</div>
          </div>
          <img
            className="instance-item"
            alt=""
            src="/group-42.svg"
            onClick={onGroupIconClick}
          />
        </div>
      </div>
    </div>
  );
};

export default Feltoltes;
