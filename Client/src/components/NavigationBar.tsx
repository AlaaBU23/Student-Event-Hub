import React, { Component } from "react";
import "reset-css";
import { Link } from "react-router-dom";
import classes from "./Header.module.css";

class NavigationBar extends React.Component {
  render() {
    return (
      <div>
        <div className={classes.navLinks}>
          <Link to="/events" className={classes.events}>Events</Link>
          <Link to="/postevent" className={classes.host} >Host</Link>
          <Link to="/who" className={classes.whoWeAre}>Who We Are</Link>
          <Link to="/profile" className={classes.myProfile}>My profile</Link>
          <Link to="/signin" className={`${classes.registerSignIn} ${classes.cartButton}`}>Register / Sign in</Link>
        </div>
        <Link to="/landingpage" className={classes.logo}></Link>
        <div className={classes.hub}>Hub</div>
        <div className={classes.image2}></div>
        <div className={classes.image5}></div>
      </div>
    )
  }
}

export default NavigationBar;