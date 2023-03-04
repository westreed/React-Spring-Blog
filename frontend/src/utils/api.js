import axios from "axios";

axios.defaults.withCredentials = true;
const apiLink = process.env.REACT_APP_API_ENDPOINT;
const API = {
    getSession: async() => {
        try{
            const res = await axios.get(`${apiLink}/api/session`);
            return res.data;
        }
        catch(error){
            console.log(error);
            return null;
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
    login: async(data) => {
        try {
            const res = await axios.post(`${apiLink}/api/login`, data);
            return {error:false, data:res.data};
        }
        catch(error){
            console.log(error);
            return {error:true, data:error};
        }
    },
    logout: async() => {
        try {
            await axios.get(`${apiLink}/api/logout`);
            return true;
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
            return null;
        }
    },
    getPost: async(data) => {
        try {
            const res = await axios.get(`${apiLink}/api/post`, {params:data});
            return res.data;
        }
        catch(error){
            console.log(error);
            return null;
        }
    },
    addViewCount: async(data) => {
        try {
            const res = await axios.put(`${apiLink}/api/post`, {id:data});
            return res.data;
        }
        catch(error){
            console.log(error);
            return null;
        }
    },
    addLike: async(data) => {
        try {
            const res = await axios.post(`${apiLink}/api/like/${data}`);
            return res.data;
        }
        catch(error){
            console.log(error);
            return null;
        }
    },
    removeLike: async(data) => {
        try {
            const res = await axios.delete(`${apiLink}/api/like/${data}`);
            return res.data;
        }
        catch(error){
            console.log(error);
            return null;
        }
    },
    writePost: async(data) => {
        try{
            const res = await axios.post(`${apiLink}/api/write`, data);
            return res.data;
        }
        catch(error){
            console.log(error);
            return null;
        }
    }
}

export default API;