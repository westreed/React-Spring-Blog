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
    },
    getCategories: async() => {
        try{
            const res = await axios.get('/api/categories');
            return res.data;
        }
        catch(error){
            console.log(error);
            return false;
        }
    },
    postCategories: async(data) => {
        try{
            const res = await axios.post('/api/categories', data);
            return res.data;
        }
        catch(error){
            console.log(error);
            return false;
        }
    },
    getRsakey: async() => {
        try {
            const res = await axios.get('/api/key');
            return {
                modulus: res.data.modulus,
                exponent: res.data.exponent,
            }
        }
        catch(error){
            console.log(error);
            return false;
        }
    },
    getCategoryPosts: async(data) => {
        try {
            const res = await axios.get('/api/posts', {params:data});
            return res.data;
        }
        catch(error){
            console.log(error);
            return false;
        }
    }
}

export default API;