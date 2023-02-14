import {BrowserRouter, Route, Routes} from 'react-router-dom';
import { Container } from 'react-bootstrap';
import Navbars from './pages/navbars';
import Widget from './pages/widget';
import Home from './pages/home';
import Footer from './pages/footer';
import Login from './components/login';
import Settings from './pages/settings';
import { useSelector } from 'react-redux';
import Forbidden from './components/forbidden';


const Routing = () => {
    const member = useSelector((state) => state.member.data);

    const isAdmin = (member) => {
        if (member != null && member.role === 'admin'){
            return true;
        }
        return false;
    }

    return (
        <BrowserRouter>
            <Login/>
            <Navbars/>
            <Container>
                <div style={{display:"flex", flexDirection:"row"}}>
                    <Widget/>
                    <Routes>
                        <Route exact path='/' element={<Home/>} />
                        <Route exact path='/settings' element={isAdmin(member) ?<Settings/> : <Forbidden/>}/>
                    </Routes>
                </div>
            </Container>
            <Footer/>
        </BrowserRouter>
    );
}

export default Routing;