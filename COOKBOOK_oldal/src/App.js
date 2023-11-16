import { useEffect } from "react";
import {
  Routes,
  Route,
  useNavigationType,
  useLocation,
} from "react-router-dom";
import Changepw from "./pages/Changepw";
import Userpage from "./pages/Userpage";
import Recept from "./pages/Recept";
import Feltoltes from "./pages/Feltoltes";
import Receptek from "./pages/Receptek";
import Kedvencreceptek from "./pages/Kedvencreceptek";
import Kaloriatablazatok from "./pages/Kaloriatablazatok";
import Tablazat from "./pages/Tablazat";
import Feltoltottreceptek from "./pages/Feltoltottreceptek";
import Login from "./pages/Login";
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
      case "/userpage":
        title = "";
        metaDescription = "";
        break;
      case "/recept":
        title = "";
        metaDescription = "";
        break;
      case "/feltoltes":
        title = "";
        metaDescription = "";
        break;
      case "/receptek":
        title = "";
        metaDescription = "";
        break;
      case "/kedvencreceptek":
        title = "";
        metaDescription = "";
        break;
      case "/kaloriatablazatok":
        title = "";
        metaDescription = "";
        break;
      case "/tablazat":
        title = "";
        metaDescription = "";
        break;
      case "/feltoltottreceptek":
        title = "";
        metaDescription = "";
        break;
      case "/login":
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
      <Route path="/" element={<Changepw />} />
      <Route path="/userpage" element={<Userpage />} />
      <Route path="/recept" element={<Recept />} />
      <Route path="/feltoltes" element={<Feltoltes />} />
      <Route path="/receptek" element={<Receptek />} />
      <Route path="/kedvencreceptek" element={<Kedvencreceptek />} />
      <Route path="/kaloriatablazatok" element={<Kaloriatablazatok />} />
      <Route path="/tablazat" element={<Tablazat />} />
      <Route path="/feltoltottreceptek" element={<Feltoltottreceptek />} />
      <Route path="/login" element={<Login />} />
      <Route path="/register" element={<Register />} />
      <Route path="/accessories" element={<Accessories />} />
    </Routes>
  );
}
export default App;
