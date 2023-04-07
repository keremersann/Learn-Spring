import { createContext, useContext, useState } from "react";
import { executeBasicAuthenticationService } from "../api/HelloWorldApiService";

// 1) create a context
export const AuthContext = createContext();

// 3) share the state with other components
export const useAuth = () => useContext(AuthContext);

export default function AuthProvider({ children }) {
  // 2) put some state in the context
  const [isAuthenticated, setAuthenticated] = useState(false);
  const [username, setUsername] = useState(null);

  // function login(username, password){
  //     if(username === 'kerem' && password === '123'){
  //         setAuthenticated(true)
  //         setUsername("kerem")
  //         return true
  //     }else{
  //         setAuthenticated(false)
  //         return false
  //     }
  // }

  function login(username, password) {
    const baToken = "Basic " + window.btoa(username + ":" + password);

    executeBasicAuthenticationService(baToken)
      .then((response) => console.log(response))
      .catch((error) => console.log(error));

    setAuthenticated(false);
  }

  function logout() {
    setAuthenticated(false);
  }

  return (
    <AuthContext.Provider value={{ isAuthenticated, login, logout, username }}>
      {children}
    </AuthContext.Provider>
  );
}
