import { useCallback } from "react";
import { useNavigate } from "react-router-dom";
import "./Register.css";

const Register = () => {
  const navigate = useNavigate();

  const onLoginTextClick = useCallback(() => {
    navigate("/login");
  }, [navigate]);

  const onGroupContainer2Click = useCallback(() => {
    navigate("/receptek");
  }, [navigate]);

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
            <div
              className="standardbutton-container"
              onClick={onGroupContainer2Click}
            >
              <div className="standardbutton3">
                <div className="formbtn5" />
                <div className="ok3">Sign up</div>
              </div>
            </div>
            <div className="formsection-child">
              <div className="forminput-group">
                <div className="forminput3">
                  <div className="formbtn7" />
                  <img className="vector-icon" alt="" src="/vector-11.svg" />
                  <div className="username-or-input3">Email</div>
                </div>
                <div className="forminput3">
                  <div className="formbtn7" />
                  <img className="vector-icon" alt="" src="/vector-11.svg" />
                  <div className="username-or-input3">Username</div>
                </div>
                <div className="forminput3">
                  <div className="formbtn7" />
                  <img className="vector-icon" alt="" src="/vector-11.svg" />
                  <div className="username-or-input3">Password</div>
                </div>
                <div className="forminput3">
                  <div className="formbtn7" />
                  <img className="vector-icon" alt="" src="/vector-11.svg" />
                  <div className="username-or-input3">Password again</div>
                </div>
              </div>
            </div>
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
