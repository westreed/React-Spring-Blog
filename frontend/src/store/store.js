import { combineReducers, configureStore } from "@reduxjs/toolkit";
import category from "./slice/category";
import member from "./slice/member";
import modal from "./slice/modal";
import pageSize from "./slice/pageSize";
import posting from "./slice/posting";
import postList from "./slice/postList";
import storeKey from "./slice/storeKey";
import widgets from "./slice/widgets";
import writing from "./slice/writing";

const reducers = combineReducers({
    member: member.reducer,
    modal: modal.reducer,
    category: category.reducer,
    postList: postList.reducer,
    pageSize: pageSize.reducer,
    posting: posting.reducer,
    widgets: widgets.reducer,
    writing: writing.reducer,
    storeKey: storeKey.reducer
})


export const store = configureStore({
    reducer: reducers
})