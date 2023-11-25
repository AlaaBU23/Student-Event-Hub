import { memo } from 'react';
import type { FC } from 'react';

import 'reset-css';
import classes from './Rating.module.css';
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
import { Background } from '@/componets/Background.js';
import NavigationBar from '@/componets/NavigationBar.js';

interface Props {
  className?: string;
}
export const Rating: FC<Props> = memo(function Rating(props = {}) {
  return (
    <div className={`${classes.root}`}>
      <Background />
      <NavigationBar />
      <div className={classes.rectangle28}>
        <Rectangle28Icon className={classes.icon} />
      </div>
      <div className={classes.rectangle29}>
        <Rectangle29Icon className={classes.icon2} />
      </div>
      <div className={classes.name}>Name</div>
      <button className={classes.button}></button>
      <div className={classes.r1}></div>
      <div className={classes.r2}></div>
      <div className={classes.r3}></div>
      <div className={classes._3Star}>3 star</div>
      <button className={classes.button2}></button>
      <div className={classes.r12}></div>
      <div className={classes.r22}></div>
      <div className={classes.r32}></div>
      <div className={classes.r4}></div>
      <div className={classes.r5}></div>
      <div className={classes._5Star}>5 star</div>
      <button className={classes.button3}></button>
      <div className={classes.r13}></div>
      <div className={classes._1Star}>1 star</div>
      <button className={classes.button4}></button>
      <div className={classes.r23}></div>
      <div className={classes.r33}></div>
      <div className={classes.r42}></div>
      <div className={classes.r52}></div>
      <div className={classes._4Star}>4 star</div>
      <button className={classes.button5}></button>
      <button className={classes.button6}></button>
      <div className={classes.r14}></div>
      <div className={classes.r24}></div>
      <div className={classes._2Star}>2 star</div>
      <div className={classes.rectangle282}>
        <Rectangle28Icon2 className={classes.icon3} />
      </div>
      <div className={classes.rectangle292}>
        <Rectangle29Icon2 className={classes.icon4} />
      </div>
      <div className={classes.name2}>
        <div className={classes.textBlock}>Name</div>
        <div className={classes.textBlock2}>
          <p></p>
        </div>
      </div>
      <button className={classes.button7}></button>
      <div className={classes.r15}></div>
      <div className={classes.r25}></div>
      <div className={classes.r34}></div>
      <div className={classes._3Star2}>3 star</div>
      <button className={classes.button8}></button>
      <div className={classes.r16}></div>
      <div className={classes.r26}></div>
      <div className={classes.r35}></div>
      <div className={classes.r43}></div>
      <div className={classes.r53}></div>
      <div className={classes._5Star2}>5 star</div>
      <button className={classes.button9}></button>
      <div className={classes.r17}></div>
      <div className={classes._1Star2}>1 star</div>
      <button className={classes.button10}></button>
      <div className={classes.r27}></div>
      <div className={classes.r36}></div>
      <div className={classes.r44}></div>
      <div className={classes.r54}></div>
      <div className={classes._4Star2}>4 star</div>
      <button className={classes.button11}></button>
      <button className={classes.button12}></button>
      <div className={classes.r18}></div>
      <div className={classes.r28}></div>
      <div className={classes._2Star2}>2 star</div>
      <div className={classes.rectangle283}>
        <Rectangle28Icon3 className={classes.icon5} />
      </div>
      <div className={classes.rectangle293}>
        <Rectangle29Icon3 className={classes.icon6} />
      </div>
      <div className={classes.name3}>Name</div>
      <button className={classes.button13}></button>
      <div className={classes.r19}></div>
      <div className={classes.r29}></div>
      <div className={classes.r37}></div>
      <div className={classes._3Star3}>3 star</div>
      <button className={classes.button14}></button>
      <div className={classes.r110}></div>
      <div className={classes.r210}></div>
      <div className={classes.r38}></div>
      <div className={classes.r45}></div>
      <div className={classes.r55}></div>
      <div className={classes._5Star3}>5 star</div>
      <button className={classes.button15}></button>
      <div className={classes.r111}></div>
      <div className={classes._1Star3}>1 star</div>
      <button className={classes.button16}></button>
      <div className={classes.r211}></div>
      <div className={classes.r39}></div>
      <div className={classes.r46}></div>
      <div className={classes.r56}></div>
      <div className={classes._4Star3}>4 star</div>
      <button className={classes.button17}></button>
      <button className={classes.button18}></button>
      <div className={classes.r112}></div>
      <div className={classes.r212}></div>
      <div className={classes._2Star3}>2 star</div>
      <div className={classes.rectangle284}>
        <Rectangle28Icon4 className={classes.icon7} />
      </div>
      <div className={classes.rectangle294}>
        <Rectangle29Icon4 className={classes.icon8} />
      </div>
      <div className={classes.name4}>
        <div className={classes.textBlock3}>Name:</div>
        <div className={classes.textBlock4}>
          <p></p>
        </div>
      </div>
      <button className={classes.button19}></button>
      <div className={classes.r113}></div>
      <div className={classes.r213}></div>
      <div className={classes.r310}></div>
      <div className={classes._3Star4}>3 star</div>
      <button className={classes.button20}></button>
      <div className={classes.r114}></div>
      <div className={classes.r214}></div>
      <div className={classes.r311}></div>
      <div className={classes.r47}></div>
      <div className={classes.r57}></div>
      <div className={classes._5Star4}>5 star</div>
      <button className={classes.button21}></button>
      <div className={classes.r115}></div>
      <div className={classes._1Star4}>1 star</div>
      <button className={classes.button22}></button>
      <div className={classes.r215}></div>
      <div className={classes.r312}></div>
      <div className={classes.r48}></div>
      <div className={classes.r58}></div>
      <div className={classes._4Star4}>4 star</div>
      <button className={classes.button23}></button>
      <button className={classes.button24}></button>
      <div className={classes.r116}></div>
      <div className={classes.r216}></div>
      <div className={classes._2Star4}>2 star</div>
      <div className={classes.rectangle285}>
        <Rectangle28Icon5 className={classes.icon9} />
      </div>
      <div className={classes.rectangle295}>
        <Rectangle29Icon5 className={classes.icon10} />
      </div>
      <div className={classes.name5}>name:</div>
      <button className={classes.button25}></button>
      <div className={classes.r117}></div>
      <div className={classes.r217}></div>
      <div className={classes.r313}></div>
      <div className={classes._3Star5}>3 star</div>
      <button className={classes.button26}></button>
      <div className={classes.r118}></div>
      <div className={classes.r218}></div>
      <div className={classes.r314}></div>
      <div className={classes.r49}></div>
      <div className={classes.r59}></div>
      <div className={classes._5Star5}>5 star</div>
      <button className={classes.button27}></button>
      <div className={classes.r119}></div>
      <div className={classes._1Star5}>1 star</div>
      <button className={classes.button28}></button>
      <div className={classes.r219}></div>
      <div className={classes.r315}></div>
      <div className={classes.r410}></div>
      <div className={classes.r510}></div>
      <div className={classes._4Star5}>4 star</div>
      <button className={classes.button29}></button>
      <button className={classes.button30}></button>
      <div className={classes.r120}></div>
      <div className={classes.r220}></div>
      <div className={classes._2Star5}>2 star</div>
      <div className={classes.rectangle286}>
        <Rectangle28Icon6 className={classes.icon11} />
      </div>
      <div className={classes.rectangle296}>
        <Rectangle29Icon6 className={classes.icon12} />
      </div>
      <div className={classes.moreInfo}>More Info</div>
      <div className={classes.name6}>
        <div className={classes.textBlock5}>name:</div>
        <div className={classes.textBlock6}>
          <p></p>
        </div>
      </div>
      <button className={classes.button31}></button>
      <div className={classes.r121}></div>
      <div className={classes.r221}></div>
      <div className={classes.r316}></div>
      <div className={classes._3Star6}>3 star</div>
      <button className={classes.button32}></button>
      <div className={classes.r122}></div>
      <div className={classes.r222}></div>
      <div className={classes.r317}></div>
      <div className={classes.r411}></div>
      <div className={classes.r511}></div>
      <div className={classes._5Star6}>5 star</div>
      <button className={classes.button33}></button>
      <div className={classes.r123}></div>
      <div className={classes._1Star6}>1 star</div>
      <button className={classes.button34}></button>
      <div className={classes.r223}></div>
      <div className={classes.r318}></div>
      <div className={classes.r412}></div>
      <div className={classes.r512}></div>
      <div className={classes._4Star6}>4 star</div>
      <button className={classes.button35}></button>
      <button className={classes.button36}></button>
      <div className={classes.r124}></div>
      <div className={classes.r224}></div>
      <div className={classes._2Star6}>2 star</div>
      <div className={classes.rating}>Rating </div>
    </div>
  );
});
