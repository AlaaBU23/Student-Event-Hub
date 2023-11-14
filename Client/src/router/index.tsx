import { LandingPage } from "@/views/LandingPage/LandingPage"
import { SignInPage } from "@/views/SignInPage/SignInPage"
import { Navigate } from "react-router-dom"
import { WhoWeArePage } from "@/views/WhoWeArePage/WhoWeArePage"
import { PostEventPage } from "@/views/PostEventPage/PostEventPage"
import { ListOfEvent } from "@/views/ListEventPage/ListOfEvent"
import { AttendPage } from "@/views/AttendPage/AttendPage"
import { ResetPage } from "@/views/ResetPage/ResetPage"
import { ProfilePage } from "@/views/ProfilePage/ProfilePage"
import { RequestForApplication } from "@/views/RequestPage/RequestForApplication"
import { EventinfoPage } from "@/views/EventinfoPage/EventinfoPage"
import { Rating } from "@/views/RatePage/Rating"

const routes = [
  {
    path: "/",
    element: <Navigate to="/landingpage" />
  },
  {
    path: "/signin",
    element: <SignInPage />
  },
  {
    path: "/landingpage",
    element: <LandingPage />
  },
  {
    path: "/who",
    element: <WhoWeArePage />
  },
  {
    path: "/postevent",
    element: <PostEventPage />
  },
  {
    path: "/events",
    element: <ListOfEvent />
  },
  {
    path: "/attend",
    element: <AttendPage />
  },
  {
    path: "/reset",
    element: <ResetPage />
  },
  {
    path: "/profile",
    element: <ProfilePage />
  },
  {
    path: "/request",
    element: <RequestForApplication />
  },
  {
    path: "/eventinfo",
    element: <EventinfoPage />
  },
  {
    path: "/rate",
    element: <Rating />
  },
]

export default routes