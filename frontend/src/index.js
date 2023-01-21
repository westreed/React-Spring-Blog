import React from 'react';
import ReactDOM from 'react-dom/client';
import Navbars from './pages/navbars';
import Home from './pages/home';
import Categories from './pages/categories';
import "./styles/common.css";
import 'bootstrap/dist/css/bootstrap.min.css';
import {BrowserRouter, Route, Routes} from 'react-router-dom';
import reportWebVitals from './reportWebVitals';
import { Container } from 'react-bootstrap';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  // <React.StrictMode>
  <div className="App">
        <BrowserRouter>
            <Navbars/>
            <Container>
                <Routes>
                    <Route exact path='/' element={<Home/>}></Route>
                    <Route exact path='/categories' element={<Categories/>}></Route>
                </Routes>
            </Container>
        </BrowserRouter>
  </div>
  // </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
