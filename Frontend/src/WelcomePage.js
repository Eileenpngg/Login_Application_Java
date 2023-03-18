import styles from "./welcomepage.module.css";
const WelcomePage = () => {
  return (
    <div class={`${styles.container}`}>
      <img src="/DXC.png" alt="logo" class={`${styles.image}`} />
      <div class={`${styles.welcome}`}>Welcome back , James</div>
      <ul class={`${styles.flexnav}`} data-breakpoint="800">
        <li>
          <a href="#">Home</a>
        </li>
        <li>
          <a href="#">Portofolio</a>
        </li>
        <li>
          <a href="#">Blog</a>
        </li>
        <li>
          <a href="#">About</a>
        </li>
        <li>
          <a href="#">Logout</a>
        </li>
      </ul>
    </div>
  );

  //manager should have a link to a restricted webpage
  //Add logout
};

export default WelcomePage;
