import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { useNavigate } from "react-router-dom";
import { setCategory } from "../store/category";
import { setPosts } from "../store/posts";
import API from "../utils/api";
import Functions from "../utils/functions";


const Categories = () => {
    const navigate = useNavigate();
    const categories = useSelector((state) => state.category.data)
    const pageSize = useSelector((state) => state.pageSize.data)
    const dispatch = useDispatch();

    useEffect(() => {
        const fetchData = async() => {
            const res = await API.getCategories();
            if (res === false){
                dispatch(setCategory([]));
            }
            else{
                dispatch(setCategory(Functions.categorySort(res)));
                console.log(res);
            }
        }
        fetchData();
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, [])

    const select = async(data) => {
        const req = {
            "page":0,
            "pageSize":pageSize,
            "id":data.id
        };
        const res = await API.getCategoryPosts(req);
        if (res !== false){
            res.name = data.name;
            dispatch(setPosts(res));
            navigate(`/category/${data.id}`)
            console.log("포스트:",res);
        }
        else{
            dispatch(setPosts(null));
        }
    }

    return (
        <div className="category blogCard shadow-sm bg-body rounded">
            <div style={{fontSize:"1.2em", marginBottom:"7px"}}>카테고리</div>
            {categories.map((data, idx) =>
                <button
                    className="noEffect useButton"
                    style={{display:"block", height:"1.8em", width:"100%", textAlign:"left", fontSize:"1em", letterSpacing:"-1px"}}
                    key={data.layer}
                    onClick={() => select(data)}
                >
                    {data.name}
                </button>
            )}
        </div>
    );
}

export default Categories;