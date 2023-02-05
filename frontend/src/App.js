import React, { useCallback, useState } from 'react';
import {BrowserRouter, Route, Routes} from 'react-router-dom';
import { Container } from 'react-bootstrap';
import Navbars from './pages/navbars';
import Widget from './pages/widget';
import Home from './pages/home';
// import Category from './components/category';
import Footer from './pages/footer';
import Login from './components/login';
import Settings from './pages/settings';
import Session from './utils/session';

const App = () => {
    const [, updateState] = useState();
    const forceUpdate = useCallback(() => {
        updateState({});
        console.log("forceUpdate");
    }, []);
    console.log('App');

    return (
        <div className="App">
            <BrowserRouter>
                <Session/>
                <Login update={forceUpdate}/>
                <Navbars update={forceUpdate}/>
                <Container>
                    <div style={{display:"flex", flexDirection:"row"}}>
                        <Widget/>
                        <Routes>
                            <Route exact path='/' element={<Home/>}></Route>
                            <Route exact path='/settings' element={<Settings/>}></Route>
                        </Routes>
                    </div>
                </Container>
                <Footer/>
            </BrowserRouter>
        </div>
    );
}

export default App;