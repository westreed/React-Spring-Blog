import { useEffect } from "react";
import { useDispatch } from "react-redux";
import { useLocation } from "react-router-dom";
import Editor from "../components/editor/editor";
import { setWidgets } from "../store/widgets";



const Write = () => {
    const location = useLocation();
    const dispatch = useDispatch();

    useEffect(() => {
        dispatch(setWidgets(false));
        return () => {
            dispatch(setWidgets(true));
        }
        // eslint-disable-next-line
    }, [])

    return (
        <div className="Write">
            <div style={{width:"100%", height:"100%"}}>
                <Editor category={location.state?.id} types={0} />
            </div>
        </div>
    );
}

export default Write;