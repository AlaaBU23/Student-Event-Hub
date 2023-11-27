import { memo } from 'react';
import type { FC } from 'react';
import { Input, Button } from 'antd';
import "reset-css";
import { Line1Icon } from './Line1Icon.js';
import { Line2Icon } from './Line2Icon.js';
import { Rectangle20Icon } from './Rectangle20Icon.js';
import classes from './SignInPage.module.css';
import NavigationBar from '@/componets/NavigationBar.js';
import { Background } from '@/componets/Background.js';
import { Link, useNavigate } from "react-router-dom";
import { ChangeEvent, useState } from 'react'
// get data
import { LoginAPI, registerUser } from '@/requset/api.js'

interface Props {
  className?: string;
}

export const SignInPage: FC<Props> = memo(function SignInPage(props = {}) {
  //register function
  const [username2Val, setUsername2Val] = useState("");
  const [password2Val, setPassword2Val] = useState("");
  const [emailVal, setEmailVal] = useState("");
  const [firstnameVal, setfirstnameVal] = useState("");
  const [lastnameVal, setlastnameVal] = useState("");
  const [pwdConfirmVal, setpwdConfirmVal] = useState("");
  const [universityVal, setuniversityVal] = useState("");
  const [universityIdVal, setuniversityIdVal] = useState("");
  const [tayVal, settayVal] = useState("");

  const username2Change = (e: ChangeEvent<HTMLInputElement>) => {
    setUsername2Val(e.target.value)
  }
  const emailChange = (e: ChangeEvent<HTMLInputElement>) => {
    setEmailVal(e.target.value)
  }
  const firstnameChange = (e: ChangeEvent<HTMLInputElement>) => {
    setfirstnameVal(e.target.value)
  }
  const lastnameChange = (e: ChangeEvent<HTMLInputElement>) => {
    setlastnameVal(e.target.value)
  }
  const pwdConfirmChange = (e: ChangeEvent<HTMLInputElement>) => {
    setpwdConfirmVal(e.target.value)
  }
  const universityChange = (e: ChangeEvent<HTMLInputElement>) => {
    setuniversityVal(e.target.value)
  }
  const universtiyIdChange = (e: ChangeEvent<HTMLInputElement>) => {
    setuniversityIdVal(e.target.value)
  }
  const password2Change = (e: ChangeEvent<HTMLInputElement>) => {
    setPassword2Val(e.target.value)
  }
  const tayChange = (e: ChangeEvent<HTMLInputElement>) => {
    settayVal(e.target.value)
  }

  const goregister = async () => {
    if (!username2Val.trim() || !password2Val.trim() || !emailVal.trim() || !firstnameVal.trim() || !lastnameVal.trim() || !pwdConfirmVal.trim() || !universityVal.trim() || !universityIdVal.trim() || !tayVal.trim()) {
      alert("please input information!")
    }
  }

  //login function
  let navigateto = useNavigate()
  const [usernameVal, setUsernameVal] = useState("");
  const [passwordVal, setPasswordVal] = useState("");
  const usernameChange = (e: ChangeEvent<HTMLInputElement>) => {
    setUsernameVal(e.target.value)
  }
  const passwordChange = (e: ChangeEvent<HTMLInputElement>) => {
    setPasswordVal(e.target.value)
  }
  const goLogin = async () => {
    if (!usernameVal.trim() || !passwordVal.trim()) {
      alert("please input information!")
    }
    let LoginAPIRes = await LoginAPI({
      username: usernameVal,
      password: passwordVal,
      code: "200",
      uuid: localStorage.getItem("uuid") as string
    })
    if (LoginAPIRes.code === 200) {
      alert("success login")
      localStorage.setItem("token", LoginAPIRes.token)
      navigateto("/landingpage")
      localStorage.removeItem("uuid")
    }

  }

  return (
    <div>
      <Background />
      <NavigationBar />
      <form onSubmit={(e) => e.preventDefault()}>
        <Input placeholder="university" className={classes.rectangle4} onChange={universityChange} />
        <Input.Password placeholder="password" className={classes.rectangle2} onChange={password2Change} />
        <Input.Password placeholder="password confirm" className={classes.rectangle7} onChange={pwdConfirmChange} />
        <Input placeholder="universityId" className={classes.rectangle5} onChange={universtiyIdChange} />
        <Input placeholder="email" className={classes.rectangle9} onChange={emailChange} />
        <Input placeholder="Talk about yourself" className={classes.rectangle6} onChange={tayChange} />
        <Input placeholder="firstname" className={classes.rectangle11} onChange={firstnameChange} />
        <Input placeholder="lastname" className={classes.rectangle12} onChange={lastnameChange} />
        <Input placeholder="username" className={classes.rectangle16} onChange={username2Change} />
      </form>
      <Button className={classes.signup}>
        <div className={classes.signUp} onClick={goregister}>Sign Up</div>
      </Button>
      <div className={classes.createAnAccount}>Create An Account</div>
      <div className={classes.line1}>
        <Line1Icon className={classes.icon} />
      </div>
      <div className={classes.oR}>OR</div>
      <div className={classes.line2}>
        <Line2Icon className={classes.icon2} />
      </div>
      <div className={classes.logIn}>Log In</div>
      <Link to='/reset' className={classes.forgotPassword}>forgot password?</Link>
      <Button className={classes.login} onClick={goLogin}>
        <div className={classes.logIn2}>Log in </div>
      </Button>
      <Input placeholder="user name" className={classes.rectangle17} onChange={usernameChange} />
      <Input.Password placeholder="password" className={classes.rectangle18} onChange={passwordChange} />
      <div className={classes.haveAnAccountAlready}>Have an account already ?</div>
      <div className={classes.rectangle20}>
        <Rectangle20Icon className={classes.icon3} />
      </div>
      <div className={classes.googleLogo}></div>
      <div className={classes.loginWithGoogle}>Login With Google</div>
      <div className={classes.rectangle15}></div>
      <div className={classes.facebookLogo}></div>
      <div className={classes.loginWithFacebook}>Login With Facebook</div>
    </div>
  );
});
