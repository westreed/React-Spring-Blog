import Posts from "../components/posts";


const Post = () => {
    return (
        <div className="blogCard shadow-sm bg-body rounded" style={{width:"100%", height:"100%"}}>
            <Posts/>
        </div>
    );
}

export default Post;