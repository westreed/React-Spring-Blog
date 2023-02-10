import { useEffect, useState } from "react";
import API from "../utils/api";

const getCategories = async(setCategories) => {
    const res = await API.getCategories();
    if (res === false){
        setCategories([]);
    }
    else{
        setCategories(res);
    }
}

const EditCategory = () => {
    const [categories, setCategories] = useState([]);

    useEffect(() => {getCategories(setCategories)}, [])
    return (
        <div>
            <div>
            {categories.map((content, idx) => <div>{content}</div>)}
            </div>
        </div>
    );
}

export default EditCategory;