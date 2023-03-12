import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import PageList from "../components/pageList";
import { setPostList } from "../store/slice/postList";
import API from "../utils/api";


const Home = (props) => {
    const dispatch = useDispatch();
    const pageSize = useSelector((state) => state.pageSize.data);
    const postList = useSelector((state) => state.postList.data);

    const select = async() => {
        const req = {
            "page":0,
            "pageSize":pageSize,
            "id":0
        };
        const res = await API.getCategoryPosts(req);
        if (res !== false){
            res.name = "전체글보기";
            dispatch(setPostList(res));
        }
        else{
            dispatch(setPostList(null));
        }
    }

    useEffect(() => {
        select();
        // eslint-disable-next-line
    }, [])
    
    if(postList == null){
        return (
            <div/>
        );
    }
    return (
        <div style={{width:"100%"}}>
            <PageList headerRef={props.headerRef} />
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