import { createBrowserRouter } from 'react-router-dom';
import App from './App';
import { EmployeeDisplay } from './components/employee/EmployeeDisplay';

export const router = createBrowserRouter([
  {
    path: '/',
    Component: App,
  },
  {
    path: '/employees',
    Component: EmployeeDisplay,
  },
]);
