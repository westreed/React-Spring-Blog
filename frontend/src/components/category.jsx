import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { setCategory } from "../store/category";
import API from "../utils/api";
import Functions from "../utils/functions";


const Categories = () => {
    const categories = useSelector((state) => state.categories.data)
    const dispatch = useDispatch();

    useEffect(() => {
        const fetchData = async() => {
            const res = await API.getCategories();
            if (res === false){
                dispatch(setCategory([]));
            }
            else{
                dispatch(setCategory(Functions.categorySort(res)));
            }
        }
        fetchData();
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, [])

    return (
        <div className="category blogCard shadow-sm bg-body rounded">
            <div style={{fontSize:"1.2em", marginBottom:"7px"}}>카테고리</div>
            {categories.map((data, idx) =>
                <button
                    className="noEffect useButton"
                    style={{display:"block", height:"1.8em", width:"100%", textAlign:"left", fontSize:"0.9em"}}
                    key={data.layer}
                >
                    {data.name}
                </button>
            )}
        </div>
    );
}

export default Categories;