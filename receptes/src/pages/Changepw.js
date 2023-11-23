import { useCallback } from "react";
import { useNavigate } from "react-router-dom";
import "./Changepw.css";

const Changepw = () => {
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
    <div className="changepw">
      <div className="deskbg">
        <img
          className="katie-smith-uqs1802d0cq-unspla-icon"
          alt=""
          src="/katiesmithuqs1802d0cqunsplash-1@2x.png"
        />
        <div className="bgoverlay" />
      </div>
      <div className="mainwindow-parent">
        <div className="mainwindow" />
        <div className="frame-child" />
        <div className="felhasznlsfelulet">
          <div className="felhasznlsfelulet-child" />
          <div className="felhasznlnv-parent">
            <div className="felhasznlnv">felhasználónév</div>
            <div className="e-mail-cm">e-mail cím</div>
          </div>
        </div>
        <img className="frame-item" alt="" src="/group-4.svg" />
        <div className="component-331">
          <div className="component-33-item" />
          <div className="rgi-jelsz1">Régi jelszó:</div>
        </div>
        <div className="component-35">
          <div className="component-33-item" />
          <div className="rgi-jelsz1">Új jelszó még egyszer:</div>
        </div>
        <div className="component-34">
          <div className="component-33-item" />
          <div className="rgi-jelsz1">Új jelszó:</div>
        </div>
        <div className="logo-parent">
          <div className="logo">
            <div className="foodtime">
              <b>Food</b>
              <span className="time">Time</span>
            </div>
          </div>
          <div className="menu">
            <div className="receptek" onClick={onReceptekTextClick}>
              Receptek
            </div>
            <div className="kaltab" onClick={onKaltabTextClick}>
              Kalóriatáblázat
            </div>
            <div className="feltoltes" onClick={onFeltoltesTextClick}>
              Feltöltés
            </div>
          </div>
          <img className="instance-child" alt="" src="/group-41.svg" />
        </div>
      </div>
    </div>
  );
};

export default Changepw;
