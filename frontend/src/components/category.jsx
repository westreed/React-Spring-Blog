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
        <div className="blogCard shadow-sm bg-body rounded">
            <p>카테고리</p>
            {categories.map((data, idx) => <div key={data.layer}>{data.name}</div>)}
        </div>
    );
}

export default Categories;