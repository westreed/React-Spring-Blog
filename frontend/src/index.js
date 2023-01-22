import React from 'react';
import ReactDOM from 'react-dom/client';
import "./styles/common.css";
import "./styles/font.css";
import 'bootstrap/dist/css/bootstrap.min.css';
import {BrowserRouter, Route, Routes} from 'react-router-dom';
import reportWebVitals from './reportWebVitals';
import { Container } from 'react-bootstrap';
import Navbars from './pages/navbars';
import Widget from './pages/widget';
import Home from './pages/home';
// import Category from './components/category';
import Footer from './pages/footer';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  // <React.StrictMode>
    <div className="App">
        <BrowserRouter>
            <Navbars/>
            <Container>
                <div style={{display:"flex", flexDirection:"row"}}>
                    <Widget/>
                    <Routes>
                        <Route exact path='/' element={<Home/>}></Route>
                    </Routes>
                </div>
            </Container>
            <Footer/>
        </BrowserRouter>
    </div>
  // </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
