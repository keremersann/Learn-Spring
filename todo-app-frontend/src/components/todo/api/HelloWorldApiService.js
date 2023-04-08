import { apiClient } from "./apiClient";

export function retrieveHelloWorld() {
  return apiClient.get("/hello-world");
}
export function retrieveHelloWorldBean() {
  return apiClient.get("/hello-world-bean");
}
export function retrieveHelloWorldPathVariable(username) {
  return apiClient.get(`/hello-world/path-variable/${username}`);
}

export function executeBasicAuthenticationService(token) {
  return apiClient.get("/basic-auth", {
    headers: {
      Authorization: token,
    },
  });
}
