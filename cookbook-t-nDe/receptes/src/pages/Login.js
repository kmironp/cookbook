import { useCallback,useState,useContext } from "react";
import { useNavigate } from "react-router-dom";
import "./Login.css";
import axios from "axios";
import AuthContext from "../context/AuthProvider";
const Login = () => {
  const {setAuth} = useContext(AuthContext);
  const navigate = useNavigate();


  const onRegisterTextClick = useCallback(() => {
    navigate("/register");
  }, [navigate]);

  const onGroupContainer2Click = useCallback(() => {
    navigate("/receptek");
  }, [navigate]);

  const [emailpw, setEmailpw] = useState({
    email:'',
    password:''
  });

  const handleInputChange = (e) =>{
    const {name, value} = e.target;

    setEmailpw({
      ...emailpw,
      [name] : value

    })
  }

  const onSubmit = async (e) => {
      e.preventDefault();
      console.log(emailpw['email'] + emailpw['password'])
      
      try{ const resp = await axios.post("http://localhost:8081/api/v1/Users/login",
        JSON.stringify({email: emailpw['email'], password: emailpw['password']}),
        {
          headers: {'Content-Type': 'application/json'},
          withCredentials: true
        }
        );
        console.log(JSON.stringify(resp?.data))
        const accesToken = resp?.data?.accesToken;
        setAuth({emailpw,accesToken});

      }catch(err){
          setErrMsg('Login failed.')
      }

      setEmailpw({
        email:'',
        password:''
      })
  }

  return (
    <div className="login">
      <div className="window">
        <div className="window">
          <img
            className="katie-smith-uqs1802d0cq-unspla-icon6"
            alt=""
            src="/katiesmithuqs1802d0cqunsplash-13@2x.png"
          />
          <div className="bgoverlay6" />
        </div>
        <div className="appwindow">
          <div className="mainwindow5" />
         
          <div className="formsection">
            <div className="formbg" />
            <div className="welcome-back-wrapper">
              <div className="welcome-back">Welcome back!</div>
            </div>
            <div className="register-parent">
              <div className="register" onClick={onRegisterTextClick}>
                Register
              </div>
              <div className="login-wrapper">
                <div className="login1">Login</div>
              </div>
            </div>
            
            <form className="formsection-inner" onSubmit={onSubmit}>
              <div className="forminput-parent">
                <div className="forminput1">
                  <div className="formbtn3" />
                  <img className="forminput-item" alt="" src="/vector-11.svg" />
                  <input className="username-or-input3" 
                  type="text"
                  placeholder="Email" 
                  name="email" 
                  value={emailpw['email']} 
                  onChange={handleInputChange}
                  />
                </div>
                <div className="forminput1">
                  <div className="formbtn3" />
                  <img className="forminput-item" alt="" src="/vector-11.svg" />
                  <input className="username-or-input1" 
                  type="password"
                  placeholder="Password" 
                  name="password" 
                  value={emailpw['password']} 
                  onChange={handleInputChange}
                  />
                </div>
              </div>
              <div
              className="standardbutton-wrapper"
              //onClick={onGroupContainer2Click}
              >
                <div className="standardbutton1">
                  <button type="submit" className="formbtn2" >
                  <div className="ok1">Log in</div>
                  </button>
                </div>
              </div>
            </form>
            <div className="logo6">
              <div className="foodtime6">
                <b>Food</b>
                <span className="time6">Time</span>
              </div>
            </div>
          </div>
          <div className="herosection">
            <img className="herobg-icon" alt="" src="/herobg@2x.png" />
          </div>
        </div>
      </div>
    </div>
  );
};

export default Login;
