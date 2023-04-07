import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from "./security/AuthContext";

export default function Login() {
  const [username, setUsername] = useState("kerem");
  const [password, setPassword] = useState("123");
  const [showFailMessage, setShowFailMessage] = useState(false);
  const navigate = useNavigate();
  const authContext = useAuth();
  console.log(authContext);

  function handleUsernameInput(event) {
    setUsername(event.target.value);
  }

  function handlePasswordInput(event) {
    setPassword(event.target.value);
  }

  async function handleUserLogin() {
    if (await authContext.login(username, password)) {
      setShowFailMessage(false);
      navigate(`/welcome/${username}`);
    } else {
      setShowFailMessage(true);
    }
  }

  return (
    <div className="Login">
      <h1>Time to Login!</h1>
      {showFailMessage && (
        <div className="loginMessage">
          Authentication is failed! Please check your credentials.
        </div>
      )}

      <div className="LoginForm">
        <div>
          <label>Username:</label>
          <input
            type="text"
            name="username"
            value={username}
            onChange={handleUsernameInput}
          ></input>
        </div>
        <div>
          <label>Password:</label>
          <input
            type="password"
            name="password"
            value={password}
            onChange={handlePasswordInput}
          ></input>
        </div>
        <div>
          <button name="login" type="button" onClick={handleUserLogin}>
            Login
          </button>
        </div>
      </div>
    </div>
  );
}
