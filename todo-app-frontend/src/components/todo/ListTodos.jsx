import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import {
  retrieveTodosByUsernameApi,
  deleteTodoByIdApi,
  retrieveTodoByUsernameApi,
} from "./api/TodosApiService";
import { useAuth } from "./security/AuthContext";

export default function ListTodos() {
  const authContext = useAuth();
  const [todos, setTodos] = useState([]);
  const [deleteMessage, setDeleteMessage] = useState(null);
  const navigate = useNavigate();

  useEffect(() => refreshTodos(), []);

  function refreshTodos() {
    retrieveTodosByUsernameApi(authContext.username)
      .then((response) => {
        setTodos(response.data);
      })
      .catch((error) => console.log(error));
  }

  //Display message
  //Update Todolist
  function deleteTodoById(id) {
    deleteTodoByIdApi(authContext.username, id)
      .then(() => {
        setDeleteMessage(`Todo with Id ${id} is deleted`);
        refreshTodos();
      })
      .catch((error) => console.log(error));
  }
  function updateTodoById(id) {
    retrieveTodoByUsernameApi(authContext.username, id)
      .then((response) => {
        console.log(response);
        navigate(`/todos/${id}`);
      })
      .catch((error) => console.log(error));
  }

  function addNewTodo() {
    navigate(`/todos/-1`);
  }

  return (
    <div className="container">
      {deleteMessage && (
        <div className="alert alert-warning">{deleteMessage}</div>
      )}
      <h1>Todo List</h1>
      <table className="table">
        <thead>
          <tr>
            <th>Description</th>
            <th>Is Done?</th>
            <th>Target Date</th>
            <th>Delete</th>
            <th>Update</th>
          </tr>
        </thead>
        <tbody>
          {todos.map((todo) => (
            <tr key={todo.id}>
              <td>{todo.description}</td>
              <td>{todo.done.toString()}</td>
              <td>{todo.targetDate}</td>
              <td>
                <button
                  className="btn btn-warning"
                  onClick={() => deleteTodoById(todo.id)}
                >
                  Delete
                </button>
              </td>
              <td>
                <button
                  className="btn btn-success"
                  onClick={() => updateTodoById(todo.id)}
                >
                  Update
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>

      <btn className="btn btn-success" onClick={() => addNewTodo()}>
        Add New Todo
      </btn>
    </div>
  );
}
