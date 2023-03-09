import moment from "moment";
import Cookies from "js-cookie";
import { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { useNavigate, useParams } from "react-router-dom";
import { setPosting } from "../store/slice/posting";
import { setPostList } from "../store/slice/postList";
import API from "../utils/api";
import { ReactComponent as Menu } from "../assets/dot-menu-more-svgrepo-com.svg";
import { ReactComponent as Heart1 } from "../assets/heart1-svgrepo-com.svg";
import { ReactComponent as Heart2 } from "../assets/heart2-svgrepo-com.svg";
import { ReactComponent as Comment } from "../assets/comment-dots-svgrepo-com.svg";

const Posts = () => {
    const navigate = useNavigate();
    const params = useParams();
    const member = useSelector((state) => state.member.data);
    const pageSize = useSelector((state) => state.pageSize.data);
    const posting = useSelector((state) => state.posting.data);
    const dispatch = useDispatch();
    const [like, setLike] = useState(false);
    const [likeCount, setLikeCount] = useState(0);

    const fetchData = async() => {
        const res = await API.getPost({id:params.id});
        const visit = Cookies.get(`postview${params.id}`);
        if (res !== null && visit === undefined){
            res.view += 1;
            await API.addViewCount(params.id);
            const now = new Date();
            const expires = new Date(now.getTime() + 30*60*1000);
            Cookies.set(`postview${params.id}`, true, {expires});
        }
        setLike(res.likeState);
        setLikeCount(res.likeCount);
        dispatch(setPosting(res));
    }

    const formmatedDate = (date) => {
        return moment(date).format("YYYY.MM.DD. HH:mm");
    }

    const selectCategory = async(id, name) => {
        const req = {
            "page":0,
            "pageSize":pageSize,
            "id":id
        };
        const res = await API.getCategoryPosts(req);
        if (res !== null) res.name = name;
        dispatch(setPostList(res));
        if (res !== null) navigate(`/category`);
    }

    const clickHeart = async(postId) => {
        if(member === null){
            alert("로그인해야 이용하실 수 있습니다.");
            return false;
        }
        if(like === true){
            await API.removeLike(postId);
            setLike(false);
            setLikeCount(likeCount-1);
        }
        else{
            await API.addLike(postId);
            setLike(true);
            setLikeCount(likeCount+1);
        }
    }

    useEffect(() => {
        fetchData();
        // eslint-disable-next-line
    }, [params.id, member])

    return (
        <div>
            {/* Header */}
            <div>
                {/* Category */}
                <div style={{display:"flex", flexDirection:"row", color:"gray", fontSize:"0.9em"}}>
                    <div>카테고리｜</div>
                    <button className="noEffect p-0" style={{color:"gray", marginRight:"0.5em"}} onClick={() => selectCategory(posting?.category.id, posting?.category.name)}>{posting?.category.name}</button>
                </div>
                {/* Title */}
                <div style={{fontSize:"1.6em"}}>{posting?.title}</div>
                {/* Info */}
                <div style={{display:"flex", flexDirection:"row", justifyContent:"space-between", marginTop:"0.5em"}}>
                    <div style={{display:"flex", flexDirection:"row", fontSize:"0.9em"}}>
                        <div style={{marginRight:"1.0em"}}>{posting?.member.username}</div>
                        <div style={{color:"grey"}}>{formmatedDate(posting?.createData)}</div>
                        <div style={{marginLeft:"1.0em", color:"grey"}}>조회 {posting?.view.toLocaleString()}</div>
                    </div>
                    <div style={{display:"flex", flexDirection:"row"}}>
                        <Menu fill="#3273dc" width="20px" height="20px"/>
                    </div>
                </div>
                <hr style={{marginTop:"8px", marginBottom:"2em"}}/>
            </div>
            {/* Content */}
            <div
                className="content"
                dangerouslySetInnerHTML={{ __html: posting?.content }}
                style={{minHeight:"50px"}}
            ></div>
            {/* Footer */}
            <div style={{marginTop:"1em"}}>
                <div style={{display:"flex", flexDirection:"row", justifyContent:"space-between"}}>
                    <div style={{display:"flex", flexDirection:"row"}}>
                        {/* Like */}
                        <button className="noEffect useButton2" style={{display:"flex", flexDirection:"row", border:"1px solid #c3c3c3", alignItems:"center", fontSize:"0.9em", padding:"4px"}} onClick={() => clickHeart(params?.id)}>
                            {like === false ? <Heart1 width="1.4em" height="1.4em" stroke="#E90064"/> : <Heart2 width="1.4em" height="1.4em" fill="#E90064"/>}
                            <div style={{marginLeft:"4px", marginRight:"4px"}}>좋아요</div>
                            <div>{likeCount}</div>
                        </button>
                        {/* Reply */}
                        <button className="noEffect useButton2" style={{display:"flex", flexDirection:"row", border:"1px solid #c3c3c3", alignItems:"center", fontSize:"0.9em", padding:"4px", marginLeft:"10px"}}>
                            <Comment width="1.4em" height="1.4em" fill="#3273dc"/>
                            <div style={{marginLeft:"4px", marginRight:"4px"}}>댓글</div>
                            <div>0</div>
                        </button>
                    </div>
                    <div style={{display:"flex", flexDirection:"row"}}>
                        {/* Edit */}
                        <button className="noEffect useButton2" style={{border:"1px solid #c3c3c3", alignItems:"center", fontSize:"0.9em", padding:"4px"}}>
                            <div>수정</div>
                        </button>
                        {/* Delete */}
                        <button className="noEffect useButton2" style={{border:"1px solid #c3c3c3", borderLeft:"0px", alignItems:"center", fontSize:"0.9em", padding:"4px"}}>
                            <div>삭제</div>
                        </button>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Posts;