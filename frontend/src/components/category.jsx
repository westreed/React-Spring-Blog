import axios from "axios";
import { useEffect, useState } from "react";


const Categories = () => {
    const [categories, setCategories] = useState([]);

    useEffect(() => {
        axios.get('/api/categories')
        .then(res => setCategories(res.data))
        .catch(error => console.log(error))
    }, []);

    return (
        <div className="blogCard shadow-sm bg-body rounded">
            <p>카테고리</p>
            {categories.map((content, idx) => <div>{content}</div>)}
        </div>
    );
}

export default Categories;