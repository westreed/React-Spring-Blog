import { createSlice } from "@reduxjs/toolkit";

const initialState = {
    data: false
}

export const posts = createSlice({
    name : 'posts',
    initialState,
    reducers : {
        setPosts(state, action){
            state.data = action.payload;
        }
    }
})

export const { setPosts } = posts.actions;
export default posts;