import {useState, useEffect} from "react";

const SecretPage=()=>{
useEffect(()=>{
handleLogin()
},[])
async function handleLogin(
    url = "http://127.0.0.1:8080/api/secretPage") {
    const response = await fetch(url, {
      method: "GET",
      headers: {
        "Accept": "application/json",
        "Content-Type": "application/json",
        "Access-Control-Allow-Credentials": "*",
      },
    });
    const jResponse = await response.json();
    return jResponse;
    console.log(jResponse)
  }

return(
<div>
<h1>Employee Detailss</h1>
</div>
)
}

export default SecretPage;