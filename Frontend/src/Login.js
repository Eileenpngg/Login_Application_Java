import React from "react";
import styles from "./login.module.css";
const Login = () => {
  function handleLogin(){
//      url = "http://127.0.0.1:8080/api/users/login",
//      data = loginDetails,
//    }) {
//      const response = await fetch(url, {
//        method: "POST",
//        headers: {
//          Accept: "application/json",
//          "Content-Type": "application/json",
//          "Access-Control-Allow-Credentials": "*",
//        },
//        body: JSON.stringify(data),
//      },);
//      const jResponse = await response.json();
//      console.log(jResponse);
//      if (response.status === 401) {
//        alert(`Invalid username/password: ${jResponse.message}`);
//      }
//      return jResponse;
    }
  return (
    <>

      <body class={`${styles.loginPage}`}>
        <div class={`${styles.login}`}>
        <img src='/DXC.png' alt='logo'/>
          <input class={`${styles.inputBox}`} placeholder="email" type='text'></input>
          <input class={`${styles.inputBox}`} placeholder="password" type='password'></input>
          <button class={`${styles.loginButton}`} onClick={()=> handleLogin()}>Login</button>
          Dont have an account? <a href="/"> Sign Up</a>
        </div>
      </body>
    </>
  );
};

export default Login;
