import { memo } from 'react';
import type { FC } from 'react';
import { Input, } from 'antd';
import 'reset-css';
import classes from './PostEventPage.module.css';
import { Rectangle12Icon } from './Rectangle12Icon.js';
import { Rectangle13Icon } from './Rectangle13Icon.js';
import { Rectangle14Icon } from './Rectangle14Icon.js';
import { Rectangle15Icon } from './Rectangle15Icon.js';
import NavigationBar from '@/componets/NavigationBar.js';
import { Background } from '@/componets/Background.js';
import { useSelector, useDispatch } from "react-redux";
import store from "@/store";

interface Props {
  className?: string;
}
export const PostEventPage: FC<Props> = memo(function PostEventPage(props = {}) {
  type RootState = ReturnType<typeof store.getState>
  // 获取数据
  const { num } = useSelector((state: RootState) => ({
    num: state.handleNum.num // 这里划曲线警告
  }));
  // 修改数据
  const dispatch = useDispatch();
  const changeNum = () => {
    dispatch({ type: 'add2', val: 3 })
  }






  return (
    <div>
      <Background />
      <NavigationBar />
      <div className={classes.rectangle14}>
        <Rectangle14Icon className={classes.icon} />
      </div>
      <div className={classes.rectangle15}>
        <Rectangle15Icon className={classes.icon2} />
      </div>
      <div className={classes.eventDetails}>Event details:</div>
      <div className={classes.rectangle12}>
        <Rectangle12Icon className={classes.icon3} />
      </div>
      <div className={classes.rectangle13}>
        <Rectangle13Icon className={classes.icon4} />
      </div>
      <div className={classes.address}>Address:</div>
      <div className={classes.dateAndTime}>Date and Time:</div>
      <div className={classes.eventName}>Event name:</div>
      <Input placeholder='Please input here' className={classes.address1} />
      <div className={classes.zipCodeID}>Zip Code ID:</div>
      <div className={classes.post}>
        <div className={classes.post2}>Post</div>
      </div>
      <div className={classes.pleaseIntroduceTheDetailsForYo}>Please introduce the details for your next event:</div>
      <div className={classes.createAnEvent}>Create An Event</div>
    </div>
  );
});
