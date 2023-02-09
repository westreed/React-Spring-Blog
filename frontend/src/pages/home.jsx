import { useState } from "react";
import Editor from "../components/editor";
import Viewer from "../components/view";


const Home = (props) => {
    
    return (
        <div className="blogCard shadow-sm bg-body rounded" style={{width:"100%"}}>
            ImHome
        </div>
    );
}

export default Home;

/*
<Editor
    data={content}
    onChange={(event, editor) => {
        const data = editor.getData();
        setContent(data);
        console.log({ event, editor, data });
    }}
/>
<Viewer content={content}/>
*/