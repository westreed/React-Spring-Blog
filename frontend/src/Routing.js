import {BrowserRouter, Route, Routes} from 'react-router-dom';
import Navbars from './pages/navbars';
import Widget from './pages/widget';
import Home from './pages/home';
import Footer from './pages/footer';
import Login from './components/login';
import Settings from './pages/settings';
import { useSelector } from 'react-redux';
import Forbidden from './components/forbidden';
import PostList from './pages/postList';
import Editor from './components/editor';
import Post from './pages/post';


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
            <div className="session mb-5">
                <div className="Container" style={{display:"flex", flex:1}}>
                    <Widget/>
                    <Routes>
                        <Route exact path='/' element={<Home/>} />
                        <Route exact path='/settings' element={isAdmin(member) ?<Settings/> : <Forbidden/>}/>
                        <Route exact path='/category' element={<PostList/>}/>
                        <Route exact path='/editor' element={<Editor/>}/>
                        <Route exact path='/post/:id' element={<Post/>}/>
                    </Routes>
                </div>
            </div>
            <Footer/>
        </BrowserRouter>
    );
}

export default Routing;