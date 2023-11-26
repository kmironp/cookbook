import { useCallback } from "react";
import { useNavigate } from "react-router-dom";
import "./Userpage.css";

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

const Userpage = () => {
  const navigate = useNavigate();

  const onFrameContainer2Click = useCallback(() => {
    navigate("/feltoltottreceptek");
  }, [navigate]);

  const onFrameContainer5Click = useCallback(() => {
    navigate("/Changepw");
  }, [navigate]);

  const onReceptekTextClick = useCallback(() => {
    navigate("/receptek");
  }, [navigate]);

  const onKaltabTextClick = useCallback(() => {
    navigate("/kaloriatablazatok");
  }, [navigate]);

  const onFeltoltesTextClick = useCallback(() => {
    navigate("/feltoltes");
  }, [navigate]);

  return (
    <div className="userpage">
      <div className="deskbg7">
        <img
          className="katie-smith-uqs1802d0cq-unspla-icon7"
          alt=""
          src="/katiesmithuqs1802d0cqunsplash-14@2x.png"
        />
        <div className="bgoverlay7" />
      </div>
      <div className="appwindow1">
        <div className="mainwindow-parent3">
          <div className="mainwindow6" />
          <div className="frame-child7" />
          <div className="felhasznlsfelulet1">
            <div className="felhasznlsfelulet-item" />
            <div className="felhasznlnv-group">
              <div className="felhasznlnv1">felhasználónév</div>
              <div className="e-mail-cm1">e-mail cím</div>
              {/*<div className="felhasznlnv1">{username}</div>    !!!!!!!!!!!???????????    valahogy úgy mint a change pwbe de se az igazi
              <div className="e-mail-cm1">{email}</div>               !!!!!!!!!!!!!!!???????????? */}
            </div>
          </div>
          <div className="frame-child8" />
          <div className="instance-parent">
            <div className="rectangle-parent2">
              <img
                className="instance-child3"
                alt=""
                src="/rectangle-72@2x.png"
              />
              <div className="kedvenc-receptek">Kedvenc receptek</div>
            </div>
            <div className="rectangle-parent3" onClick={onFrameContainer2Click}>
              <img
                className="instance-child3"
                alt=""
                src="/rectangle-721@2x.png"
              />
              <div className="kedvenc-receptek">Feltöltött receptek</div>
            </div>
          </div>
          <div className="instance-wrapper" onClick={onFrameContainer5Click}>
            <div className="rectangle-parent4">
              <img
                className="instance-child3"
                alt=""
                src="/rectangle-722@2x.png"
              />
              <div className="kedvenc-receptek">Jelszó módosítás</div>
            </div>
          </div>
          <div className="menu6">
            <div className="receptek6" onClick={onReceptekTextClick}>
              Receptek
            </div>
            <div className="kaltab6" onClick={onKaltabTextClick}>
              Kalóriatáblázat
            </div>
            <div className="feltoltes7" onClick={onFeltoltesTextClick}>
              Feltöltés
            </div>
          </div>
          <div className="logo7">
            <div className="foodtime7">
              <b>Food</b>
              <span className="time7">Time</span>
            </div>
          </div>
          <img className="frame-child9" alt="" src="/group-4.svg" />
        </div>
      </div>
    </div>
  );
};

export default Userpage;
