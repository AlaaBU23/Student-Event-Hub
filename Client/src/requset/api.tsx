import request from "./index"

const API_BASE_URL = 'http://192.168.5.229:8080';

// export const registerUser = async (data: RegisterReq) => {
//   const response = await fetch(`${API_BASE_URL}/add`, {
//     method: 'POST',
//     headers: {
//       'Content-Type': 'application/json',
//     },
//     body: JSON.stringify(data),
//   });
//
//   if (!response.ok) {
//     throw new Error('Registration failed');
//   }
//
//   return response.json();
// };

export const registerUser = (params: UserReq) => request.post("/users/add", params)

export const LoginAPI = (params: LoginAPIReq): Promise<LoginAPIRes> => request.post("/users/login", params)

export const updateUserInform = (params: UserReq) => request.post("/users/update", params)

export const getUserInform = (params: UserReq) => request.get("/users/getById/" + params.userId)

export const deleteUser = (params: UserReq) => request.delete("/users/del/" + params.userId)

export const addEvent = (params: EventReq) => request.post("/events/add" + params)

export const deleteEvent = (params: EventReq) => request.delete("/events/del/" + params.eventId)

export const getEventInform = (params: EventReq) => request.get("/events/getById/" + params.eventId)

export const updateEventInform = (params: EventReq) => request.post("/events/update", params)

export const addRegistration = (params: RegistrationReq) => request.post("/eventregistrations/add" + params)

export const deleteRegistration = (params: RegistrationReq) => request.delete("/eventregistrations/del/" + params.eventId)

export const getRegistrationInform = (params: RegistrationReq) => request.get("/eventregistrations/getById/" + params.eventId)

export const updateRegistrationInform = (params: RegistrationReq) => request.post("/eventregistrations/update", params)

export const addAttendee = (params: AttendeeReq) => request.post("/events/add" + params)

export const deleteAttendee = (params: AttendeeReq) => request.delete("/events/del/" + params.eventId)

export const getAttendeeInform = (params: AttendeeReq) => request.get("/events/getById/" + params.eventId)

export const updateAttendeeInform = (params: AttendeeReq) => request.post("/events/update", params)

export const addHost = (params: HostReq) => request.post("/events/add" + params)

export const deleteHost = (params: HostReq) => request.delete("/events/del/" + params.eventId)

export const getHostInform = (params: HostReq) => request.get("/events/getById/" + params.eventId)

export const updateHostInform = (params: HostReq) => request.post("/events/update", params)