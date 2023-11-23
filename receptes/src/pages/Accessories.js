import { useCallback } from "react";
import { useNavigate } from "react-router-dom";
import "./Accessories.css";

const Accessories = () => {
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
    <div className="accessories">
      <div className="sign-in-wrapper">
        <i className="sign-in">Sign in</i>
      </div>
      <img className="prof1-icon1" alt="" src="/prof11.svg" />
      <img className="prof0-icon" alt="" src="/prof0.svg" />
      <div className="logo-parent6">
        <div className="logo11">
          <div className="foodtime11">
            <b>Food</b>
            <span className="time11">Time</span>
          </div>
        </div>
        <div className="menu9">
          <div className="receptek10" onClick={onReceptekTextClick}>
            Receptek
          </div>
          <div className="kaltab9" onClick={onKaltabTextClick}>
            Kalóriatáblázat
          </div>
          <div className="feltoltes10" onClick={onFeltoltesTextClick}>
            Feltöltés
          </div>
        </div>
        <img className="component-child" alt="" src="/group-42.svg" />
      </div>
      <div className="searchoutline-group">
        <img className="searchoutline-icon1" alt="" src="/searchoutline.svg" />
        <div className="search1">Search</div>
      </div>
      <div className="rectangle-parent7">
        <img className="component-item" alt="" src="/rectangle-723@2x.png" />
        <div className="kedvenc-receptek3">Kedvenc receptek</div>
      </div>
      <div className="component-3">
        <img
          className="component-3-child"
          alt=""
          src="/rectangle-7323@2x.png"
        />
        <b className="kategria24">Kategória</b>
      </div>
      <div className="menu10">
        <div className="receptek11">Receptek</div>
        <div className="kaltab10">Kalóriatáblázat</div>
        <div className="feltoltes11">Feltöltés</div>
      </div>
      <img className="accessories-child" alt="" src="/group-42.svg" />
      <div className="logo12">
        <div className="foodtime11">
          <b>Food</b>
          <span className="time11">Time</span>
        </div>
      </div>
    </div>
  );
};

export default Accessories;
