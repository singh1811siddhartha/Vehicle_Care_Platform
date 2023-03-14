import { configureStore } from '@reduxjs/toolkit'
import adminReducer from '../features/admin/adminSlice';
import mechanicReducer from '../features/mechanic/mechanicSlice';
import customerReducer from '../features/user/customerSlice';


export const store = configureStore({
  reducer: {
    admin: adminReducer,
    mechanic: mechanicReducer,
    customer: customerReducer
  },
});