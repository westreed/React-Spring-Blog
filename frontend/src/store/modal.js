import { createSlice } from "@reduxjs/toolkit";

const initialState = {
    data: false
}

export const modal = createSlice({
    name : 'modal',
    initialState,
    reducers : {
        setModal(state, action){
            state.data = action.payload;
        }
    }
})

export const { setModal } = modal.actions;
export default modal;