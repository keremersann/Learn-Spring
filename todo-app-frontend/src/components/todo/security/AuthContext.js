import { createContext, useContext, useState } from "react";
import { apiClient } from "../api/apiClient";
import { executeBasicAuthenticationService } from "../api/HelloWorldApiService";

// 1) create a context
export const AuthContext = createContext();

// 3) share the state with other components
export const useAuth = () => useContext(AuthContext);

export default function AuthProvider({ children }) {
  // 2) put some state in the context
  const [isAuthenticated, setAuthenticated] = useState(false);
  const [username, setUsername] = useState(null);
  const [token, setToken] = useState(null);

  async function login(username, password) {
    const baToken = "Basic " + window.btoa(username + ":" + password);

    try {
      const response = await executeBasicAuthenticationService(baToken);
      if (response.status === 200) {
        setAuthenticated(true);
        setUsername(username);
        setToken(baToken);
        apiClient.interceptors.request.use((config) => {
          console.log("interceptors is added");
          config.headers.Authorization = baToken;
          console.log("Token info is added to the request header");
          return config;
        });
        return true;
      } else {
        logout();
        return false;
      }
    } catch (error) {
      console.log(error);
      logout();
      return false;
    }
  }

  function logout() {
    setAuthenticated(false);
    setUsername(null);
    setToken(null);
  }

  return (
    <AuthContext.Provider
      value={{ isAuthenticated, login, logout, username, token }}
    >
      {children}
    </AuthContext.Provider>
  );
}
