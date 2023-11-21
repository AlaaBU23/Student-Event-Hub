import { memo } from 'react';
import type { FC } from 'react';
import { useRoutes, Link } from "react-router-dom"
import router from "./router"

import "reset-css";
import classes from './App.module.css';

interface Props {
  className?: string;
}
export const App: FC<Props> = memo(function App(props = {}) {
  const outlet = useRoutes(router)
  return (
    <div className={`${classes.root}`}>
      {/* <Outlet></Outlet> */}
      {outlet}
    </div>
  );
});
