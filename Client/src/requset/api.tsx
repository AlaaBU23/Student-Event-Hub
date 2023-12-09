import axios from "axios";
import request from "./index"


export const getLoginUserInform = async () => {
    await request.get("/users/currentuser",{
        headers: {
            Authorization: localStorage.getItem('token')
        }
    }).then((result)=>{
        localStorage.setItem("userId", result.data.userId)
        localStorage.setItem("userName", result.data.userName)
        localStorage.setItem("firstName", result.data.firstName)
        localStorage.setItem("lastName", result.data.lastName)
        localStorage.setItem("email", result.data.email)
        localStorage.setItem("zipCode", result.data.zipCode)
        localStorage.setItem("university", result.data.university)
        localStorage.setItem("universityId", result.data.universityId)
        localStorage.setItem("age", result.data.age)
        localStorage.setItem("description", result.data.description)
    })
}

export const logoutAPI = async () => {
    await request.get("/users/logout"),{
        headers: {
            Authorization: localStorage.getItem('token')
        }
    }
}


export const registerUser = (params: UserReq) => request.post("/users/add", params)

export const LoginAPI = (params: LoginAPIReq): Promise<LoginAPIRes> => request.post("/users/login", params)

export const updateUserInform = (params: UserReq) => request.post("/users/update", params)

export const getUserInform = (params: UserReq) => request.get("/users/getById/" + params.userId)

export const deleteUser = (params: UserReq) => request.delete("/users/del/" + params.userId)

export const addEvent = (params: EventReq) => request.post("/events/add", params)

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