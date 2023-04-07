import { useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { useAuth } from "./security/AuthContext";
import { useState } from "react";
import {
  createTodoApi,
  retrieveTodoByUsernameApi,
  updateTodoByIdApi,
} from "./api/TodosApiService";
import { Formik, Form, Field, ErrorMessage } from "formik";

export default function Todo() {
  const authContext = useAuth();
  const username = authContext.username;
  const { id } = useParams();
  const [description, setDescription] = useState("");
  const [targetDate, setTargetDate] = useState("");

  const navigate = useNavigate();

  useEffect(() => retrieveTodoDetails(), [id]);

  function retrieveTodoDetails() {
    if (id != -1) {
      retrieveTodoByUsernameApi(username, id)
        .then((response) => {
          setDescription(response.data.description);
          setTargetDate(response.data.targetDate);
        })
        .catch((error) => console.log(error));
    }
  }

  function onSubmit(values) {
    const todo = {
      id: id,
      username: username,
      description: values.description,
      targetDate: values.targetDate,
      done: false,
    };

    if (id == -1) {
      createTodoApi(username, todo)
        .then((response) => {
          console.log(response);
          setDescription(response.data.description);
          setTargetDate(response.data.targetDate);
          navigate("/todos");
        })
        .catch((error) => console.log(error));
    } else {
      updateTodoByIdApi(username, id, todo)
        .then((response) => {
          console.log(response);
          setDescription(response.data.description);
          setTargetDate(response.data.targetDate);
          navigate("/todos");
        })
        .catch((error) => console.log(error));
    }
  }

  function validate(values) {
    let errors = {
      // description: "Enter valid description",
      // targetDate: "Enter valid target date"
    };
    if (values.description.length < 5) {
      errors.description = "Enter at least 5 characters";
    }
    if (values.targetDate == null || values.targetDate == "") {
      errors.description = "Enter a target date";
    }

    return errors;
  }

  return (
    <div className="container">
      <h1>Todo Details</h1>
      <div>
        <Formik
          initialValues={{ description, targetDate }}
          enableReinitialize={true}
          onSubmit={onSubmit}
          validate={validate}
          validateOnChange={false}
          validateOnBlur={false}
        >
          {(props) => (
            <Form>
              <ErrorMessage
                name="description"
                component="div"
                className="alert alert-warning"
              />

              <ErrorMessage
                name="targetDate"
                component="div"
                className="alert alert-warning"
              />

              <fieldset className="form-group">
                <label>Description</label>
                <Field
                  type="text"
                  className="form-control"
                  name="description"
                ></Field>
              </fieldset>
              <fieldset className="form-group">
                <label>Target Date</label>
                <Field
                  type="date"
                  className="form-control"
                  name="targetDate"
                ></Field>
              </fieldset>
              <div>
                <button className="btn btn-success m-5" type="submit">
                  Save
                </button>
              </div>
            </Form>
          )}
        </Formik>
      </div>
    </div>
  );
}
