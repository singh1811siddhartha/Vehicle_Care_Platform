import {createSlice} from "@reduxjs/toolkit";

const initState = {
    isLoggedIn: false,
    id: null
}
export const adminSlice = createSlice({
    name: "admin",
    initialState: initState,
    reducers: {
        login: (state, action) => {
            const {id} = action.payload;
            state.isLoggedIn = true;
            state.id = id;
        },
        logout: (state) => {
            state.isLoggedIn = false;
            state.id = null;
        }
    }
})

export const {login, logout} = adminSlice.actions;
export default adminSlice.reducer;