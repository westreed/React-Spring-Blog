import { useEffect, useState } from "react";
import { useSelector } from "react-redux";
import { useNavigate, useParams } from "react-router-dom";
import API from "../utils/api";


const Categories = () => {
    const navigate = useNavigate();
    const params = useParams();
    const select = useSelector((state) => state.category.select);
    const posts = useSelector((state) => state.posts.data);
    const categoryId = params?.categoryId;

    useEffect(() => {
        if(select == null) navigate("/");
    }, [])

    return (
        <div className="blogCard shadow-sm bg-body rounded" style={{width:"100%"}}>
            <div>
                {categoryId == null ?
                    <div style={{fontSize:"1.5em"}}>전체글보기</div> :
                    <div style={{fontSize:"1.5em"}}>{select?.name}</div>
                }
            </div>
            <div style={{border:"1px solid #7286D3", height:"1px"}}/>
        </div>
    );
}

export default Categories;