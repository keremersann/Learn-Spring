import { useParams, Link } from "react-router-dom";
import { useState } from "react";
import { retrieveHelloWorld } from "./api/HelloWorldApiService";
import { retrieveHelloWorldBean } from "./api/HelloWorldApiService";
import { retrieveHelloWorldPathVariable } from "./api/HelloWorldApiService";
import { useAuth } from "./security/AuthContext";

export default function Welcome() {
  const { username } = useParams();
  const [message, setMessage] = useState(null);

  const authContext = useAuth();

  // function callHelloWorldRestApi(){
  //     retrieveHelloWorld()
  //     .then( (response) => successfullResponse(response))
  //     .catch((error) => errorResponse(error))
  //     .finally(() => console.log("clean Up!"))
  // }

  function callHelloWorldBeanRestApi() {
    retrieveHelloWorldBean()
      .then((response) => successfullResponse(response))
      .catch((error) => errorResponse(error))
      .finally(() => console.log("clean Up!"));
  }

  function callHelloWorldPathVariableRestApi() {
    retrieveHelloWorldPathVariable(username, authContext.token)
      .then((response) => successfullResponse(response))
      .catch((error) => errorResponse(error))
      .finally(() => console.log("clean Up!"));
  }

  function successfullResponse(response) {
    console.log(response);
    setMessage(response.data.message);
  }
  function errorResponse(error) {
    console.log(error);
  }

  return (
    <div className="Welcome">
      <h1>Welcome {username}!</h1>
      <div>
        To Manage Your Todos - <Link to="/todos">Go here</Link>
      </div>
      <br></br>
      <div>
        <button
          className="btn btn-success"
          onClick={callHelloWorldPathVariableRestApi}
        >
          Call Hello Worl Rest API
        </button>
        <div className="text-info">{message}</div>
      </div>
    </div>
  );
}
