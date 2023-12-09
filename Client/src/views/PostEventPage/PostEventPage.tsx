import { memo } from 'react';
import type { FC } from 'react';
import { Input, Button } from 'antd';
import 'reset-css';
import classes from './PostEventPage.module.css';
import { Rectangle12Icon } from './Rectangle12Icon.js';
import { Rectangle13Icon } from './Rectangle13Icon.js';
import { Rectangle14Icon } from './Rectangle14Icon.js';
import { Rectangle15Icon } from './Rectangle15Icon.js';
import NavigationBar from '@/componets/NavigationBar.js';
import { Background } from '@/componets/Background.js';
import { ChangeEvent, useState } from 'react'

interface Props {
  className?: string;
}
export const PostEventPage: FC<Props> = memo(function PostEventPage(props = {}) {

  const [eventnameVal, seteventnameVal] = useState("");
  const [datatimeVal, setDataTimeVal] = useState("");
  const [addressVal, setaddressVal] = useState("");
  const [zipcodeVal, setzipcodeVal] = useState("");
  const [eventdetailsVal, seteventdetailsVal] = useState("");

  const eventnameChange = (e: ChangeEvent<HTMLInputElement>) => {
    seteventnameVal(e.target.value)
  }
  const DataTimeChange = (e: ChangeEvent<HTMLInputElement>) => {
    setDataTimeVal(e.target.value)
  }
  const addressChange = (e: ChangeEvent<HTMLInputElement>) => {
    setaddressVal(e.target.value)
  }
  const zipcodeChange = (e: ChangeEvent<HTMLInputElement>) => {
    setzipcodeVal(e.target.value)
  }
  const eventdetailsChange = (e: ChangeEvent<HTMLInputElement>) => {
    seteventdetailsVal(e.target.value)
  }

  const gopost = async () => {
    if (!eventnameVal.trim() || !datatimeVal.trim() || !addressVal.trim() || !zipcodeVal.trim() || !eventdetailsVal.trim()) {
      alert('please input information')
    }
  }
  return (
    <div>
      <Background />
      <NavigationBar />
      <div className={classes.rectangle14}>
        <Rectangle14Icon className={classes.icon} />
      </div>
      <div className={classes.rectangle15}>
        <Rectangle15Icon className={classes.icon2} />
      </div>
      <div className={classes.eventDetails}>Event details:</div>
      <Input placeholder='Please input here' className={classes.input5} onChange={eventdetailsChange} />
      <div className={classes.rectangle12}>
        <Rectangle12Icon className={classes.icon3} />
      </div>
      <div className={classes.rectangle13}>
        <Rectangle13Icon className={classes.icon4} />
      </div>
      <div className={classes.address}>Address:</div>
      <Input placeholder='Please input here' className={classes.input1} onChange={eventnameChange} />
      <div className={classes.dateAndTime}>Date and Time:</div>
      <Input placeholder='Please input here' className={classes.input2} onChange={DataTimeChange} />
      <div className={classes.eventName}>Event name:</div>
      <Input placeholder='Please input here' className={classes.input3} onChange={addressChange} />
      <div className={classes.zipCodeID}>Zip Code ID:</div>
      <Input placeholder='Please input here' className={classes.input4} onChange={zipcodeChange} />
      <Button className={classes.post} onClick={gopost}>
        <div className={classes.post2} >Post</div>
      </Button>
      <div className={classes.pleaseIntroduceTheDetailsForYo}>Please introduce the details for your next event:</div>
      <div className={classes.createAnEvent}>Create An Event</div>
    </div>
  );
});
