import React from "react";
import {useState} from "react";
import styles from "./login.module.css";
import {useNavigate} from "react-router-dom";

const Login = () => {
const [username, setUsername] = useState("")
const [password, setPassword] = useState("")

const navigate= useNavigate();
async function handleLogin(
    url = "http://127.0.0.1:8080/api/users/auth/authenticate",
    data = {"username":username,
            "password":password
            },
  ) {
  console.log(data);
    const response = await fetch(url, {
      method: "POST",
      headers: {
        "Accept": "application/json",
        "Content-Type": "application/json",
        "Access-Control-Allow-Credentials": "*",
      },
      body: JSON.stringify(data),
    },);
    const jResponse = await response.json();

    if (jResponse.token==="wrong") {
        alert(`Invalid username/password`);
    } else {
    localStorage.setItem("token", jResponse.token)
    }
    return jResponse;
  }

  return (
    <>
      <body class={`${styles.loginPage}`}>
        <div class={`${styles.login}`}>
        <img src='/DXC.png' alt='logo'/>
          <input class={`${styles.inputBox}`} placeholder="username" type='text' value={username} onChange={(e)=> setUsername(e.target.value)}></input>
          <input class={`${styles.inputBox}`} placeholder="password" type='password' value={password} onChange={(e)=> setPassword(e.target.value)}></input>
          <button class={`${styles.loginButton}`} onClick={()=> handleLogin()}>Login</button>
          Dont have an account? <a href="/"> Sign Up</a>
        </div>
      </body>
    </>
  );
};

export default Login;




















