import { useCallback, useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
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

  const onGroupIconClick = useCallback(() => {
    navigate("/userpage");
  }, [navigate]);


  const [Tablazatertekek,setTablazat] = useState([])
  

  const getTablazatertekek = () => {
    axios.get('http://localhost:8081/api/v1/CaloryTable/listallwithoutcat')
    .then(response => setTablazat(response.data))
  }
  
  useEffect(() => {
    getTablazatertekek();
    
  },[])
  
  var elem = Tablazatertekek[0]
  return (
    <div className="tablazat">
      <div className="deskbg5">
        <img
          className="katie-smith-uqs1802d0cq-unspla-icon5"
          alt=""
          src="/katiesmithuqs1802d0cqunsplash-11@2x.png"
        />
        <div className="bgoverlay5" />
      </div>
      <div className="tablazat-inner">
        <div className="mainwindow-parent2">
          <div className="mainwindow4" />
          <div className="frame-child6" />
          <table>
            <tbody>
            {Tablazatertekek.map(ertek=>(
              <tr className="row">
                  <td className="oszlop1">{ertek.name}</td>
                  <td className="oszlop2">{ertek.energy}</td>
                  <td className="oszlop3">{ertek.protein}</td>
                  <td className="oszlop4">{ertek.fat}</td>
                  <td className="oszlop5">{ertek.carbohydrate}</td>
                  <td className="oszlop6">{ertek.gi}</td>
              </tr>
              ))}
            </tbody>  
          </table>
          <div className="fejlc">
            <div className="alapanyag-100-gml-wrapper">
              <div className="alapanyag-100-gml-container">
                <p className="gml">Alapanyag</p>
                <p className="gml">(100 g/ml)</p>
              </div>
            </div>
            <div className="energia-wrapper">
              <div className="energia">Energia (kcal)</div>
            </div>
            <div className="fehrje-g-wrapper">
              <div className="alapanyag-100-gml-container">
                <p className="gml">Fehérje</p>
                <p className="gml">(g)</p>
              </div>
            </div>
            <div className="zsr-g-wrapper">
              <div className="alapanyag-100-gml-container">
                <p className="gml">Zsír</p>
                <p className="gml">(g)</p>
              </div>
            </div>
            <div className="fejlc-inner">
              <div className="sznhidrt-g-wrapper">
                <div className="alapanyag-100-gml-container">
                  <p className="gml">Szénhidrát</p>
                  <p className="gml">(g)</p>
                </div>
              </div>
            </div>
            <div className="gi-wrapper">
              <div className="alapanyag-100-gml-container">GI</div>
            </div>
            <div className="kategria-nv-wrapper">
              <div className="kategria-nv">kategóriaizé</div>
            </div>
          </div>
          <div className="logo-parent3">
            <div className="logo5">
              <div className="foodtime5">
                <b>Food</b>
                <span className="time5">Time</span>
              </div>
            </div>
            <div className="menu5">
              <div className="receptek5" onClick={onReceptekTextClick}>
                Receptek
              </div>
              <div className="kaltab5" onClick={onKaltabTextClick}>
                Kalóriatáblázat
              </div>
              <div className="feltoltes6" onClick={onFeltoltesTextClick}>
                Feltöltés
              </div>
            </div>
            <img
              className="instance-child2"
              alt=""
              src="/group-42.svg"
              onClick={onGroupIconClick}
            />
          </div>
        </div>
      </div>
    </div>
  );
};

export default Tablazat;
