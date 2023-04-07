import axios from "axios";

const apiClient = axios.create({
  baseURL: "http://localhost:8080",
});

export function retrieveTodosByUsernameApi(username) {
  return apiClient.get(`/users/${username}/todos`);
}

export function retrieveTodoByUsernameApi(username, id) {
  return apiClient.get(`/users/${username}/todos/${id}`);
}

export function deleteTodoByIdApi(username, id) {
  return apiClient.delete(`/users/${username}/todos/${id}`);
}

export function updateTodoByIdApi(username, id, todo) {
  return apiClient.put(`/users/${username}/todos/${id}`, todo);
}

export function createTodoApi(username, todo) {
  return apiClient.post(`/users/${username}/todos`, todo);
}
