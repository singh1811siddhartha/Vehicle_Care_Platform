import {createSlice} from "@reduxjs/toolkit";

const initState = {
    isLoggedIn: false,
    id: null
}
export const customerSlice = createSlice({
    name: "customer",
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

export const {login, logout} = customerSlice.actions;
export default customerSlice.reducer;