import { useState } from 'react';

export const EmployeeDisplay = () => {
  const [name, setName] = useState<string>('');

  return (
    <>
      <h1>Employees</h1>
      <h2>Add an Employee</h2>
      <div>
        <label>Name:</label>
        <input onChange={(e) => setName(e.currentTarget.value)} value={name}></input>
      </div>
    </>
  );
};
