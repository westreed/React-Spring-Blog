import { configureStore } from "@reduxjs/toolkit";
import category from "./category";
import member from "./member";
import modal from "./modal";
import pageSize from "./pageSize";
import posting from "./posting";
import postList from "./postList";
import storeKey from "./storeKey";
import widgets from "./widgets";
import writing from "./writing";



export const store = configureStore({
    reducer : {
        member: member.reducer,
        modal: modal.reducer,
        category: category.reducer,
        postList: postList.reducer,
        pageSize: pageSize.reducer,
        posting: posting.reducer,
        widgets: widgets.reducer,
        writing: writing.reducer,
        storeKey: storeKey.reducer
    }
})