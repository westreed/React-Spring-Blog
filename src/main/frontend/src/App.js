import logo from './logo.svg';
import './App.css';
import axios from 'axios';
import { useEffect, useState } from 'react';

function App() {
    const [test, setTest] = useState('');

    useEffect(() => {
        axios.get('/api/test')
        .then(response => setTest(response.data))
        .catch(error => console.log(error))
    }, []);

    return (
        <div>
            백엔드에서 가져온 데이터 : {test}
        </div>
    )
}

export default App;
