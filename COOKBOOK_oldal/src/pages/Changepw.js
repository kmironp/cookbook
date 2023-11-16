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

  const onReceptekText1Click = useCallback(() => {
    navigate("/receptek");
  }, [navigate]);

  const onKaltabText1Click = useCallback(() => {
    navigate("/kaloriatablazatok");
  }, [navigate]);

  const onFeltoltesText1Click = useCallback(() => {
    navigate("/feltoltes");
  }, [navigate]);

  return (
    <div className="changepw">
      <div className="window">
        <div className="window">
          <img
            className="katie-smith-uqs1802d0cq-unspla-icon"
            alt=""
            src="/katiesmithuqs1802d0cqunsplash-1@2x.png"
          />
          <div className="bgoverlay" />
        </div>
        <div className="appwindow">
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
            <div className="component-33">
              <div className="component-33-child" />
              <div className="rgi-jelsz">Régi jelszó:</div>
            </div>
          </div>
          <div className="logo">
            <div className="foodtime">
              <b>Food</b>
              <span className="time">Time</span>
            </div>
          </div>
          <img className="prof1-icon" alt="" src="/prof1.svg" />
        </div>
      </div>
      <div className="window1">
        <div className="window">
          <img
            className="katie-smith-uqs1802d0cq-unspla-icon"
            alt=""
            src="/katiesmithuqs1802d0cqunsplash-1@2x.png"
          />
          <div className="bgoverlay" />
        </div>
        <div className="appwindow">
          <div className="mainwindow-parent">
            <div className="mainwindow" />
            <div className="frame-child" />
            <div className="felhasznlsfelulet1">
              <div className="felhasznlsfelulet-child" />
              <div className="felhasznlnv-parent">
                <div className="felhasznlnv">felhasználónév</div>
                <div className="e-mail-cm">e-mail cím</div>
              </div>
            </div>
            <div className="component-331">
              <div className="component-33-item" />
              <div className="rgi-jelsz">Régi jelszó:</div>
            </div>
            <div className="component-35">
              <div className="component-33-item" />
              <div className="rgi-jelsz">Új jelszó még egyszer:</div>
            </div>
            <div className="component-34">
              <div className="component-33-item" />
              <div className="rgi-jelsz">Új jelszó:</div>
            </div>
            <div className="frame-inner" />
            <div className="rectangle-div" />
            <div className="frame-child1" />
            <div className="logo-parent">
              <div className="logo1">
                <div className="foodtime">
                  <b>Food</b>
                  <span className="time">Time</span>
                </div>
              </div>
              <div className="menu1">
                <div className="receptek" onClick={onReceptekText1Click}>
                  Receptek
                </div>
                <div className="kaltab" onClick={onKaltabText1Click}>
                  Kalóriatáblázat
                </div>
                <div className="feltoltes" onClick={onFeltoltesText1Click}>
                  Feltöltés
                </div>
              </div>
              <img className="instance-child" alt="" src="/group-4.svg" />
            </div>
          </div>
          <img className="prof1-icon1" alt="" src="/prof1.svg" />
        </div>
      </div>
    </div>
  );
};

export default Changepw;
