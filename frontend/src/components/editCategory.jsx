import { useEffect, useRef, useState } from "react";
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

const Editing = (props) => {
    const idx = props.idx;
    const [categories, setCategories] = props.list;
    const [name, setName] = props.edit;

    const MoveUp = () => {
    }

    return (
        <div>
            <div>카테고리명</div>
            <input type="text" value={name} onChange={e => setName(e.target.value)}/>
            <div>카테고리정렬</div>
            <div>
                <button>위</button>
                <button>아래</button>
            </div>
            <button>수정하기</button>
        </div>
    );
}

const EditCategory = () => {
    const inputRef = useRef(false);
    const [categories, setCategories] = useState([]);
    const [editIdx, setEditIdx] = useState(null);
    const [editName, setEditName] = useState(null);

    const addCategory = (e) => {
        const value = inputRef.current.value;
        if(value === '') return false;
        inputRef.current.value = '';
        if(categories.includes(value)){
            alert("같은 이름의 게시판이 존재합니다.");
        }
        else{
            setCategories([...categories, value]);
        }
    }

    const selectCategory = (idx, content) => {
        setEditIdx(idx);
        setEditName(content);
    }

    useEffect(() => {getCategories(setCategories)}, [])
    return (
        <div>
            <div style={{display:"flex", flexDirection:"row", justifyContent:"space-between"}}>
                <div style={{flex:"30%", border:"1px solid #7286D3"}}>
                    <h3>카테고리</h3>
                    {categories.map((content, idx) => 
                        <div key={idx} onClick={() => selectCategory(idx, content)}>{idx+1}. {content}</div>
                    )}
                    <input ref={inputRef}/>
                    <button onClick={addCategory}>추가</button>
                </div>
                <div style={{flex:"70%", border:"1px solid #7286D3"}}>
                    {editIdx != null ?
                        <Editing list={[categories, setCategories]} idx={editIdx} edit={[editName,setEditName]} />
                    : null}
                </div>
            </div>
        </div>
    );
}

export default EditCategory;