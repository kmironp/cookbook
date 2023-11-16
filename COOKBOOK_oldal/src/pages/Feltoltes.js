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

  return (
    <div className="feltoltes4">
      <div className="window3">
        <div className="deskbg4">
          <img
            className="katie-smith-uqs1802d0cq-unspla-icon4"
            alt=""
            src="/katiesmithuqs1802d0cqunsplash-1@2x.png"
          />
          <div className="bgoverlay4" />
        </div>
        <div className="appwindow4">
          <div className="mainwindow4" />
        </div>
        <div className="frame-div">
          <div className="frame-child4" />
          <div className="wrapper">
            <div className="div">+</div>
          </div>
          <div className="nyilvnos-parent">
            <div className="nyilvnos">Nyilvános?</div>
            <div className="circle">
              <div className="circle-child" />
            </div>
          </div>
          <div className="elkszts1">{`Elkészítés: `}</div>
          <div className="recept-neve-parent">
            <div className="recept-neve1">Recept neve:</div>
            <div className="recept-neve1">Adagok száma:</div>
            <div className="recept-neve1">Hozzávalók:</div>
          </div>
          <div className="frame-child5" />
          <div className="frame-child6" />
          <div className="receptnev">receptnev</div>
          <div className="adagszam">adagszam</div>
          <div className="group-div">
            <div className="group-child" />
            <div className="hozzavalo">hozzavalo</div>
          </div>
          <div className="rectangle-parent1">
            <div className="group-item" />
            <div className="mnnysg">mnnysg</div>
          </div>
          <div className="rectangle-parent2">
            <div className="group-item" />
            <div className="mnnysg">mnnysg</div>
          </div>
          <div className="rectangle-parent3">
            <div className="group-item" />
            <div className="mnnysg">mnnysg</div>
          </div>
          <div className="rectangle-parent4">
            <div className="group-item" />
            <div className="mnnysg">mnnysg</div>
          </div>
          <div className="rectangle-parent5">
            <div className="group-child3" />
            <div className="hozzavalo1">hozzavalo</div>
          </div>
          <div className="vector-parent">
            <img className="frame-child7" alt="" src="/rectangle-82.svg" />
            <div className="szoveg">szoveg</div>
          </div>
          <div className="feltlts-wrapper">
            <div className="feltlts">Feltöltés</div>
          </div>
          <div className="recept-feltltse">Recept feltöltése</div>
        </div>
      </div>
      <div className="feltoltes-child" />
      <div className="logo-container">
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
          <div className="feltoltes5">Feltöltés</div>
        </div>
        <img className="instance-child1" alt="" src="/group-4.svg" />
      </div>
    </div>
  );
};

export default Feltoltes;
