import { configureStore } from "@reduxjs/toolkit";
import category from "./category";
import member from "./member";
import modal from "./modal";
import posts from "./posts";



export const store = configureStore({
    reducer : {
        member: member.reducer,
        modal: modal.reducer,
        category: category.reducer,
        posts: posts.reducer
    }
})