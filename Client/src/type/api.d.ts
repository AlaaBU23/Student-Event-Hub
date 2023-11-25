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

interface RegisterReq {
  username: string;
  email: string;
  password: string;
  firstname: string;
  lastname: string;
  pwdConfirm: string;
  university: string;
  universityId: string;
  tay: string;
}