import { memo } from 'react';
import type { FC } from 'react';

import "reset-css";
import classes from './LandingPage.module.css';
import { Rectangle3Icon } from './Rectangle3Icon.js';
import { Rectangle5Icon } from './Rectangle5Icon.js';
import { Rectangle10Icon } from './Rectangle10Icon.js';
import { Rectangle11Icon } from './Rectangle11Icon.js';
import { Background } from '@/components/Background';
import NavigationBar from '@/components/NavigationBar';

interface Props {
  className?: string;
}
export const LandingPage: FC<Props> = memo(function LandingPage(props = {}) {
  return (
    <div>
      <Background />
      <NavigationBar />
      <div className={classes.source1}></div>
      <div className={classes.rectangle5}>
        <Rectangle5Icon className={classes.icon} />
      </div>
      <div className={classes.rectangle3}>
        <Rectangle3Icon className={classes.icon2} />
      </div>
      <div className={classes.beOneOfOurHostAndEnjoyEndlessN}>
        Be one of our host and enjoy endless night of fun in your place{' '}
      </div>
      <div className={classes.subheadline}>Click on Guest to know more</div>
      <button className={classes.button}>
        <div className={classes.host}>Host</div>
      </button>
      <div className={classes.rectangle11}>
        <Rectangle11Icon className={classes.icon3} />
      </div>
      <div className={classes.rectangle10}>
        <Rectangle10Icon className={classes.icon4} />
      </div>
      <div className={classes.subheadline2}>Click on Guest to know more</div>
      <div className={classes.comeJoinUsAndCelebrateOurWonde}>
        Come join us and celebrate our wonderful events in your area
      </div>
      <button className={classes.button2}>
        <div className={classes.join}>Join</div>
      </button>
      <div className={classes.footer2}>
        <div className={classes.divider}></div>
        <div className={classes.linkColumn}>
          <div className={classes.myFeedback}>My feedback</div>
          <div className={classes.myProfile}>My profile</div>
          <div className={classes.myEvent}>My event</div>
        </div>
        <div className={classes.linkColumn2}>
          <div className={classes.whoWeAre}>Who we are</div>
          <div className={classes.privacyPolicy}>Privacy policy</div>
          <div className={classes.termsAndConditions}>Terms and conditions</div>
        </div>
        <div className={classes.linkColumn3}>
          <div className={classes.contactUs}>Contact us</div>
          <div className={classes.ourValues}>Our values</div>
          <div className={classes.accessibility}>Accessibility</div>
        </div>
        <div className={classes.gSULibraryFour4CommonwealthBos}>
          <div className={classes.textBlock}>GSU Library, Four 4, Commonwealth,</div>
          <div className={classes.textBlock2}>Boston, MA</div>
        </div>
        <div className={classes.logo}></div>
        <div className={classes.hub}>Hub</div>
        <button className={classes.cartButton}>
          <div className={classes.signMeUp}>Sign me up</div>
        </button>
        <div className={classes.emailNewsletter}>Email Newsletter</div>
        <div className={classes.notificaionPreferences}>
          <div className={classes.emailMeAbout}>Email me about</div>
          <div className={classes.frame15119}>
            <div className={classes.radioSelection}>
              <div className={classes.upcomingEvents}>Upcoming events</div>
            </div>
            <div className={classes.radioSelection2}>
              <div className={classes.hostsAndThemes}>Hosts and themes</div>
            </div>
            <div className={classes.radioSelection3}>
              <div className={classes.everything}>Everything</div>
            </div>
          </div>
        </div>
        <div className={classes.formInput}></div>
      </div>
    </div>
  );
});
