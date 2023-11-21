import { memo } from 'react';
import type { FC } from 'react';

import { Frame15203Icon } from './Frame15203Icon.js';
import classes from './Group29.module.css';
import { Background } from '@/componets/Background.js';
import NavigationBar from '@/componets/NavigationBar.js';

interface Props {
  className?: string;
}
/* @figmaId 660:2600 */
export const WhoWeArePage: FC<Props> = memo(function Group29(props = {}) {
  return (
    <>
      <Background />
      <NavigationBar />
      <div className={classes.frame15203}>
        <Frame15203Icon className={classes.icon} />
      </div>
      <div className={classes.whoWeAre}>Who we are ? </div>
      <div className={classes.weProposeTheDevelopmentOfAnEve}>
        <div className={classes.textBlock}>
          We propose the development of an Event Listing Platform for students that caters to both event hosts and
          attendees.{' '}
        </div>
        <div className={classes.textBlock2}>
          <p></p>
        </div>
        <div className={classes.textBlock3}>
          This platform will serve as a centralized hub where they can list their events, manage attendees, and promote
          their gatherings, and later the attendees can rate the host based on the environment presented for the
          attendees, management of the event, etc.{' '}
        </div>
        <div className={classes.textBlock4}>
          <p></p>
        </div>
        <div className={classes.textBlock5}>
          This project aims to simplify event management and attendance, fostering a vibrant event community
        </div>
      </div>
    </>
  );
});
