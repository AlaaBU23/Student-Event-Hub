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
import { useSelector, useDispatch } from 'react-redux';
import { LoginAPI, registerUser } from '@/requset/api.js'

interface Props {
  className?: string;
}

export const SignInPage: FC<Props> = memo(function SignInPage(props = {}) {
  //register function
  const [formData, setFormData] = useState({
    firstname: '',
    lastname: '',
    email: '',
    username: '',
    password: '',
    pwdConfirm: '',
    university: '',
    universityId: '',
    tay: '',
  })
  const handlChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    setFormData(prevState => ({ ...prevState, [name]: value }))
  }
  const handleSubmit = async () => {
    try {
      const response = await registerUser(formData);
      // Handle further success (e.g., redirecting to a login page)
      if (!formData.email || !formData.firstname || !formData.lastname || !formData.password || !formData.pwdConfirm || !formData.tay || !formData.university || !formData.universityId || !formData.username) {
        alert('complete informations')
      }
      if (formData.password !== formData.pwdConfirm) {
        alert("Two passwords don't match")
      }
      console.log('Registration successful', response);
    } catch (error) {
      console.error('Registration failed', error);
      // Handle the error appropriately
    }
  };

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
        <Input placeholder="university" className={classes.rectangle4} value={formData.university} onChange={handlChange} />
        <Input.Password placeholder="password" className={classes.rectangle2} value={formData.password} onChange={handlChange} />
        <Input.Password placeholder="password confirm" className={classes.rectangle7} value={formData.pwdConfirm} onChange={handlChange} />
        <Input placeholder="universityId" className={classes.rectangle5} value={formData.universityId} onChange={handlChange} />
        <Input placeholder="email" className={classes.rectangle9} value={formData.email} onChange={handlChange} />
        <Input placeholder="Talk about yourself" className={classes.rectangle6} value={formData.tay} onChange={handlChange} />
        <Input placeholder="firstname" className={classes.rectangle11} value={formData.firstname} onChange={handlChange} />
        <Input placeholder="lastname" className={classes.rectangle12} value={formData.lastname} onChange={handlChange} />
        <Input placeholder="username" className={classes.rectangle16} value={formData.username} onChange={handlChange} />
      </form>
      <Button className={classes.signup}>
        <div className={classes.signUp} onClick={handleSubmit}>Sign Up</div>
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
