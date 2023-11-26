import { useCallback,useState } from "react";
import { useNavigate } from "react-router-dom";
import "./Kaloriatablazatok.css";
import Tablazat from "./Tablazat";



const Kaloriatablazatok = () => {
  const navigate = useNavigate();

  const [cat,setCat] = useState('');

  const onEdessegContainerClick = useCallback(() => {
    navigate("/tablazat", {state: 'Édességek és ropogtatnivalók'});
  }, [navigate]);

  const onKategriaText1Click = useCallback(() => {
    navigate("/tablazat", {state: 'Alkoholos italok'});
  }, [navigate]);

  const onDiosContainerClick = useCallback(() => {
    navigate("/tablazat", {state: 'Diófélék és olajos magvak'});
  }, [navigate]);

  const onFuszerekContainerClick = useCallback(() => {
    navigate("/tablazat", {state: 'Fűszerek'});
  }, [navigate]);

  const onGyumolcsContainerClick = useCallback(() => {
    navigate("/tablazat", {state: 'Gyümölcsök és gyümölcskészítmények'});
  }, [navigate]);

  const onMarhaContainerClick = useCallback(() => {
    navigate("/tablazat", {state: 'Marha'});
  }, [navigate]);

  const onSzarnyasContainerClick = useCallback(() => {
    navigate("/tablazat", {state: 'Szárnyasok'});
  }, [navigate]);

  const onTejContainerClick = useCallback(() => {
    navigate("/tablazat", {state: 'Tejtermékek'});
  }, [navigate]);

  const onVadContainerClick = useCallback(() => {
    navigate("/tablazat", {state: 'Vad- és egyéb húsok'});
  }, [navigate]);

  const onBaranyContainerClick = useCallback(() => {
    navigate("/tablazat", {state: 'Bárány'});
  }, [navigate]);

  const onGabonaContainerClick = useCallback(() => {
    navigate("/tablazat", {state: 'Gabonatermékek'});
  }, [navigate]);

  const onHalakContainerClick = useCallback(() => {
    navigate("/tablazat", {state: 'Halak és tenger gyümölcsei'});
  }, [navigate]);

  const onPekaruContainerClick = useCallback(() => {
    navigate("/tablazat", {state: 'Pékáruk'});
  }, [navigate]);

  const onSzojaContainerClick = useCallback(() => {
    navigate("/tablazat", {state: 'Szójatermékek és növényi tejhelyettesítők'});
  }, [navigate]);

  const onTesztaContainerClick = useCallback(() => {
    navigate("/tablazat", {state: 'Tészták'});
  }, [navigate]);

  const onZoldsegContainerClick = useCallback(() => {
    navigate("/tablazat", {state: 'Zöldségek és hüvelyesek'});
  }, [navigate]);

  const onBorjuContainerClick = useCallback(() => {
    navigate("/tablazat", {state: 'Borjú'});
  }, [navigate]);

  const onIzesitoContainerClick = useCallback(() => {
    navigate("/tablazat", {state: 'Ételízesítők és hozzávalók'});
  }, [navigate]);

  const onGombaContainerClick = useCallback(() => {
    navigate("/tablazat", {state: 'Gombák'});
  }, [navigate]);

  const onHuskeszitmenyContainerClick = useCallback(() => {
    navigate("/tablazat", {state: 'Húskészítmények'});
  }, [navigate]);

  const onSertesContainerClick = useCallback(() => {
    navigate("/tablazat", {state: 'Sertés'});
  }, [navigate]);

  const onSzoszokContainerClick = useCallback(() => {
    navigate("/tablazat", {state: 'Szószok, öntetek, krémek'});
  }, [navigate]);

  const onTojasContainerClick = useCallback(() => {
    navigate("/tablazat", {state: 'Tojás'});
  }, [navigate]);

  const onZsirContainerClick = useCallback(() => {
    navigate("/tablazat", {state: 'Zsírok és olajok'});
  }, [navigate]);

  const onReceptekTextClick = useCallback(() => {
    navigate("/receptek", {state: 'Édesség'});
  }, [navigate]);

  const onFeltoltesTextClick = useCallback(() => {
    navigate("/feltoltes", {state: 'Édesség'});
  }, [navigate]);

  const onGroupIconClick = useCallback(() => {
    navigate("/userpage", {state: 'Édesség'});
  }, [navigate]);

  return (
    
    <div className="kaloriatablazatok">
      <Tablazat cat = {cat}/>
      <div className="deskbg-group">
        <div className="deskbg8">
          <img
            className="katie-smith-uqs1802d0cq-unspla-icon8"
            alt=""
            src="/katiesmithuqs1802d0cqunsplash-11@2x.png"
          />
          <div className="bgoverlay8" />
        </div>
        <div className="mainwindow7" />
        <div className="frame-child10" />
        <div className="rectangle-parent5">
          <div className="frame-child11" />
          <div className="edesseg" onClick={onEdessegContainerClick}>
            <img className="edesseg-child" alt="" src="/rectangle-73@2x.png" />
            <b className="kategria">Édességek és ropogtatnivalók</b>
          </div>
          <div className="alkohols">
            <img className="edesseg-child" alt="" src="/rectangle-731@2x.png" />
            <b className="kategria1" onClick={onKategriaText1Click}>
              Alkoholos italok
            </b>
          </div>
          <div className="dios" onClick={onDiosContainerClick}>
            <img className="edesseg-child" alt="" src="/rectangle-732@2x.png" />
            <b className="kategria">Diófélék és olajos magvak</b>
          </div>
          <div className="fuszerek" onClick={onFuszerekContainerClick}>
            <img className="edesseg-child" alt="" src="/rectangle-733@2x.png" />
            <b className="kategria">Fűszerek</b>
          </div>
          <div className="gyumolcs" onClick={onGyumolcsContainerClick}>
            <img className="edesseg-child" alt="" src="/rectangle-734@2x.png" />
            <b className="kategria">Gyümölcsök és gyümölcskészítmények</b>
          </div>
          <div className="marha" onClick={onMarhaContainerClick}>
            <img className="edesseg-child" alt="" src="/rectangle-735@2x.png" />
            <b className="kategria">Marha</b>
          </div>
          <div className="szarnyas" onClick={onSzarnyasContainerClick}>
            <img className="edesseg-child" alt="" src="/rectangle-736@2x.png" />
            <b className="kategria">Szárnyasok</b>
          </div>
          <div className="tej" onClick={onTejContainerClick}>
            <img className="edesseg-child" alt="" src="/rectangle-737@2x.png" />
            <b className="kategria">Tejtermékek</b>
          </div>
          <div className="vad" onClick={onVadContainerClick}>
            <img className="edesseg-child" alt="" src="/rectangle-738@2x.png" />
            <b className="kategria">Vad- és egyéb húsok</b>
          </div>
          <div className="barany" onClick={onBaranyContainerClick}>
            <img className="edesseg-child" alt="" src="/rectangle-739@2x.png" />
            <b className="kategria">Bárány</b>
          </div>
          <div className="gabona" onClick={onGabonaContainerClick}>
            <img
              className="edesseg-child"
              alt=""
              src="/rectangle-7310@2x.png"
            />
            <b className="kategria">Gabonatermékek</b>
          </div>
          <div className="halak" onClick={onHalakContainerClick}>
            <img
              className="edesseg-child"
              alt=""
              src="/rectangle-7311@2x.png"
            />
            <b className="kategria">Halak és tenger gyümölcsei</b>
          </div>
          <div className="pekaru" onClick={onPekaruContainerClick}>
            <img
              className="edesseg-child"
              alt=""
              src="/rectangle-7312@2x.png"
            />
            <b className="kategria">Pékáruk</b>
          </div>
          <div className="szoja" onClick={onSzojaContainerClick}>
            <img
              className="edesseg-child"
              alt=""
              src="/rectangle-7313@2x.png"
            />
            <b className="kategria">
              Szójatermékek és növényi tejhelyettesítők
            </b>
          </div>
          <div className="teszta" onClick={onTesztaContainerClick}>
            <img
              className="edesseg-child"
              alt=""
              src="/rectangle-7314@2x.png"
            />
            <b className="kategria">Tészták</b>
          </div>
          <div className="zoldseg" onClick={onZoldsegContainerClick}>
            <img
              className="edesseg-child"
              alt=""
              src="/rectangle-7315@2x.png"
            />
            <b className="kategria">Zöldségek és hüvelyesek</b>
          </div>
          <div className="borju" onClick={onBorjuContainerClick}>
            <img className="edesseg-child" alt="" src="/rectangle-731@2x.png" />
            <b className="kategria">Borjú</b>
          </div>
          <div className="izesito" onClick={onIzesitoContainerClick}>
            <img
              className="edesseg-child"
              alt=""
              src="/rectangle-7316@2x.png"
            />
            <b className="kategria">Ételízesítők és hozzávalók</b>
          </div>
          <div className="gomba" onClick={onGombaContainerClick}>
            <img
              className="edesseg-child"
              alt=""
              src="/rectangle-7317@2x.png"
            />
            <b className="kategria">Gombák</b>
          </div>
          <div
            className="huskeszitmeny"
            onClick={onHuskeszitmenyContainerClick}
          >
            <img
              className="edesseg-child"
              alt=""
              src="/rectangle-7318@2x.png"
            />
            <b className="kategria">Húskészítmények</b>
          </div>
          <div className="sertes" onClick={onSertesContainerClick}>
            <img
              className="edesseg-child"
              alt=""
              src="/rectangle-7319@2x.png"
            />
            <b className="kategria">Sertés</b>
          </div>
          <div className="szoszok" onClick={onSzoszokContainerClick}>
            <img
              className="edesseg-child"
              alt=""
              src="/rectangle-7320@2x.png"
            />
            <b className="kategria">Szószok, öntetek, krémek</b>
          </div>
          <div className="tojas" onClick={onTojasContainerClick}>
            <img
              className="edesseg-child"
              alt=""
              src="/rectangle-7321@2x.png"
            />
            <b className="kategria">Tojás</b>
          </div>
          <div className="zsir" onClick={onZsirContainerClick}>
            <img
              className="edesseg-child"
              alt=""
              src="/rectangle-7322@2x.png"
            />
            <b className="kategria">Zsírok és olajok</b>
            
          </div>
        </div>
        <div className="logo-parent4">
          <div className="logo8">
            <div className="foodtime8">
              <b>Food</b>
              <span className="time8">Time</span>
            </div>
          </div>
          <div className="menu7">
            <div className="receptek7" onClick={onReceptekTextClick}>
              Receptek
            </div>
            <div className="kaltab7">Kalóriatáblázat</div>
            <div className="feltoltes8" onClick={onFeltoltesTextClick}>
              Feltöltés
            </div>
          </div>
          <img
            className="instance-child6"
            alt=""
            src="/group-42.svg"
            onClick={onGroupIconClick}
          />
        </div>
      </div>
    </div>
    
  );
};

export default Kaloriatablazatok;
