import { memo, useState } from 'react';
import type { FC } from 'react';
import { Link } from "react-router-dom";
import { Input, Button } from 'antd';
import 'reset-css';
import classes from './ListOfEvent.module.css';
import { Rectangle16Icon } from './Rectangle16Icon.js';
import { Rectangle28Icon } from './Rectangle28Icon.js';
import { Rectangle29Icon } from './Rectangle29Icon.js';
import { getEventListByZipcode } from '@/requset/api.js';
import NavigationBar from '@/componets/NavigationBar.js';
import { Background } from '@/componets/Background.js';

interface Props {
  className?: string;
}
export const ListOfEvent: FC<Props> = memo(function ListOfEvent() {

  const [zip, setZip] = useState('');
  const [events, setEvent] = useState('');
  const handleZip = () => {
    setZip(zip);
  }
  const handleSubmit = () => {
    const eventData = {
      'zipCode': zip
    };
    getEventListByZipcode(eventData)
      .then((data) => {
        setEvent(JSON.parse(data));
      })
  }

  return (
    <div>
      <Background />
      <NavigationBar />
      {events.map((event) => {
           <>
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
             <div className={classes.textBlock}>Event </div>
             <div className={classes.textBlock2} style={{display : 'flex' , flexDirection : 'column' , gap : '40px' , overflow : "scroll" , height : '120px'
            }}>
               <p>Event ID : {event.eventId}</p>
               <p>Event Name : {event.eventName}</p>
               <p>Event Date : {event.eventDate}</p>
               <p>Event Location : {event.location}</p>
               <p>Event Zip : {event.zipCode}</p>
               <p>Event Details : {event.eventDetails}</p>
             </div>
           </div>
         </>
      })}
      <>
        <div className={classes.rectangle28}>
          <Rectangle28Icon className={classes.icon} />
        </div>
        <div className={classes.rectangle29}>
          <Rectangle29Icon className={classes.icon2} />
        </div>
        <div className={classes.rectangle16}>
          <Rectangle16Icon className={classes.icon3} />
        </div>
        <Link to="/attend" className={classes.moreInfo} data={events}>More Info</Link>
        <div className={classes.event1}>
          <div className={classes.textBlock}>Event </div>
          <div className={classes.textBlock2}>
            <p></p>
          </div>
        </div>
      </>
      <div className={classes.enterZipCodeForAnEvent} style={{ display: 'flex', flexDirection: 'row' , gap : '30px' }}>
        <Input placeholder="Please enter the zipcode"  onChange={handleZip} />
        <Button onClick={handleSubmit}>Submit</Button>
      </div>
      <div className={classes.eventsAvailable}>events available:</div>
    </div>
  );
});
