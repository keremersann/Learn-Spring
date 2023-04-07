import axios from "axios";
import { useAuth } from "../security/AuthContext";

const apiClient = axios.create({
  baseURL: "http://localhost:8080",
});

export function retrieveHelloWorld() {
  return apiClient.get("/hello-world");
}
export function retrieveHelloWorldBean() {
  return apiClient.get("/hello-world-bean");
}
export function retrieveHelloWorldPathVariable(username, token) {
  return apiClient.get(`/hello-world/path-variable/${username}`, {
    headers: {
      Authorization: token,
    },
  });
}

export function executeBasicAuthenticationService(token) {
  return apiClient.get("/basic-auth", {
    headers: {
      Authorization: token,
    },
  });
}
