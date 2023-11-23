import { memo } from 'react';
import type { FC } from 'react';
import { Input, Button } from 'antd';
import 'reset-css';
import classes from './PostEventPage.module.css';
import { Rectangle12Icon } from './Rectangle12Icon.js';
import { Rectangle13Icon } from './Rectangle13Icon.js';
import { Rectangle14Icon } from './Rectangle14Icon.js';
import { Rectangle15Icon } from './Rectangle15Icon.js';
import NavigationBar from '@/components/NavigationBar.js';
import { Background } from '@/components/Background.js';

interface Props {
  className?: string;
}
export const PostEventPage: FC<Props> = memo(function PostEventPage(props = {}) {
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
      <Input type = "test" placeholder='Please input here' className={classes.detailsInput} />
      <div className={classes.rectangle12}>
        <Rectangle12Icon className={classes.icon3} />
      </div>
      <div className={classes.rectangle13}>
        <Rectangle13Icon className={classes.icon4} />
      </div>
      <div className={classes.address}>Address:</div>
      <Input placeholder='Please input here' className={classes.addressInput} />
      <div className={classes.dateAndTime}>Date and Time:</div>
      <Input placeholder='Please input here' className={classes.dateInput} />
      <div className={classes.eventName}>Event name:</div>
      <Input placeholder='Please input here' className={classes.nameInput} />
      <div className={classes.zipCode}>Zip Code:</div>
      <Input placeholder='Please input here' className={classes.zipcodeInput} />
      <div className={classes.post}>
        <div className={classes.post2}>Post</div>
      </div>
      <div className={classes.pleaseIntroduceTheDetailsForYo}>Please introduce the details for your next event:</div>
      <div className={classes.createAnEvent}>Create An Event</div>
    </div>
  );
});
