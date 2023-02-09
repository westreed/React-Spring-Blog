import axios from "axios";

const API = {
    getSession: async() => {
        try{
            const res = await axios.get('/api/session');
            return res.data;
        }
        catch(error){
            console.log(error);
            return false;
        }
    }
}

export default API;