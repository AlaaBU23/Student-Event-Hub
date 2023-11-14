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
import { Link } from "react-router-dom";


interface Props {
  className?: string;
}
export const SignInPage: FC<Props> = memo(function SignInPage(props = {}) {
  return (
    <div>
      <Background />
      <NavigationBar />
      <div className={classes.rectangle4}></div>
      <div className={classes.rectangle2}></div>
      <div className={classes.rectangle7}></div>
      <div className={classes.rectangle5}></div>
      <div className={classes.rectangle9}></div>
      <div className={classes.rectangle6}></div>
      <Input placeholder="firstname" className={classes.rectangle11} />
      <Input placeholder="lastname" className={classes.rectangle12} />
      <div className={classes.rectangle3}></div>
      <div className={classes.rectangle16}></div>
      <Button className={classes.signup}>
        <div className={classes.signUp}>Sign Up</div>
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
      <Button className={classes.login}>
        <div className={classes.logIn2}>Log in </div>
      </Button>
      <Input placeholder="user name" className={classes.rectangle17} />
      <Input.Password placeholder="password" className={classes.rectangle18} />
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
