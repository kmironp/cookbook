import { useCallback, useState } from "react";
import { useNavigate } from "react-router-dom";
import "./Feltoltes.css";
import axios from "axios";

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

  const [recept, setRec] = useState({
    id:1,
    name:'',
    servings: 0,
    description: '',
    vegan:false,
    vegetarian:false,
    lactose:false,
    gluten:false,
    hoznev: '',
    hozmenny: 0,
    hozmertegys: '',
    
  });

  const handleInputChange = (e) => {
    const { name, value } = e.target;

    setRec({
      ...recept,
      [name]: value

    })
  }

  const AddRec = (rec) => {
    axios.post("http://localhost:8081/api/v1/Recipe/saverec", rec)
     
    }

  const onsubmit = (e) =>{
    e.preventDefault();
      AddRec(recept);
      setRec({
        'id':recept['id']+1,
        'name':'',
        'servings': 0,
        'hoznev': '',
        'hozmenny': 0,
        'hozmertegys': '',
        'description': ''
      })
      console.log(recept)
    
  }

  var ingcounter = 1;
  const handleOneMoreRecipe = async () => {
    ingcounter++;
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
          <form onSubmit={onsubmit}> 
            <div className="receptnev">
              <input
                className="receptnev-adagszam"
                type="text"
                name="name"
                placeholder="Recept neve"
                // recept nevet menteni
                value={recept["name"]}

                onChange={handleInputChange}
              />
            </div>
            <div className="adagszam">
              <input
                className="receptnev-adagszam"
                type="number"
                name="servings"
                placeholder="Adagok száma"
                // adag szamot menteni
                value={recept["servings"]}

                onChange={handleInputChange}
              />
            </div>
               <div className="hozzavalosor">
              <div className="rectangle-group">
                <div className="group-child" />
                <input
                  className="group-child"
                  type="text"
                  name="hoznev"
                  placeholder="Hozzávaló neve"
                  value={recept["hoznev"]}
                  onChange={handleInputChange}
                />
              </div>
              <input
                className="mnnysg"
                type="number"
                name="hozmenny"
                placeholder="Mennyiség"
                value={recept["hozmenny"]} // legyen number típus
                onChange={handleInputChange}
              />
              <div className="group-inner" />
              <input
                className="mrtg"
                type="text"
                name="hozmertegys"
                placeholder="Mértékegység"
                value={recept["hozmertegys"]}
                onChange={handleInputChange}
              />
            </div>
            <div className="vector-parent">
              <img className="rectangle-icon" alt="" src="/rectangle-82.svg" />
              <textarea
                className="szoveg"
                name="description"
                placeholder="Leírás"
                value={recept["description"]}
                onChange={handleInputChange}
              />

            </div>
            <button className="feltlts-wrapper" type="submit">
              <div className="feltlts">Feltöltés</div>
            </button>
          </form>
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
