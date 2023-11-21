import { memo } from 'react';
import type { FC } from 'react';

import 'reset-css';
import classes from './Event.module.css';
import { Rectangle16Icon } from './Rectangle16Icon.js';
import { Rectangle28Icon } from './Rectangle28Icon.js';
import { Rectangle29Icon } from './Rectangle29Icon.js';

interface Props {
  className?: string;
  classes?: {
    root?: string;
  };
  hide?: {
    event1?: boolean;
    rectangle16?: boolean;
    moreInfo?: boolean;
  };
}
/* @figmaId 62:1119 */
export const Event: FC<Props> = memo(function Event(props = {}) {
  return (
    <div className={`${props.classes?.root || ''} ${props.className || ''} ${classes.root}`}>
      <div className={classes.rectangle28}>
        <Rectangle28Icon className={classes.icon} />
      </div>
      <div className={classes.rectangle29}>
        <Rectangle29Icon className={classes.icon2} />
      </div>
      {!props.hide?.event1 && (
        <div className={classes.event1}>
          <div className={classes.textBlock}>Event 1:</div>
          <div className={classes.textBlock2}>
            <p></p>
          </div>
        </div>
      )}
      {!props.hide?.rectangle16 && (
        <div className={classes.rectangle16}>
          <Rectangle16Icon className={classes.icon3} />
        </div>
      )}
      {!props.hide?.moreInfo && <div className={classes.moreInfo}>More Info</div>}
    </div>
  );
});
