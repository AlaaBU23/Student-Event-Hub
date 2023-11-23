import { memo } from 'react';
import type { FC } from 'react';

import 'reset-css';
import { Rectangle12Icon2 } from './Rectangle12Icon2.js';
import { Rectangle12Icon3 } from './Rectangle12Icon3.js';
import { Rectangle12Icon } from './Rectangle12Icon.js';
import { Rectangle13Icon2 } from './Rectangle13Icon2.js';
import { Rectangle13Icon3 } from './Rectangle13Icon3.js';
import { Rectangle13Icon } from './Rectangle13Icon.js';
import classes from './RequestForApplication.module.css';
import { Background } from '@/components/Background.js';
import NavigationBar from '@/components/NavigationBar.js';

interface Props {
  className?: string;
}
export const RequestForApplication: FC<Props> = memo(function RequestForApplication(props = {}) {
  return (
    <div>
      <Background />
      <NavigationBar />
      <div className={classes.frame15206}>
        <div className={classes.group13}>
          <div className={classes.rectangle12}>
            <Rectangle12Icon className={classes.icon} />
          </div>
          <div className={classes.rectangle13}>
            <Rectangle13Icon className={classes.icon2} />
          </div>
          <div className={classes.image72}></div>
          <button className={classes.button}></button>
          <div className={classes.accept}>Accept</div>
          <button className={classes.button2}></button>
          <div className={classes.reject}>Reject</div>
        </div>
        <div className={classes.group59}>
          <div className={classes.rectangle122}>
            <Rectangle12Icon2 className={classes.icon3} />
          </div>
          <div className={classes.rectangle132}>
            <Rectangle13Icon2 className={classes.icon4} />
          </div>
          <div className={classes.image722}></div>
          <button className={classes.button3}></button>
          <div className={classes.accept2}>Accept</div>
          <button className={classes.button4}></button>
          <div className={classes.reject2}>Reject</div>
        </div>
        <div className={classes.group60}>
          <div className={classes.rectangle123}>
            <Rectangle12Icon3 className={classes.icon5} />
          </div>
          <div className={classes.rectangle133}>
            <Rectangle13Icon3 className={classes.icon6} />
          </div>
          <div className={classes.image723}></div>
          <button className={classes.button5}></button>
          <div className={classes.accept3}>Accept</div>
          <button className={classes.button6}></button>
          <div className={classes.reject3}>Reject</div>
        </div>
      </div>
      <div className={classes.requestForApplication}>Request For Application</div>
    </div>
  );
});
