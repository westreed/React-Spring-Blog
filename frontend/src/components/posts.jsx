import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import API from "../utils/api";


const Posts = () => {
    const param = useParams();
    const [post, setPost] = useState(null);

    useEffect(() => {
        const fetchData = async() => {
            const res = await API.getPost({id:param.id});
            if (res === false){
                setPost(res);
            }
            else{
                setPost(null);
            }
        }
        fetchData();
        // eslint-disable-next-line
    }, [])

    console.log(post);

    return (
        <div></div>
    );
}

export default Posts;