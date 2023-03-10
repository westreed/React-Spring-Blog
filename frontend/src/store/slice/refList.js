import { createSlice } from "@reduxjs/toolkit";

const initialState = {
    header: null
}

export const refList = createSlice({
    name : 'refList',
    initialState,
    reducers : {
        setHeaderRef(state, action){
            state.header = action.payload;
        }
    }
})

export const { setHeaderRef } = refList.actions;
export default refList;