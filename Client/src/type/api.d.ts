//request
interface LoginAPIReq {
  userName: string;
  password: string;
  code: string;
  uuid: string;
}

//respond
interface LoginAPIRes {
  msg: string;
  code: number;
  data: string;
}

// requests for user api
interface UserReq {
  userId: string;
  userName: string;
  email: string;
  password: string;
  firstName: string;
  lastName: string;
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
  userId: string | null;
  eventName: string;
  eventDetails: string;
  eventDate: Date;
  location: string;
  zipCode: string;
}

// find event by zipcode
interface EventZipcodeReq {
  zipCode: string;
}

// requests for event registration api
interface RegistrationReq {
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