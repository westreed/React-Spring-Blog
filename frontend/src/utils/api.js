import axios from "axios";

const apiLink = "http://westreedserver.kro.kr:8080";
const API = {
    getSession: async() => {
        try{
            const res = await axios.get(`${apiLink}/api/session`);
            return res.data;
        }
        catch(error){
            console.log(error);
            return false;
        }
    },
    getCategories: async() => {
        try{
            const res = await axios.get(`${apiLink}/api/categories`);
            return res.data;
        }
        catch(error){
            console.log(error);
            return false;
        }
    },
    postCategories: async(data) => {
        try{
            const res = await axios.post(`${apiLink}/api/categories`, data);
            return res.data;
        }
        catch(error){
            console.log(error);
            return false;
        }
    },
    getRsakey: async() => {
        try {
            const res = await axios.get(`${apiLink}/api/key`);
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
            const res = await axios.get(`${apiLink}/api/posts`, {params:data});
            return res.data;
        }
        catch(error){
            console.log(error);
            return false;
        }
    }
}

export default API;