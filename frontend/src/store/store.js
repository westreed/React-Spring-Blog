import { configureStore } from "@reduxjs/toolkit";
import category from "./category";
import member from "./member";
import modal from "./modal";
import pageSize from "./pageSize";
import posting from "./posting";
import posts from "./posts";
import widgets from "./widgets";



export const store = configureStore({
    reducer : {
        member: member.reducer,
        modal: modal.reducer,
        category: category.reducer,
        posts: posts.reducer,
        pageSize: pageSize.reducer,
        posting: posting.reducer,
        widgets: widgets.reducer
    }
})