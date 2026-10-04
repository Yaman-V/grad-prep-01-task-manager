import axios from "axios";

const api = axios.create({ baseURL: "", withCredentials: true });
// Lets the browser include cookies with requests and accept cookies set by responses. The app does not manually create a Cookie header.

export default api;
