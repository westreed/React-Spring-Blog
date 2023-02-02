import { configureStore } from "@reduxjs/toolkit";
import member from "./member";
import modal from "./modal";



export const store = configureStore({
    reducer : {
        member : member.reducer,
        modal : modal.reducer,
    }
})