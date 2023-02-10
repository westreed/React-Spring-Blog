import { useEffect, useState } from "react";
import API from "../utils/api";


const Categories = () => {
    const [categories, setCategories] = useState([]);

    useEffect(() => {
        const fetchData = async() => {
            const res = await API.getCategories();
            if (res === false){
                setCategories([]);
            }
            else{
                setCategories(res);
            }
        }
        fetchData();
    }, [])

    return (
        <div className="blogCard shadow-sm bg-body rounded">
            <p>카테고리</p>
            {categories.map((content, idx) => <div>{content}</div>)}
        </div>
    );
}

export default Categories;