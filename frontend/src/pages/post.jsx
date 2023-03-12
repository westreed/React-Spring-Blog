import PostCotnent from "../components/postCotnent";


const Post = (props) => {
    return (
        <div className="blogCard shadow-sm bg-body rounded" style={{width:"100%", height:"100%"}}>
            <PostCotnent headerRef={props.headerRef}/>
        </div>
    );
}

export default Post;