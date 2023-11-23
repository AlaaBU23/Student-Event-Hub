import { memo } from 'react';
import type { FC } from 'react';

import 'reset-css';
import classes from './ResetPage.module.css';
import { Rectangle18Icon } from './Rectangle18Icon.js';
import { Background } from '@/components/Background.js';
import NavigationBar from '@/components/NavigationBar.js';

interface Props {
  className?: string;
}
export const ResetPage: FC<Props> = memo(function ResetPage(props = {}) {
  return (
    <>
      <Background />
      <NavigationBar />
      <div className={classes.frame15206}>
        <div className={classes.enterYourEmailToResetYourPassw}>Enter Your Email To Reset Your Password</div>
        <div className={classes.rectangle18}>
          <Rectangle18Icon className={classes.icon} />
        </div>
        <button className={classes.button}>
          <div className={classes.send}>Send</div>
        </button>
      </div>
    </>
  );
});
