import axios from "axios";
import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { setMember } from '../store/member';

async function getSession(userdata, dispatch){
    try{
        const res = await axios.get('/api/session');
        if (userdata == null ||
            res.data.username !== userdata.username ||
            res.data.role !== userdata.role) {
            dispatch(setMember(res.data));
        }
    }
    catch(error){
        console.log(error);
        if(userdata != null){
            dispatch(setMember(null));
            alert("");
        }
    }
}

export default function Session (){
    console.log("Session");
    const userdata = useSelector((state) => state.member.data);
    const dispatch = useDispatch();
    useEffect(() => {
        getSession(userdata, dispatch);
    })

    return;
}