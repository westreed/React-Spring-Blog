import { useEffect } from "react";
import { useDispatch } from "react-redux";
import Editor from "../components/editor/editor";
import { setWidgets } from "../store/widgets";



const Write = () => {
    const dispatch = useDispatch();

    useEffect(() => {
        dispatch(setWidgets(false));
        return () => {
            dispatch(setWidgets(true));
        }
    }, [])

    return (
        <div className="Write">
            <div style={{width:"100%", height:"100%"}}>
                <Editor types={0} />
            </div>
        </div>
    );
}

export default Write;