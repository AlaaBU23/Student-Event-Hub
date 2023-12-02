import { Link } from "react-router-dom";
import { Input, Button } from 'antd';
import React, { useState, useEffect } from 'react';

import 'reset-css';
import classes from './ListOfEvent.module.css';
import { Rectangle16Icon2 } from './Rectangle16Icon2.js';
import { Rectangle16Icon3 } from './Rectangle16Icon3.js';
import { Rectangle16Icon4 } from './Rectangle16Icon4.js';
import { Rectangle16Icon5 } from './Rectangle16Icon5.js';
import { Rectangle16Icon6 } from './Rectangle16Icon6.js';
import { Rectangle16Icon } from './Rectangle16Icon.js';
import { Rectangle28Icon2 } from './Rectangle28Icon2.js';
import { Rectangle28Icon3 } from './Rectangle28Icon3.js';
import { Rectangle28Icon4 } from './Rectangle28Icon4.js';
import { Rectangle28Icon5 } from './Rectangle28Icon5.js';
import { Rectangle28Icon6 } from './Rectangle28Icon6.js';
import { Rectangle28Icon } from './Rectangle28Icon.js';
import { Rectangle29Icon2 } from './Rectangle29Icon2.js';
import { Rectangle29Icon3 } from './Rectangle29Icon3.js';
import { Rectangle29Icon4 } from './Rectangle29Icon4.js';
import { Rectangle29Icon5 } from './Rectangle29Icon5.js';
import { Rectangle29Icon6 } from './Rectangle29Icon6.js';
import { Rectangle29Icon } from './Rectangle29Icon.js';

import NavigationBar from '@/componets/NavigationBar.js';
import { Background } from '@/componets/Background.js';

interface Event {
  id: string;
  title: string;
  description: string;
}

export const ListOfEvent: React.FC = () => {

  const [events, setEvents] = useState<Event[]>([]);

  useEffect(() => {
    fetch('your-backend-endpoint/events/random?count=6')
      .then((response) => response.json())
      .then((data: Event[]) => {
        setEvents(data);
      })
      .catch((error) => {
        console.error('Error fetching events:', error);
      });
  }, []);

  return (
    <div>
      <Background />
      <NavigationBar />
      <div className={classes.rectangle28}>
        <Rectangle28Icon className={classes.icon} />
      </div>
      <div className={classes.rectangle29}>
        <Rectangle29Icon className={classes.icon2} />
      </div>
      <div className={classes.rectangle16}>
        <Rectangle16Icon className={classes.icon3} />
      </div>
      <Link to="/attend" className={classes.moreInfo}>More Info</Link>
      <div className={classes.event1}>
        <div className={classes.textBlock}>Event 1:</div>
        <div className={classes.textBlock2}>
          <p></p>
        </div>
      </div>
      {events.map((event) => (
        <div className={classes.rectangle282}>
          <Rectangle28Icon2 className={classes.icon4} />
        </div>
        // <div className={classes.rectangle292}>
        //   <Rectangle29Icon2 className={classes.icon5} />
        // </div>
        // <div className={classes.rectangle162}>
        //   <Rectangle16Icon2 className={classes.icon6} />
        // </div>
        // <div className={classes.moreInfo2}>More Info</div>
        // <div className={classes.event12}>
        //   <div className={classes.textBlock3}>Event 1:</div>
        //   <div className={classes.textBlock4}>
        //     <p>{event.description}</p>
        //   </div>
        // </div>
      ))}
      <div className={classes.rectangle283}>
        <Rectangle28Icon3 className={classes.icon7} />
      </div>
      <div className={classes.rectangle293}>
        <Rectangle29Icon3 className={classes.icon8} />
      </div>
      <div className={classes.rectangle163}>
        <Rectangle16Icon3 className={classes.icon9} />
      </div>
      <div className={classes.moreInfo3}>More Info</div>
      <div className={classes.event13}>
        <div className={classes.textBlock5}>Event 1:</div>
        <div className={classes.textBlock6}>
          <p></p>
        </div>
      </div>
      <div className={classes.rectangle284}>
        <Rectangle28Icon4 className={classes.icon10} />
      </div>
      <div className={classes.rectangle294}>
        <Rectangle29Icon4 className={classes.icon11} />
      </div>
      <div className={classes.rectangle164}>
        <Rectangle16Icon4 className={classes.icon12} />
      </div>
      <div className={classes.moreInfo4}>More Info</div>
      <div className={classes.event14}>
        <div className={classes.textBlock7}>Event 1:</div>
        <div className={classes.textBlock8}>
          <p></p>
        </div>
      </div>
      <div className={classes.rectangle285}>
        <Rectangle28Icon5 className={classes.icon13} />
      </div>
      <div className={classes.rectangle295}>
        <Rectangle29Icon5 className={classes.icon14} />
      </div>
      <div className={classes.rectangle165}>
        <Rectangle16Icon5 className={classes.icon15} />
      </div>
      <div className={classes.moreInfo5}>More Info</div>
      <div className={classes.event15}>
        <div className={classes.textBlock9}>Event 1:</div>
        <div className={classes.textBlock10}>
          <p></p>
        </div>
      </div>
      <div className={classes.rectangle286}>
        <Rectangle28Icon6 className={classes.icon16} />
      </div>
      <div className={classes.rectangle296}>
        <Rectangle29Icon6 className={classes.icon17} />
      </div>
      <div className={classes.rectangle166}>
        <Rectangle16Icon6 className={classes.icon18} />
      </div>
      <div className={classes.moreInfo6}>More Info</div>
      <div className={classes.event16}>
        <div className={classes.textBlock11}>Event 1:</div>
        <div className={classes.textBlock12}>
          <p></p>
        </div>
      </div>
      <div className={classes.image3}></div>
      <Input placeholder='Enter Zip-Code for an Event' className={classes.enterZipCodeForAnEvent} />
      <div className={classes.eventsAvailable}>events available:</div>
    </div>
  );
};
