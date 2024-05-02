import axios from 'axios';
import { Employee } from '../models/Employee';
import { endpoint } from './api';

const employeeEndpoint = `${endpoint}/employees`;

export const saveEmployee = async (employee: Employee) => {
  const response = await axios.post(employeeEndpoint, employee);
  return response.data;
};

export const getAllEmployees = async (): Promise<Employee[]> => {
  const response = await axios.get(employeeEndpoint);
  return response.data;
};
