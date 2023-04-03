import React from "react"
import {useState, useEffect} from "react";
import { Route, Routes } from "react-router-dom";
import logo from './logo.svg';
import './App.css';

import {getToken, getUserDetails} from "./UserServices"

import Login from './Login';
import WelcomePage from './WelcomePage';
import SecretPage from './SecretPage'
import Unauthorized from './Unauthorized'
import Calendar from './pages/calendar/Calendar'
import {useNavigate} from "react-router-dom";


function App() {
const [isAuthenticated, setIsAuthenticated]= useState(false)
const [isManager, setIsManager] = useState(false)
const navigate= useNavigate();

useEffect(()=>{
          getToken()? setIsAuthenticated(true): setIsAuthenticated(false)
          });

useEffect(()=>{
            getUserDetails()?.Authorities[0].authority=="MANAGER"? setIsManager(true): setIsManager(false)
          },[isAuthenticated]);

  return (
  <>
  <Routes>
    <Route path="/" element={isAuthenticated ? <WelcomePage/> : <Login/>}/>
    <Route path="/secretPage" element={isManager ? <SecretPage/>: <Unauthorized/>}/>
    <Route path="/home" element={<WelcomePage/>}/>
    <Route path="/login" element={<Login/>}/>
    <Route path="/Calendar" element={<Calendar/>}/>
  </Routes>
    </>
  );
}

export default App;
