import api from "./api";

export const registerUser = async (user) => {
    return api.post("/user", user); // api. : api에서 axios 기본주소를 저장해둬서 불러오는거
};