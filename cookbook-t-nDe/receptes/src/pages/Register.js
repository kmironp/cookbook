import { useCallback,useState } from "react";
import { useNavigate } from "react-router-dom";

import "./Register.css";
import axios from "axios";
import { Button } from "bootstrap";

const Register = () => {
  const navigate = useNavigate();

  const onLoginTextClick = useCallback(() => {
    navigate("/");
  }, [navigate]);

  const onGroupContainer2Click = useCallback(() => {
    navigate("/receptek");
  }, [navigate]);

  const [user, setUser] = useState({
    email:'',
    username:'',
    password:'',
  });

  const [pwconfirm,setPwcon] = useState({
    pwagain:''
  })
 

  const handleInputChange = (e) =>{
    const {name, value} = e.target;

    setUser({
      ...user,
      [name] : value

    })

    setPwcon({
      ...pwconfirm,
      [name] : value
    })
  }

  const AddUser = (user) => {
  axios.post("http://localhost:8081/api/v1/Users/userregister", user).then(console.log("Hozzáadva"))
   
  }


  const onSubmit = (e) =>{
    e.preventDefault();
    if(user["password"] === pwconfirm["pwagain"])
    {
      AddUser(user);
      setUser({
        'email':'',
        'username':'',
        'password':''
      })
      setPwcon({
        'pwagain':''
      })
      onLoginTextClick()
    }else(console.log("Pw nem egyezik!"))
  }

  return (
    <div className="register1">
      <div className="window1">
        <div className="window1">
          <img
            className="katie-smith-uqs1802d0cq-unspla-icon10"
            alt=""
            src="/katiesmithuqs1802d0cqunsplash-13@2x.png"
          />
          <div className="bgoverlay10" />
        </div>
        <div className="appwindow2">
          <div className="mainwindow9" />
          <div className="formsection1">
            <div className="formbg1" />
            <div className="create-an-account-wrapper">
              <div className="create-an-account">Create an account</div>
            </div>
            <div className="login-parent">
              <div className="login2" onClick={onLoginTextClick}>
                Login
              </div>
              <div className="standardbutton2">
                <div className="formbtn5" />
                <div className="ok2">Register</div>
              </div>
            </div>
            
            <form className="formsection-child" onSubmit={onSubmit}>
              <div className="forminput-group">
                <div className="forminput3">
                  <div className="formbtn7" />
                  <img className="vector-icon" alt="" src="/vector-11.svg" />
                  
                  <input className="username-or-input3" 
                  type="text"
                  placeholder="Email" 
                  name="email" 
                  value={user['email']} 
                  onChange={handleInputChange}
                  />
                </div>
                <div className="forminput3">
                  <div className="formbtn7" />
                  <img className="vector-icon" alt="" src="/vector-11.svg" />
                  <input className="username-or-input3" 
                  type="text"
                  placeholder="Felhasználónév"
                  name="username" 
                  value={user['username']} 
                  onChange={handleInputChange}
                  />
                </div>
                <div className="forminput3">
                  <div className="formbtn7" />
                  <img className="vector-icon" alt="" src="/vector-11.svg" />
                  <input className="username-or-input3" 
                  type="password"
                  placeholder="Jelszó" 
                  name="password" 
                  value={user['password']} 
                  onChange={handleInputChange}
                  />
                </div>
                <div className="forminput3">
                  <div className="formbtn7" />
                  <img className="vector-icon" alt="" src="/vector-11.svg" />
                  
                  <input className="username-or-input3" 
                  type="password"
                  placeholder="Jelszó újra" 
                  name="pwagain" 
                  value={pwconfirm['pwagain']} 
                  onChange={handleInputChange}
                  />
                </div>
                <button 
                  className="standardbutton-container">
                  <div className="standardbutton3">
                    <div className="formbtn5" />
                    <div className="ok3">Sign up</div>
                  </div>
                </button>
              </div>
            </form>
            <div className="logo10">
              <div className="foodtime10">
                <b>Food</b>
                <span className="time10">Time</span>
              </div>
            </div>
          </div>
          <div className="herosection1">
            <img className="herobg-icon1" alt="" src="/herobg@2x.png" />
          </div>
        </div>
      </div>
    </div>
  );
};

export default Register;
