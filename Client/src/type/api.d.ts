//requset
interface LoginAPIReq {
  username: string;
  password: string;
  code: string;
  uuid: string;
}

//respond
interface LoginAPIRes {
  msg: string;
  code: number;
  token: string;
}

// requests for user api
interface UserReq {
  userId: string;
  userName: string;
  email: string;
  password: string;
  firstname: string;
  lastname: string;
  zipCode: string;
  university: string;
  universityId: string;
  age: string;
  description: string;
}

//respond
interface RegisterRes {
  token: string;
}

// requests for event api
interface EventReq {
  eventId: string;
  userId: string;
  eventName: string;
  eventDetails: string;
  eventDate: Date;
  location: string;
  zipCode: string;
}

// requests for event registration api
interface RegostratopmReq {
  registrationId: string;
  eventId: string;
  userId: string;
  registrationStatus: string;
  confirmationEmailSent: boolean;
}

// requests for attendee api
interface AttendeeReq {
  userId: string;
  eventId: string;
  registrationStatus: string;
  attendeeRating: number;
}

// requests for host api 
interface HostReq {
  userId: string;
  eventId: string;
}