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
      <img className="prof1-icon6" alt="" src="/prof13.svg" />
      <img className="prof0-icon1" alt="" src="/prof0.svg" />
      <div className="logo-parent5">
        <div className="logo14">
          <div className="foodtime14">
            <b>Food</b>
            <span className="time14">Time</span>
          </div>
        </div>
        <div className="menu12">
          <div className="receptek11" onClick={onReceptekTextClick}>
            Receptek
          </div>
          <div className="kaltab10" onClick={onKaltabTextClick}>
            Kalóriatáblázat
          </div>
          <div className="feltoltes11" onClick={onFeltoltesTextClick}>
            Feltöltés
          </div>
        </div>
        <img className="component-item" alt="" src="/group-4.svg" />
      </div>
      <div className="searchoutline-group">
        <img className="searchoutline-icon1" alt="" src="/searchoutline.svg" />
        <div className="search1">Search</div>
      </div>
      <div className="rectangle-parent8">
        <img className="component-inner" alt="" src="/rectangle-723@2x.png" />
        <div className="kedvenc-receptek3">Kedvenc receptek</div>
      </div>
      <div className="component-36">
        <img className="component-3-item" alt="" src="/rectangle-7323@2x.png" />
        <b className="kategria24">Kategória</b>
      </div>
    </div>
  );
};

export default Accessories;
