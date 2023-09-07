import axios from "axios"

export const api = axios.create({
    baseURL: "http://localhost:8080"    // axios 기본설정을 만들어서 사용함
});

export default api;