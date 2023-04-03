export const getToken=()=>{
     const token = localStorage.getItem("token");
     if (!token) return null;
     const payload = JSON.parse(window.atob(token.split(".")[1]));
     if (payload.exp < Date.now() / 1000) {
     // Token has expired - remove it from localStorage
     localStorage.removeItem("token");
     return null;
   }
   return token;
 }

 export const getUserDetails=()=>{
   const token = getToken();
   return token ? JSON.parse(window.atob(token.split(".")[1])) : null;
 }