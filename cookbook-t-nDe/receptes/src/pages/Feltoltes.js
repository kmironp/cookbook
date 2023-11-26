import { useCallback, useState } from "react";
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

  const [hozzavalo, setHozza] = useState({
    nev: '',
    menny: '',
    mertegys: '',
  });

  const handleInputChange = (e) => {
    const { name, value } = e.target;

    setHozza({
      ...hozzavalo,
      [name]: value

    })
  }

  const handleOneMoreRecipe = async () => {

  };

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
            <div className="add">
              {/* Add the button here */}
              <button className="add-button" onClick={handleOneMoreRecipe}>+</button>
            </div>
          </div>
          <div className="nyilvnos-parent">
          </div>
          <div className="elkszts">{`Elkészítés: `}</div>
          <div className="recept-neve-parent">
            <div className="recept-neve">Recept neve:</div>
            <div className="recept-neve">Adagok száma:</div>
            <div className="recept-neve">Hozzávalók:</div>
          </div>
          <div className="frame-child1" />
          <div className="frame-child2" />
          <div className="receptnev">
            <input
              className="receptnev-adagszam"
              type="text"
              name="receptnev"
              placeholder="Recept neve"
              // recept nevet menteni
              onChange={handleInputChange}
            />
          </div>
          <div className="adagszam">
            <input
              className="receptnev-adagszam"
              type="number"
              name="adagszam"
              placeholder="Adagok száma"
              // adag szamot menteni
              onChange={handleInputChange}
            />
          </div>
          <div className="hozzavalosor">
            <div className="rectangle-group">
              <div className="group-child" />
              <input
                className="group-child"
                type="text"
                name="Hozzavalo"
                placeholder="Hozzávaló neve"
                value={hozzavalo["hozzavalonev"]}
                onChange={handleInputChange}
              />
            </div>
            <input
              className="mnnysg"
              type="number"
              name="menny"
              placeholder="Mennyiség"
              value={hozzavalo["mennyiseg"]} // legyen number típus
              onChange={handleInputChange}
            />
            <div className="group-inner" />
            <input
              className="mrtg"
              type="text"
              name="mrtg"
              placeholder="Mértékegység"
              value={hozzavalo["mértékegység"]}
              onChange={handleInputChange}
            />
          </div>
          <div className="vector-parent">
            <img className="rectangle-icon" alt="" src="/rectangle-82.svg" />
            <textarea
              className="szoveg"
              name="leiras"
              placeholder="Leírás"
              value={hozzavalo["leiras"]}
              onChange={handleInputChange}
            />

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
    </div >
  );
};

export default Feltoltes;
