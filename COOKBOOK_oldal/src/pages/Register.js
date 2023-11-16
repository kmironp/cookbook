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
      <div className="window9">
        <div className="window9">
          <img
            className="katie-smith-uqs1802d0cq-unspla-icon11"
            alt=""
            src="/katiesmithuqs1802d0cqunsplash-12@2x.png"
          />
          <div className="bgoverlay11" />
        </div>
        <div className="appwindow11">
          <div className="mainwindow11" />
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
                <div className="formbtn6" />
                <div className="ok2">Register</div>
              </div>
            </div>
            <div
              className="standardbutton-container"
              onClick={onGroupContainer2Click}
            >
              <div className="standardbutton3">
                <div className="formbtn6" />
                <div className="ok3">Sign up</div>
              </div>
            </div>
            <div className="frame-group">
              <div className="forminput-group">
                <div className="forminput4">
                  <div className="formbtn8" />
                  <img
                    className="forminput-child1"
                    alt=""
                    src="/vector-11.svg"
                  />
                  <div className="username-or-input4">Email</div>
                </div>
                <div className="forminput4">
                  <div className="formbtn8" />
                  <img
                    className="forminput-child1"
                    alt=""
                    src="/vector-11.svg"
                  />
                  <div className="username-or-input4">Username</div>
                </div>
                <div className="forminput4">
                  <div className="formbtn8" />
                  <img
                    className="forminput-child1"
                    alt=""
                    src="/vector-11.svg"
                  />
                  <div className="username-or-input4">Password</div>
                </div>
                <div className="forminput4">
                  <div className="formbtn8" />
                  <img
                    className="forminput-child1"
                    alt=""
                    src="/vector-11.svg"
                  />
                  <div className="username-or-input4">Password again</div>
                </div>
              </div>
              <div className="forminput4">
                <div className="formbtn12" />
                <img className="forminput-child5" alt="" src="/vector-11.svg" />
                <div className="username-or-input4">Choose a profile:</div>
              </div>
            </div>
            <div className="logo12">
              <div className="foodtime12">
                <b>Food</b>
                <span className="time12">Time</span>
              </div>
            </div>
          </div>
          <div className="herosection1">
            <img className="herobg-icon1" alt="" src="/herobg@2x.png" />
          </div>
        </div>
      </div>
      <img className="prof0-icon" alt="" src="/prof0.svg" />
      <img className="prof1-icon5" alt="" src="/prof13.svg" />
      <img className="register-child" alt="" src="/group-4.svg" />
    </div>
  );
};

export default Register;
