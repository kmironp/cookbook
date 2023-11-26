import React, { useState, useCallback } from "react";
import { useNavigate } from "react-router-dom";
import "./Changepw.css";

const Changepw = () => {
  const navigate = useNavigate();
  const [oldPassword, setOldPassword] = useState("");
  const [newPassword, setNewPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");
  const [username, setUsername] = useState("");
  const [email, setEmail] = useState("");
/*
  useEffect(() => {
    // Fetch user data when the component mounts
    const fetchUserData = async () => {
      try {
        const usernameResponse = await fetch("/api/currentUser/getusername");
        const emailResponse = await fetch("/api/currentUser/getemail");

        if (usernameResponse.ok && emailResponse.ok) {
          const usernameData = await usernameResponse.json();
          const emailData = await emailResponse.json();

          setUsername(usernameData.username);
          setEmail(emailData.email);
        } else {
          console.error("Failed to fetch user data");
        }
      } catch (error) {
        console.error("Error occurred while fetching user data:", error);
      }
    };

    fetchUserData();
  }, []); // Run only once when the component mounts
*/
  const onReceptekTextClick = useCallback(() => {
    navigate("/receptek");
  }, [navigate]);

  const onKaltabTextClick = useCallback(() => {
    navigate("/kaloriatablazatok");
  }, [navigate]);

  const onFeltoltesTextClick = useCallback(() => {
    navigate("/feltoltes");
  }, [navigate]);

  const handlePasswordChange = async () => {
    // Validate passwords
    if (newPassword !== confirmPassword) {
      console.error("New password and confirm password do not match");
      // You can show an error message to the user
      return;
    }

    // Simulate sending a request to change the password
    try {
      const response = await fetch("???????????????!!!!!!!!!!!!!!!!!!!!!!!!!!", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
          // Include any authentication headers if required
        },
        body: JSON.stringify({
          oldPassword,
          newPassword,
        }),
      });

      if (response.ok) {
        console.log("Password changed successfully");
        // Optionally, you can redirect the user to a success page or perform other actions
        // Some update method????????!!!!!!!!!!!!!!!!!!!!!!
      } else {
        console.error("Failed to change password");
        // Handle the error, show an error message to the user, etc.
      }
    } catch (error) {
      console.error("Error occurred while changing password:", error);
      // Handle the error, show an error message to the user, etc.
    }
  };


  return (
    <div className="changepw">
      <div className="deskbg">
        <img
          className="katie-smith-uqs1802d0cq-unspla-icon"
          alt=""
          src="/katiesmithuqs1802d0cqunsplash-1@2x.png"
        />
        <div className="bgoverlay" />
      </div>
      <div className="mainwindow-parent">
        <div className="mainwindow" />
        <div className="frame-child" />
        <div className="felhasznlsfelulet">
          <div className="felhasznlsfelulet-child" />
          <div className="felhasznlnv-parent">
            <div className="felhasznlnv">{username}</div>         {/* !!!!!!!!!!!??????????? */}
            <div className="e-mail-cm">{email}</div>              {/* !!!!!!!!!!!!!!!???????????? */}
          </div>
        </div>
        <img className="frame-item" alt="" src="/group-4.svg" />
        <div className="component-331">
          <div className="component-33-item" />
          <input
            className="form-control"
            type="password"
            placeholder="Régi jelszó"
            value={oldPassword}
            onChange={(e) => setOldPassword(e.target.value)}
          />
        </div>
        <div className="component-35">
          <div className="component-33-item" />
          <input
            className="form-control"
            type="password"
            placeholder="Új jelszó még egyszer"
            value={confirmPassword}
            onChange={(e) => setConfirmPassword(e.target.value)}
          />
        </div>
        <div className="component-34">
          <div className="component-33-item" />
          <input
            className="form-control"
            type="password"
            placeholder="Új jelszó"
            value={newPassword}
            onChange={(e) => setNewPassword(e.target.value)}
          />
        </div>
        <div className="component-36">
          {/* Add the button here */}
          <button className="change-password-button" onClick={handlePasswordChange}>Change Password</button>
        </div>
        <div className="logo-parent">
          <div className="logo">
            <div className="foodtime">
              <b>Food</b>
              <span className="time">Time</span>
            </div>
          </div>
          <div className="menu">
            <div className="receptek" onClick={onReceptekTextClick}>
              Receptek
            </div>
            <div className="kaltab" onClick={onKaltabTextClick}>
              Kalóriatáblázat
            </div>
            <div className="feltoltes" onClick={onFeltoltesTextClick}>
              Feltöltés
            </div>
          </div>
          <img className="instance-child" alt="" src="/group-41.svg" />
        </div>
      </div>
    </div>
  );
};

export default Changepw;
