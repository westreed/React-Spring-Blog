import React, { useState } from 'react';
import {BrowserRouter, Route, Routes} from 'react-router-dom';
import { Container } from 'react-bootstrap';
import Navbars from './pages/navbars';
import Widget from './pages/widget';
import Home from './pages/home';
// import Category from './components/category';
import Footer from './pages/footer';
import Login from './components/login';

const App = () => {
    const [loginModal, setLoginModal] = useState(false);

    return (
        <div className="App">
            <BrowserRouter>
                {loginModal ?
                    <Login
                        show={loginModal}
                        onHide={() => setLoginModal(false)}
                    /> : null
                }
                <Navbars onShow={() => setLoginModal(true)}/>
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
    );
}

export default App;