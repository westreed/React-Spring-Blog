import React, { useCallback, useState, useEffect } from 'react';
import { useDispatch } from 'react-redux';
import { setMember } from './store/member';
import Routing from './Routing';
import API from './utils/api';


const App = () => {
    const dispatch = useDispatch();
    const [, updateState] = useState();
    const forceUpdate = useCallback(() => {
        updateState({});
        console.log("forceUpdate");
    }, []);
    console.log('App');
    
    useEffect(() => {
        const fetchData = async() => {
            const res = await API.getSession();
            if (res === false){
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
            <Routing update={forceUpdate} />
        </div>
    );
}

export default App;