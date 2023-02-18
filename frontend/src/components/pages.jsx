import moment from "moment/moment";
import { useEffect, useState } from "react";
import { Dropdown } from "react-bootstrap";
import { useDispatch, useSelector } from "react-redux";
import { useNavigate } from "react-router-dom";
import { setPageSize } from "../store/pageSize";
import { setPosts } from "../store/posts";
import API from "../utils/api";

const pageSizeList = [1, 5, 10, 15, 20, 30, 50];

const bottomPageList = (posts, pageSize, changePageSize) => {
    const pageElement = [];
    const split = window.innerWidth > 768 ? 10 : 5;
    const currentPage = Math.floor(posts?.pageNumber/split);
    const currentEndPage = (currentPage+1)*split;
    const currentLastPage = currentEndPage > posts?.totalPages ? posts?.totalPages : currentEndPage;
    if(currentPage > 0){
        pageElement.push(<button className="noEffect page shadow-sm" onClick={() => changePageSize((currentPage-1)*split, pageSize, posts?.id)}>〈 이전</button>);
    }
    for(let i=currentPage*split; i<currentLastPage; i++){
        if(i == posts?.pageNumber){
            pageElement.push(<button key={i} className="noEffect pick page shadow-sm" onClick={() => changePageSize(i, pageSize, posts?.id)}>{i+1}</button>);
        }
        else{
            pageElement.push(<button key={i} className="noEffect page shadow-sm" onClick={() => changePageSize(i, pageSize, posts?.id)}>{i+1}</button>);
        }
    }
    if(currentEndPage < posts?.totalPages){
        pageElement.push(<button className="noEffect page shadow-sm" onClick={() => changePageSize((currentPage+1)*split, pageSize, posts?.id)}>다음 〉</button>);
    }
    return pageElement;
}

const Pages = () => {
    const navigate = useNavigate();
    const dispatch = useDispatch();
    const posts = useSelector((state) => state.posts.data);
    const pageSize = useSelector((state) => state.pageSize.data);
    const nowMoment = moment();

    const changePageSize = async(page, size, id) => {
        const req = {
            "page":page,
            "pageSize":size,
            "id":id
        };
        const res = await API.getCategoryPosts(req);
        if (res !== false){
            res.name = posts.name;
            dispatch(setPosts(res));
            console.log("포스트:",res);
        }
        else{
            dispatch(setPosts(null));
        }
        dispatch(setPageSize(size));
    }

    const pageElement = bottomPageList(posts, pageSize, changePageSize);

    const formmatedDate = (date) => {
        const formmatDate = moment(date);
        if(formmatDate.isSame(nowMoment, "day")){
            return "Today "+formmatDate.format("HH:mm");
        }
        return formmatDate.format("YYYY.MM.DD.");
    }

    useEffect(() => {
        console.log(posts);
        if(posts == null) navigate("/");
    }, [])

    return (
        <div style={{width:"100%"}}>
            {/* 카테고리 헤더 */}
            <div className="blogCard shadow-sm bg-body rounded" style={{backgroundColor:"#f7f7f7"}}>
                <div style={{marginBottom:"6px", fontSize:"1.4em", fontWeight:"bold"}}>
                    <div>{posts?.name}</div>
                </div>
                <div style={{display:"flex", flexDirection:"row", justifyContent:"space-between", alignItems:"center"}}>
                    <div style={{display:"flex", flexDirection:"row", fontSize:"0.9em"}}>
                        <div style={{fontWeight:"bold"}}>{posts?.totalCount.toLocaleString()}</div>
                        <div>개의 게시글</div>
                    </div>
                    <div style={{display:"flex", flexDirection:"row"}}>
                        <button className="noEffect" style={{backgroundColor:"#3273dc", borderRadius:"4px", marginRight:"5px", color:"white", fontSize:"14px"}}>글쓰기</button>
                        <Dropdown>
                            <Dropdown.Toggle variant="primary" size="sm" id="dropdown-basic" style={{backgroundColor:"#3273dc"}}>
                                {pageSize}개씩
                            </Dropdown.Toggle>
                            <Dropdown.Menu>
                                {pageSizeList.map((res, idx) => 
                                    <Dropdown.Item
                                        key={idx}
                                        onClick={() => changePageSize(0, res, posts?.id)}
                                    >
                                        {res}개씩
                                    </Dropdown.Item>
                                )}
                            </Dropdown.Menu>
                        </Dropdown>
                    </div>
                </div>
            </div>
            {/* 게시글 리스트 */}
            <div>
                {posts?.boards.map((res, idx) => 
                    <div className="blogCard shadow-sm bg-body rounded" key={idx}>
                        <div style={{display:"flex", flexDirection:"row", color:"grey", fontSize:"0.8em"}}>
                            <div style={{marginRight:"0.5em"}}>{formmatedDate(res.createData)}</div>
                            <div>카테고리｜</div>
                            <div style={{marginRight:"0.5em"}}>{res.category.name}</div>
                            <div>{res.view.toLocaleString()}조회</div>
                        </div>
                        <div style={{display:"flex", flexDirection:"row", fontSize:"1.4em", alignItems:"center", justifyContent:"space-between"}}>
                            <div>{res.title}</div>
                        </div>
                    </div>
                )}
            </div>
            {/* 하단 페이지 이동 */}
            <div className="extraCard" style={{marginTop:"20px"}}>
                <div style={{flex:1, display:"flex", flexDirection:"row", justifyContent:"center", fontSize:"1em"}}>
                    {pageElement}
                </div>
            </div>
        </div>
    );
}

export default Pages;