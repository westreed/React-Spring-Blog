import { useEffect } from "react";
import { useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import Editor from "../components/editor";
import Pages from "../components/pages";
import Viewer from "../components/view";
import { setPosts } from "../store/posts";
import API from "../utils/api";


const Home = () => {
    const dispatch = useDispatch();
    const pageSize = useSelector((state) => state.pageSize.data);
    const posts = useSelector((state) => state.posts.data);

    const select = async() => {
        const req = {
            "page":0,
            "pageSize":pageSize,
            "id":0
        };
        const res = await API.getCategoryPosts(req);
        if (res !== false){
            res.name = "전체글보기";
            dispatch(setPosts(res));
        }
        else{
            dispatch(setPosts(null));
        }
    }

    useEffect(() => {
        select();
    }, [])
    
    if(posts == null){
        return (
            <div></div>
        );
    }
    return (
        <div style={{width:"100%"}}>
            <Pages/>
        </div>
    );
}

export default Home;

/*
<Editor
    data={content}
    onChange={(event, editor) => {
        const data = editor.getData();
        setContent(data);
        console.log({ event, editor, data });
    }}
/>
<Viewer content={content}/>
*/