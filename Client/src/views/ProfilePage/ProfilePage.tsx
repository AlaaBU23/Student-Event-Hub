import { memo } from 'react';
import type { FC } from 'react';
import { Link } from "react-router-dom";

import 'reset-css';
import { Event } from './Event/Event.js';
import classes from './ProfilePage.module.css';
import { Background } from '@/componets/Background.js';
import NavigationBar from '@/componets/NavigationBar.js';
import { Typography } from 'antd';

interface Props {
  className?: string;
  hide?: {
    event1?: boolean;
    rectangle16?: boolean;
    moreInfo?: boolean;
    event12?: boolean;
    rectangle162?: boolean;
    moreInfo2?: boolean;
    event13?: boolean;
    rectangle163?: boolean;
    moreInfo3?: boolean;
    event14?: boolean;
    rectangle164?: boolean;
    moreInfo4?: boolean;
    event15?: boolean;
    rectangle165?: boolean;
    moreInfo5?: boolean;
    event16?: boolean;
    rectangle166?: boolean;
    moreInfo6?: boolean;
  };
}
/* @figmaId 739:2321 */
export const ProfilePage: FC<Props> = memo(function ProfilePage(props = {}) {
  return (
    <>
      <Background />
      <NavigationBar />
      <div className={classes.rectangle9}></div>
      <div className={classes.rate}>RATE HOST OR ATTENDEES</div>
      <Link to="/rate" className={classes.ratebutton}>RATE</Link>
      <div className={classes.rectangle7}></div>
      <div className={classes.rectangle30}>
        <div className={classes.textBlockFirstName}>FirstName:
          <Typography>
            {localStorage.getItem('firstName')}
          </Typography>
        </div>
        <div className={classes.textBlockLastName}>LastName:
          <Typography>{localStorage.getItem('lastName')}</Typography>
        </div>
        <div className={classes.textBlockUniversity}>University:
          <Typography>{localStorage.getItem('university')}</Typography>
        </div>
        <div className={classes.textBlockEmail}>Email:
          <Typography>{localStorage.getItem('email')}</Typography>
        </div>
      </div>
      <div className={classes.recentAttendedEvents}>Recent Attended Events</div>
      <Event
        className={classes.event}
        hide={{
          event1: true,
          rectangle16: true,
          moreInfo: true,
        }}
      />
      <Event
        className={classes.event2}
        hide={{
          event1: true,
          rectangle16: true,
          moreInfo: true,
        }}
      />
      <div className={classes.event1}>
        <div className={classes.textBlock}>Event 1:</div>
        <div className={classes.textBlock2}>
          <p></p>
        </div>
      </div>
      <Event
        className={classes.event3}
        hide={{
          event1: true,
          rectangle16: true,
          moreInfo: true,
        }}
      />
      <Event
        className={classes.event4}
        hide={{
          event1: true,
          rectangle16: true,
          moreInfo: true,
        }}
      />
      <Event
        className={classes.event5}
        hide={{
          event1: true,
          rectangle16: true,
          moreInfo: true,
        }}
      />
      <div className={classes.event12}>
        <div className={classes.textBlock3}>Event 1:</div>
        <div className={classes.textBlock4}>
          <p></p>
        </div>
      </div>
      <Event
        className={classes.event6}
        hide={{
          event1: true,
          rectangle16: true,
          moreInfo: true,
        }}
      />
      <div className={classes.event22}>
        <div className={classes.textBlock5}>Event 2:</div>
        <div className={classes.textBlock6}>
          <p></p>
        </div>
      </div>
      <div className={classes.event32}>
        <div className={classes.textBlock7}>Event 3:</div>
        <div className={classes.textBlock8}>
          <p></p>
        </div>
      </div>
      <div className={classes.event23}>
        <div className={classes.textBlock9}>Event 2:</div>
        <div className={classes.textBlock10}>
          <p></p>
        </div>
      </div>
      <div className={classes.event33}>
        <div className={classes.textBlock11}>Event 3:</div>
        <div className={classes.textBlock12}>
          <p></p>
        </div>
      </div>
      <Link to="/eventinfo" className={classes.cartButton}>
        <div className={classes.moreInfo}>More Info</div>
      </Link>
      <Link to="/eventinfo" className={classes.cartButton2}>
        <div className={classes.moreInfo2}>More Info</div>
      </Link>
      <Link to="/eventinfo" className={classes.cartButton3}>
        <div className={classes.moreInfo3}>More Info</div>
      </Link>
      <Link to="/eventinfo" className={classes.cartButton4}>
        <div className={classes.moreInfo4}>More Info</div>
      </Link>
      <Link to="/eventinfo" className={classes.cartButton5}>
        <div className={classes.moreInfo5}>More Info</div>
      </Link>
      <Link to="/eventinfo" className={classes.cartButton6}>
        <div className={classes.moreInfo6}>More Info</div>
      </Link>
      <div className={classes.recentCreatedEvents}>Recent Created Events</div>
      <button className={classes.cartButton7}>
        <div className={classes.image72}></div>
      </button>
    </>
  );
});
