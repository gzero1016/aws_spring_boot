import api from "./api";

export const registerUser = async (user) => {
    return api.post("/user", user); // api. : api에서 axios 기본주소를 저장해둬서 불러오는거
};

export const getUserListAll = async () => {
    return api.get("/user/list");
};

export const updateUser = async (user) => {
    return api.put(`/users/${user.userId}`, user);
};

export const deleteUser = async (user) => {
    return api.delete(`/users/${user.userId}`);
};