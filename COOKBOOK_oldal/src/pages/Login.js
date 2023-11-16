import { useCallback } from "react";
import { useNavigate } from "react-router-dom";
import "./Login.css";

const Login = () => {
  const navigate = useNavigate();

  const onRegisterTextClick = useCallback(() => {
    navigate("/register");
  }, [navigate]);

  const onGroupContainer2Click = useCallback(() => {
    navigate("/receptek");
  }, [navigate]);

  return (
    <div className="login">
      <div className="window8">
        <div className="window8">
          <img
            className="katie-smith-uqs1802d0cq-unspla-icon10"
            alt=""
            src="/katiesmithuqs1802d0cqunsplash-12@2x.png"
          />
          <div className="bgoverlay10" />
        </div>
        <div className="appwindow10">
          <div className="mainwindow10" />
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
            <div
              className="standardbutton-wrapper"
              onClick={onGroupContainer2Click}
            >
              <div className="standardbutton1">
                <div className="formbtn2" />
                <div className="ok1">Log in</div>
              </div>
            </div>
            <div className="frame-parent">
              <div className="forminput-parent">
                <div className="forminput1">
                  <div className="formbtn3" />
                  <img className="forminput-item" alt="" src="/vector-11.svg" />
                  <div className="username-or-input1">Email</div>
                </div>
                <div className="forminput1">
                  <div className="formbtn3" />
                  <img className="forminput-item" alt="" src="/vector-11.svg" />
                  <div className="username-or-input1">Password</div>
                </div>
              </div>
              <div className="forminput1">
                <div className="formbtn5" />
                <img className="vector-icon" alt="" src="/vector-11.svg" />
                <div className="username-or-input3">Choose a profile:</div>
              </div>
            </div>
            <div className="logo11">
              <div className="foodtime11">
                <b>Food</b>
                <span className="time11">Time</span>
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
