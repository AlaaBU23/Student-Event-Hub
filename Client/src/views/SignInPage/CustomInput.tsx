import React, { useState } from 'react';

interface InputProps {
  placeholder?: string;
  apiUrl: string;
  onSubmitSuccess?: (response: any) => void;
  onSubmitError?: (error: any) => void;
}

const CustomInput: React.FC<InputProps> = ({
  placeholder = "Enter text...",
  apiUrl,
  onSubmitSuccess,
  onSubmitError,
}) => {
  const [inputValue, setInputValue] = useState('');

  const handleSubmit = async () => {
    try {
      const response = await fetch(apiUrl, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ data: inputValue }),
      });

      const responseData = await response.json();

      if (response.ok) {
        onSubmitSuccess && onSubmitSuccess(responseData);
      } else {
        onSubmitError && onSubmitError(responseData);
      }
    } catch (error) {
      onSubmitError && onSubmitError(error);
    }
  };

  return (
    <div>
      <input
        type="text"
        placeholder={placeholder}
        value={inputValue}
        onChange={(e) => setInputValue(e.target.value)}
      />
      <button onClick={handleSubmit}>Submit</button>
    </div>
  );
};

export default CustomInput;
