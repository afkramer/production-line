import { PayloadAction, createSlice } from '@reduxjs/toolkit';
import { Employee } from '../models/Employee';

type EmployeeSliceState = {
  employees: Employee[];
};

const initialState: EmployeeSliceState = {
  employees: [],
};

const employeeSlice = createSlice({
  name: 'employeeSlice',
  initialState: initialState,
  reducers: {
    setEmployees: (state, action: PayloadAction<Employee[]>) => {
      state.employees = action.payload;
    },
  },
});

export const { setEmployees } = employeeSlice.actions;
export const employeeReducer = employeeSlice.reducer;
