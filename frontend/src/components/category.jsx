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
                res.sort(function(a,b){
                    const A = a.layer;
                    const B = b.layer;
                    if (A < B) return -1;
                    return 1;
                });
                setCategories(res);
            }
        }
        fetchData();
    }, [])

    return (
        <div className="blogCard shadow-sm bg-body rounded">
            <p>카테고리</p>
            {categories.map((data, idx) => <div key={data.layer}>{data.name}</div>)}
        </div>
    );
}

export default Categories;