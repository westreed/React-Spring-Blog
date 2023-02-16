import { createSlice } from "@reduxjs/toolkit";

const initialState = {
    data: [],
    select: null
}

export const category = createSlice({
    name : 'category',
    initialState,
    reducers : {
        setCategory(state, action){
            state.data = action.payload;
        },
        selectCategory(state, action){
            state.select = action.payload;
        }
    }
})

export const { setCategory, selectCategory } = category.actions;
export default category;