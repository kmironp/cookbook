import { useCallback } from "react";
import { useNavigate } from "react-router-dom";
import "./Tablazat.css";

const Tablazat = () => {
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
    <div className="tablazat">
      <div className="window6">
        <div className="deskbg8">
          <img
            className="katie-smith-uqs1802d0cq-unspla-icon8"
            alt=""
            src="/katiesmithuqs1802d0cqunsplash-1@2x.png"
          />
          <div className="bgoverlay8" />
        </div>
        <div className="appwindow8">
          <div className="mainwindow8" />
        </div>
        <div className="window-item" />
        <div className="window-inner">
          <div className="kategria-nv-wrapper">
            <div className="kategria-nv">Kategória név</div>
          </div>
        </div>
      </div>
      <div className="fejlc">
        <div className="alapanyag-wrapper">
          <div className="alapanyag">Alapanyag</div>
        </div>
        <div className="energia-wrapper">
          <div className="alapanyag">Energia</div>
        </div>
        <div className="fehrje-wrapper">
          <div className="alapanyag">Fehérje</div>
        </div>
        <div className="zsr-wrapper">
          <div className="alapanyag">Zsír</div>
        </div>
        <div className="sznhidrt-wrapper">
          <div className="alapanyag">Szénhidrát</div>
        </div>
        <div className="gi-wrapper">
          <div className="alapanyag">GI</div>
        </div>
      </div>
      <div className="row">
        <div className="component-27">
          <div className="component-27-child" />
          <div className="alapanyag1">alapanyag</div>
        </div>
        <div className="component-28">
          <div className="component-27-child" />
          <div className="alapanyag2">energia</div>
        </div>
        <div className="component-29">
          <div className="component-27-child" />
          <div className="alapanyag3">feherje</div>
        </div>
        <div className="component-30">
          <div className="component-27-child" />
          <div className="alapanyag4">zsir</div>
        </div>
        <div className="component-31">
          <div className="component-27-child" />
          <div className="alapanyag5">szenhidrat</div>
        </div>
        <div className="component-32">
          <div className="component-27-child" />
          <div className="alapanyag6">gi</div>
        </div>
      </div>
      <div className="logo-parent3">
        <div className="logo8">
          <div className="foodtime8">
            <b>Food</b>
            <span className="time8">Time</span>
          </div>
        </div>
        <div className="menu9">
          <div className="receptek8" onClick={onReceptekTextClick}>
            Receptek
          </div>
          <div className="kaltab7" onClick={onKaltabTextClick}>
            Kalóriatáblázat
          </div>
          <div className="feltoltes8" onClick={onFeltoltesTextClick}>
            Feltöltés
          </div>
        </div>
        <img className="instance-child4" alt="" src="/group-4.svg" />
      </div>
    </div>
  );
};

export default Tablazat;
