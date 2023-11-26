import { useEffect } from "react";
import {
  Routes,
  Route,
  useNavigationType,
  useLocation,
} from "react-router-dom";
import Changepw from "./pages/Changepw";
import Feltoltes from "./pages/Feltoltes";
import Feltoltottreceptek from "./pages/Feltoltottreceptek";
import Kedvencreceptek from "./pages/Kedvencreceptek";
import Recept from "./pages/Recept";
import Tablazat from "./pages/Tablazat";
import Login from "./pages/Login";
import Userpage from "./pages/Userpage";
import Kaloriatablazatok from "./pages/Kaloriatablazatok";
import Receptek from "./pages/Receptek";
import Register from "./pages/Register";
import Accessories from "./pages/Accessories";

function App() {
  const action = useNavigationType();
  const location = useLocation();
  const pathname = location.pathname;

  useEffect(() => {
    if (action !== "POP") {
      window.scrollTo(0, 0);
    }
  }, [action, pathname]);

  useEffect(() => {
    let title = "";
    let metaDescription = "";

    switch (pathname) {
      case "/":
        title = "";
        metaDescription = "";
        break;
      case "/feltoltes":
        title = "";
        metaDescription = "";
        break;
      case "/feltoltottreceptek":
        title = "";
        metaDescription = "";
        break;
      case "/kedvencreceptek":
        title = "";
        metaDescription = "";
        break;
      case "/recept":
        title = "";
        metaDescription = "";
        break;
      case "/tablazat":
        title = "";
        metaDescription = "";
        break;
      case "/login":
        title = "";
        metaDescription = "";
        break;
      case "/userpage":
        title = "";
        metaDescription = "";
        break;
      case "/kaloriatablazatok":
        title = "";
        metaDescription = "";
        break;
      case "/receptek":
        title = "";
        metaDescription = "";
        break;
      case "/register":
        title = "";
        metaDescription = "";
        break;
      case "/accessories":
        title = "";
        metaDescription = "";
        break;
    }

    if (title) {
      document.title = title;
    }

    if (metaDescription) {
      const metaDescriptionTag = document.querySelector(
        'head > meta[name="description"]'
      );
      if (metaDescriptionTag) {
        metaDescriptionTag.content = metaDescription;
      }
    }
  }, [pathname]);

  return (
    <Routes>
      <Route path="/Changepw" element={<Changepw />} />
      <Route path="/feltoltes" element={<Feltoltes />} />
      <Route path="/feltoltottreceptek" element={<Feltoltottreceptek />} /> 
      <Route path="/kedvencreceptek" element={<Kedvencreceptek />} />
      <Route path="/recept" element={<Recept />} />
      <Route path="/tablazat" element={<Tablazat />} />
      <Route path="/" element={<Login />} />
      <Route path="/userpage" element={<Userpage />} />
      <Route path="/kaloriatablazatok" element={<Kaloriatablazatok />} />
      <Route path="/receptek" element={<Receptek />} />
      <Route path="/register" element={<Register />} />
      <Route path="/accessories" element={<Accessories />} />
    </Routes>
  );
}
export default App;

// accessories nem kell hozzányúlni ámen 