import React, { useEffect } from 'react';
import { useDispatch } from 'react-redux';
import { setMember } from './store/slice/member';
import Routing from './Routing';
import API from './utils/api';


const App = () => {
    const dispatch = useDispatch();
    
    useEffect(() => {
        const fetchData = async() => {
            let res = await API.getSession();
            if (res.role === null){res = null;}
            dispatch(setMember(res));
        }
        fetchData();
        // eslint-disable-next-line
    }, [])

    return (
        <div className="App">
            <Routing/>
        </div>
    );
}

export default App;