import {BrowserRouter, Route, Routes} from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux';
import { useEffect, useRef } from 'react';
import { setHeaderRef } from './store/slice/refList';
import Navbars from './pages/navbars';
import Widget from './pages/widget';
import Home from './pages/home';
import Footer from './pages/footer';
import Login from './components/login';
import Settings from './pages/settings';
import Forbidden from './components/forbidden';
import PostList from './pages/postList';
import Post from './pages/post';
import Write from './pages/write';
import Functions from './utils/functions';


const AppRoute = () => {
    const headerRef = useRef(null);
    const dispatch = useDispatch();
    const member = useSelector((state) => state.member.data);

    useEffect(() => {
        dispatch(setHeaderRef(headerRef));
        // eslint-disable-next-line
    }, [headerRef])

    return (
        <BrowserRouter>
            <div ref={headerRef} className='wrapper'>
                <Login/>
                <Navbars/>
                <div className="session mb-5">
                    <div className="Container" style={{display:"flex", flex:1}}>
                        <Widget/>
                        <Routes>
                            <Route exact path='/' element={<Home/>} />
                            <Route exact path='/settings' element={Functions.isAdmin(member) ?<Settings/> : <Forbidden/>}/>
                            <Route exact path='/category' element={<PostList/>}/>
                            <Route exact path='/write' element={<Write/>}/>
                            <Route exact path='/post/:id' element={<Post/>}/>
                        </Routes>
                    </div>
                </div>
            </div>
            <Footer/>
        </BrowserRouter>
    );
}

export default AppRoute;