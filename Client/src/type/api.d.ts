//requset
interface LoginAPIReq {
  username: string;
  password: string;
  code: string;
  uuid: string;
}

//respond
interface LoginAPIRes {
  msg: string;
  code: number;
  token: string;
}

interface UserReq {
  userId: string;
  userName: string;
  email: string;
  password: string;
  firstname: string;
  lastname: string;
  zipCode: string;
  university: string;
  universityId: string;
  age: string;
  description: string;
}

//respond
interface RegisterRes {
  token: string;
}