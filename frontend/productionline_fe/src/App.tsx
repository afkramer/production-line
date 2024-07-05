import { useRef } from 'react';
import './App.css';
import { InputComponent } from './InputComponent';

function App() {
  const inputRef = useRef<HTMLInputElement>(null);

  const handleButtonClick = () => {
    if (inputRef.current) {
      console.log('You entered: ', inputRef.current.value);
      inputRef.current.focus();
    }
  };

  return (
    <div>
      <InputComponent ref={inputRef} />
      <button onClick={handleButtonClick}>Focus and show value</button>
    </div>
  );
}

export default App;
