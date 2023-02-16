import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { Link } from "react-router-dom";
import { selectCategory, setCategory } from "../store/category";
import { setPosts } from "../store/posts";
import API from "../utils/api";
import Functions from "../utils/functions";


const Categories = () => {
    const categories = useSelector((state) => state.category.data)
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
            "pageSize":15,
            "id":data.id
        };
        dispatch(selectCategory(data));
        const res = await API.getCategoryPosts(req);
        if (res !== false){
            dispatch(setPosts(res));
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
                <Link
                    className="noEffect useButton"
                    style={{display:"block", height:"1.8em", width:"100%", textAlign:"left", fontSize:"1em"}}
                    key={data.layer}
                    to={`/category/${data.id}`}
                    onClick={() => select(data)}
                >
                    {data.name}
                </Link>
            )}
        </div>
    );
}

export default Categories;