import React from "react";
import styles from "./login.module.css";
const Login = () => {
  return (
    <>

      <body class={`${styles.loginPage}`}>
        <div class={`${styles.login}`}>
        <img src='/DXC.png' alt='logo'/>
          <input class={`${styles.inputBox}`} placeholder="email" type='text'></input>
          <input class={`${styles.inputBox}`} placeholder="password" type='password'></input>
          <button class={`${styles.loginButton}`}>Login</button>
          Dont have an account? <a href="/"> Sign Up</a>
        </div>
      </body>
    </>
  );
};

export default Login;
