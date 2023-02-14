import { useEffect, useRef, useState } from "react";
import API from "../utils/api";

const getCategories = async(setCategories) => {
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

const Editing = (props) => {
    const idx = props.idx;
    const [categories, setCategories] = props.list;
    const [name, setName] = props.edit;

    const MoveUp = (e) => {
        if(categories[idx].layer > 0){
            const pos = categories[idx].layer;
            const _categories = categories;
            _categories.forEach(data => {
                if(data.layer === pos-1){
                    data.layer += 1;
                }
            })
            _categories[idx].layer -= 1;
            _categories.sort(function(a,b){
                const A = a.layer;
                const B = b.layer;
                if (A < B) return -1;
                return 1;
            });
            setCategories(_categories);
            props.update({});
        }
    }

    const MoveDown = (e) => {
        if(categories[idx].layer < categories.length-1){
            const pos = categories[idx].layer;
            const _categories = categories;
            _categories.forEach(data => {
                if(data.layer === pos+1){
                    data.layer -= 1;
                }
            })
            _categories[idx].layer += 1;
            _categories.sort(function(a,b){
                const A = a.layer;
                const B = b.layer;
                if (A < B) return -1;
                return 1;
            });
            setCategories(_categories);
            props.update({});
        }
    }

    return (
        <div>
            <div>카테고리명</div>
            <input type="text" value={name} onChange={e => setName(e.target.value)}/>
            <div>카테고리정렬</div>
            <div>
                <button onClick={MoveUp}>위</button>
                <button onClick={MoveDown}>아래</button>
            </div>
            <button>수정하기</button>
        </div>
    );
}

const EditCategory = () => {
    const inputRef = useRef(false);
    const [, updateState] = useState();
    const [categories, setCategories] = useState([]);
    const [editIdx, setEditIdx] = useState(null);
    const [editName, setEditName] = useState(null);

    const addCategory = (e) => {
        const value = inputRef.current.value;
        if(value === '') return false;
        inputRef.current.value = '';
        let last = 0;
        categories.forEach(data => {
            last += 1;
            if(data.name === value){
                alert("같은 이름의 게시판이 존재합니다.");
                return false;    
            }
        });
        setCategories([...categories, {layer:last, name:value}]);
    }

    const selectCategory = (idx, content) => {
        setEditIdx(idx);
        setEditName(content);
    }

    const Commit = (e) => {
        const data = [];
        for (let index = 0; index < categories.length; index++) {
            data.push({layer:index, name:categories[index]});
        }
        console.log(data);
    }

    useEffect(() => {getCategories(setCategories)}, [])
    return (
        <div>
            <div style={{display:"flex", flexDirection:"row", justifyContent:"space-between"}}>
                <div style={{flex:"30%", border:"1px solid #7286D3"}}>
                    <h3>카테고리</h3>
                    {categories.map((res, idx) => 
                        <button
                            className="noEffect"
                            style={{display:"block"}}
                            key={res.layer}
                            onClick={() => selectCategory(res.layer, res.name)}
                        >{idx+1}. {res.name}</button>
                    )}
                    <input ref={inputRef}/>
                    <button onClick={addCategory}>추가</button>
                </div>
                <div style={{flex:"70%", border:"1px solid #7286D3"}}>
                    {editIdx != null ?
                        <Editing idx={editIdx} list={[categories, setCategories]} edit={[editName,setEditName]} update={updateState} />
                    : null}
                </div>
            </div>
            <button style={{flex:1}} onClick={Commit}>확인</button>
        </div>
    );
}

export default EditCategory;