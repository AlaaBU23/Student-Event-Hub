import request from "./index"

const API_BASE_URL = 'http://localhost:8080';

export const registerUser = async (data: RegisterReq) => {
  const response = await fetch(`${API_BASE_URL}/register`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(data),
  });

  if (!response.ok) {
    throw new Error('Registration failed');
  }

  return response.json();
};

export const LoginAPI = (params: LoginAPIReq): Promise<LoginAPIRes> => request.post("/users/login", params)