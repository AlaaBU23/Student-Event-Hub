import { memo } from 'react';
import type { FC } from 'react';

import 'reset-css';
import classes from './AttendPage.module.css';
import { Rectangle12Icon } from './Rectangle12Icon.js';
import { Rectangle13Icon } from './Rectangle13Icon.js';
import { Rectangle14Icon } from './Rectangle14Icon.js';
import { Rectangle15Icon } from './Rectangle15Icon.js';
import { Rectangle17Icon } from './Rectangle17Icon.js';
import { Rectangle18Icon } from './Rectangle18Icon.js';
import { TimeLeftAreaIcon } from './TimeLeftAreaIcon.js';
import { Background } from '@/components/Background.js';
import NavigationBar from '@/components/NavigationBar.js';

interface Props {
  className?: string;
}
export const AttendPage: FC<Props> = memo(function AttendPage(props = {}) {
  return (
    <div>
      <Background />
      <NavigationBar />
      <div className={classes.rectangle17}>
        <Rectangle17Icon className={classes.icon} />
      </div>
      <div className={classes.rectangle18}>
        <Rectangle18Icon className={classes.icon2} />
      </div>
      <div className={classes.contactWithHost}>Contact with host</div>
      <div className={classes.rectangle14}>
        <Rectangle14Icon className={classes.icon3} />
      </div>
      <div className={classes.rectangle15}>
        <Rectangle15Icon className={classes.icon4} />
      </div>
      <div className={classes.eventDetails}>Event details</div>
      <div className={classes.rectangle12}>
        <Rectangle12Icon className={classes.icon5} />
      </div>
      <div className={classes.rectangle13}>
        <Rectangle13Icon className={classes.icon6} />
      </div>
      <div className={classes.frame15205}>
        <div className={classes.eventName}>Event Name</div>
        <div className={classes.dateAndTime}>Date and Time</div>
        <div className={classes.address}>Address</div>
        <div className={classes.zipCode}>Zip Code</div>
      </div>
      <div className={classes.join}>
        <div className={classes.join2}>Join</div>
      </div>
      <div className={classes.timeLeftArea}>
        <TimeLeftAreaIcon className={classes.icon7} />
      </div>
      <div className={classes.joinAnEvent}>Join An Event</div>
      <div className={classes.hereAreTheEventDetails}>Here are the event details:</div>
    </div>
  );
});
