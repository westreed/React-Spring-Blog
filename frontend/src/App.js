import React, { useEffect } from 'react';
import { useDispatch } from 'react-redux';
import { setMember } from './store/member';
import Routing from './Routing';
import API from './utils/api';


const App = () => {
    const dispatch = useDispatch();
    
    useEffect(() => {
        const fetchData = async() => {
            const res = await API.getSession();
            if (res === false || res.role === null){
                dispatch(setMember(null));
            }
            else{
                dispatch(setMember(res));
            }
        }
        fetchData();
    })

    return (
        <div className="App">
            <Routing/>
        </div>
    );
}

export default App;