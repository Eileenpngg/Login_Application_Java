import { Link } from "react-router-dom";
import styles from "./welcomepage.module.css";
import {getToken, getUserDetails} from "./UserServices"
import Fade from 'react-reveal/Fade'

const WelcomePage = () => {
    const userDetails= getToken()? JSON.parse(window.atob(getToken()?.split(".")[1])): ""
  return (
  <>
    <div class={`${styles.container}`}>
      <img src="/DXC.png" alt="logo" class={`${styles.logo}`} />
      <div class={`${styles.welcome}`}>Welcome back , {userDetails.sub}</div>
      {}
      <ul class={`${styles.flexnav}`} data-breakpoint="800">
        <li>
          <Link to="/">Home</Link>
        </li>
        <li>
          <Link to="/Calendar">Calendar</Link>
        </li>
        {userDetails.Authorities[0]?.authority=="MANAGER"?
        <li>
          <Link to="/SecretPage">View Employees</Link>
        </li>
          : ""}
        <li>
          <a href="#">Logout</a>
        </li>
      </ul>
    </div>
    <div class={`${styles.row1}`}>
    <Fade top>
      <img src="/Technology.jpeg" class={`${styles.image1}`} width={800} height={400} style={{margin: "100px 100px 50px", boxShadow: "5px 5px 5px 5px #041E42"}}/>
    </Fade>
      <h1>Working Calendar</h1>
     <button class={`${styles.button50}`} role="button">Calendar</button>
    </div>


    <div class={`${styles.row2}`}>
    <Fade top>
      <img src="/HandShake.jpeg" class={`${styles.image}`} width={700} height={400} style={{margin:"10px 100px 50px" ,boxShadow: "5px 5px 5px 5px #B0C4DE	"}}/>
     </Fade>
      <div class={`${styles.row1}`}>
      <h1 class={`${styles.h1}`}>Find out the latest tech news</h1>
      <h2 class={`${styles.h2}`}>Keep yourself updated as an employee. Discover the latest tech news from over the globe. Click below to find out more.</h2>
     <button class={`${styles.button50}`} role="button">Click for more</button>
      </div>
   </div>



   <div class={`${styles.row3}`}>
     <Fade top>
       <img src="/ThinkingRobot.jpeg" class={`${styles.image}`} width={800} height={400} style={{margin:"10px 100px 50px", boxShadow: "5px 5px 5px 5px #041E42"}}/>
     </Fade>
     <div class={`${styles.row1}`}>
     <h1 class={`${styles.h1}`}>Sign up for courses</h1>
     <h2 class={`${styles.h2}`}>Become a better version of you. Sign up for courses subsidised by DXC technology and gain a competitive edge with the latest skills. </h2>
     <button class={`${styles.button50}`} role="button">View courses</button>
     </div>
   </div>

    </>

  );

  //manager should have a link to a restricted webpage
  //Add logout
};

export default WelcomePage;


