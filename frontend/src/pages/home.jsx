import { useState } from "react";
import Editor from "../components/editor";
import Viewer from "../components/view";


const Home = (props) => {
    // console.log(props);
    const [content, setContent] = useState('');
    
    return (
        <div className="blogCard" style={{width:"100%"}}>
            <Editor
                data={content}
                onChange={(event, editor) => {
                    const data = editor.getData();
                    setContent(data);
                    console.log({ event, editor, data });
                }}
            />
            <Viewer content={content}/>
        </div>
    );
}

export default Home;