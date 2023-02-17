import moment from "moment/moment";
import { useEffect, useState } from "react";
import { Dropdown } from "react-bootstrap";
import { useDispatch, useSelector } from "react-redux";
import { useNavigate, useParams } from "react-router-dom";
import { setPageSize } from "../store/pageSize";
import { setPosts } from "../store/posts";
import API from "../utils/api";

const pageSizeList = [1, 5, 10, 15, 20, 30, 50];

const Categories = () => {
    const navigate = useNavigate();
    const dispatch = useDispatch();
    const params = useParams();
    const posts = useSelector((state) => state.posts.data);
    const pageSize = useSelector((state) => state.pageSize.data)
    const categoryId = params?.categoryId;
    const nowMoment = moment();
    const pageElement = [];

    const changePageSize = async(page, value) => {
        const req = {
            "page":page,
            "pageSize":value,
            "id":posts.id
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
        dispatch(setPageSize(value));
    }

    const currentPage = Math.floor(posts?.pageNumber/10);
    const currentEndPage = (currentPage+1)*10;
    const currentLastPage = currentEndPage > posts?.totalPages ? posts?.totalPages : currentEndPage;
    for(let i=currentPage*10; i<currentLastPage; i++){
        if(i == posts?.pageNumber){
            pageElement.push(<button key={i} className="noEffect pick page" onClick={() => changePageSize(i, pageSize)}>{i+1}</button>);
        }
        else{
            pageElement.push(<button key={i} className="noEffect page" onClick={() => changePageSize(i, pageSize)}>{i+1}</button>);
        }
    }
    if(currentEndPage < posts?.totalPages){
        pageElement.push(<button className="noEffect page">다음</button>);
    }

    const formmatedDate = (date) => {
        const formmatDate = moment(date);
        const diff = nowMoment.diff(formmatDate);
        if(diff < 86400000){
            return formmatDate.format("HH:mm");
        }
        return formmatDate.format("YYYY.MM.DD.");
    }

    useEffect(() => {
        console.log(posts);
        if(posts == null) navigate("/");
    }, [])

    return (
        <div className="blogCard shadow-sm bg-body rounded" style={{width:"100%"}}>
            <div style={{marginBottom:"10px", fontSize:"1.4em", fontWeight:"bold"}}>
                {categoryId == null ? <div>전체글보기</div> : <div>{posts?.name}</div>}
            </div>
            <div style={{display:"flex", flexDirection:"row", justifyContent:"space-between"}}>
                <div style={{display:"flex", flexDirection:"row", fontSize:"0.9em", marginBottom:"14px"}}>
                    <div style={{fontWeight:"bold"}}>{posts?.totalCount.toLocaleString()}</div>
                    <div>개의 게시글</div>
                </div>
                <Dropdown>
                    <Dropdown.Toggle variant="primary" size="sm" id="dropdown-basic">
                        {pageSize}개씩
                    </Dropdown.Toggle>
                    <Dropdown.Menu>
                        {pageSizeList.map((res, idx) => 
                            <Dropdown.Item
                                key={idx}
                                onClick={() => changePageSize(0, res)}
                            >
                                {res}개씩
                            </Dropdown.Item>
                        )}
                    </Dropdown.Menu>
                </Dropdown>
            </div>
            <div style={{border:"1px solid #7286D3", height:"1px"}}/>
            {/* 게시글 리스트 */}
            <div style={{marginTop:"4px", fontSize:"0.9em"}}>
                {/* 게시글 헤더 */}
                <div>
                    <div className="truncate" style={{display:"flex", flexDirection:"row", fontWeight:"bold"}}>   
                        <div style={{flex:"0.1"}}></div>
                        <div style={{flex:"0.5", textAlign:"center"}}>제목</div>
                        <div style={{flex:"0.15", textAlign:"center"}}>작성자</div>
                        <div style={{flex:"0.05", textAlign:"center"}}>조회</div>
                        <div style={{flex:"0.2", textAlign:"center"}}>작성일</div>
                    </div>
                </div>
                <hr style={{marginTop:"8px", marginBottom:"8px"}}/>
                {/* 게시글 내용 */}
                {posts?.boards.map((res, idx) => 
                    <div key={idx}>
                        <div style={{display:"flex", flexDirection:"row"}}>   
                            <div style={{flex:"0.1", marginLeft:"0.4em"}}>
                            {categoryId === 0 ? <div>{res.category.name}</div> : <div>{res.id}</div>}
                            </div>
                            <div className="truncate" style={{flex:"0.5"}}>{res.title}</div>
                            <div style={{flex:"0.15", textAlign:"center"}}>{res.member.username}</div>
                            <div style={{flex:"0.05", textAlign:"center"}}>{res.view.toLocaleString()}</div>
                            <div style={{flex:"0.2", textAlign:"center"}}>{formmatedDate(res.createData)}</div>
                        </div>
                        <hr style={{marginTop:"8px", marginBottom:"8px"}}/>
                    </div>
                )}
            </div>
            {/* 하단 페이지 */}
            <div style={{marginTop:"20px"}}>
                <div style={{flex:1, display:"flex", flexDirection:"row", justifyContent:"center"}}>
                    {pageElement}
                </div>
            </div>
        </div>
    );
}

export default Categories;