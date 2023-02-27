import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { useParams } from "react-router-dom";
import { setPosting } from "../store/posting";
import API from "../utils/api";


const Posts = () => {
    const params = useParams();
    const posting = useSelector((state) => state.posting.data)
    const dispatch = useDispatch();

    const fetchData = async() => {
        const res = await API.getPost({id:params.id});
        dispatch(setPosting(res));
    }

    useEffect(() => {
        fetchData();
        // eslint-disable-next-line
    }, [params.id])

    return (
        <div>
            {/* Header */}
            <div>
                <div>{posting?.title}</div>
            </div>
        </div>
    );
}

export default Posts;