import { useCallback } from "react";
import { useNavigate } from "react-router-dom";
import "./Userpage.css";

const Userpage = () => {
  const navigate = useNavigate();

  const onFrameContainer2Click = useCallback(() => {
    navigate("/feltoltottreceptek");
  }, [navigate]);

  const onFrameContainer5Click = useCallback(() => {
    navigate("/");
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
    <div className="userpage">
      <div className="deskbg2">
        <img
          className="katie-smith-uqs1802d0cq-unspla-icon2"
          alt=""
          src="/katiesmithuqs1802d0cqunsplash-1@2x.png"
        />
        <div className="bgoverlay2" />
      </div>
      <div className="appwindow2">
        <div className="mainwindow-container">
          <div className="mainwindow2" />
          <div className="frame-child2" />
          <div className="felhasznlsfelulet2">
            <div className="felhasznlsfelulet-inner" />
            <div className="felhasznlnv-container">
              <div className="felhasznlnv2">felhasználónév</div>
              <div className="e-mail-cm2">e-mail cím</div>
            </div>
          </div>
          <div className="frame-child3" />
          <div className="instance-parent">
            <div className="rectangle-parent">
              <img
                className="instance-item"
                alt=""
                src="/rectangle-72@2x.png"
              />
              <div className="kedvenc-receptek">Kedvenc receptek</div>
            </div>
            <div className="rectangle-group" onClick={onFrameContainer2Click}>
              <img
                className="instance-item"
                alt=""
                src="/rectangle-721@2x.png"
              />
              <div className="kedvenc-receptek">Feltöltött receptek</div>
            </div>
          </div>
          <div className="instance-wrapper" onClick={onFrameContainer5Click}>
            <div className="rectangle-container">
              <img
                className="instance-item"
                alt=""
                src="/rectangle-722@2x.png"
              />
              <div className="kedvenc-receptek">Jelszó módosítás</div>
            </div>
          </div>
          <div className="menu2">
            <div className="receptek2" onClick={onReceptekTextClick}>
              Receptek
            </div>
            <div className="kaltab2" onClick={onKaltabTextClick}>
              Kalóriatáblázat
            </div>
            <div className="feltoltes2" onClick={onFeltoltesTextClick}>
              Feltöltés
            </div>
          </div>
        </div>
        <div className="logo2">
          <div className="foodtime2">
            <b>Food</b>
            <span className="time2">Time</span>
          </div>
        </div>
        <img className="prof1-icon2" alt="" src="/prof1.svg" />
      </div>
    </div>
  );
};

export default Userpage;
