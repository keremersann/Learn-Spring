import Login from './Login'
import Welcome from './Welcome'
import Error from './Error'
import Header from './Header'
import Footer from './Footer'
import Todo from './Todo'
import "./TodoApp.css"
import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom"
import ListTodos from './ListTodos'
import Logout from './Logout'
import AuthProvider, { useAuth } from './security/AuthContext'

function AuthenticatedRoute({children}){
    const authContext = useAuth()
    if(authContext.isAuthenticated)
        return children

    return <Navigate to= "/"/>
}

export default function TodoApp(){
    return (
        <div className = "TodoApp">
            <AuthProvider>
                <BrowserRouter>
                    <Header/>
                    <Routes>
                        <Route path = "/" element = {<Login />}></Route>
                        <Route path = "/login" element = {<Login />}></Route>

                        <Route path = "/welcome/:username" element = {
                        <AuthenticatedRoute><Welcome /></AuthenticatedRoute>}
                        ></Route>

                        <Route path = "/todos" element = {
                        <AuthenticatedRoute><ListTodos /></AuthenticatedRoute>}>
                        </Route>

                        <Route path = "/todos/:id" element = {
                        <AuthenticatedRoute><Todo /></AuthenticatedRoute>}>
                        </Route>

                        <Route path = "/logout" element = {
                        <AuthenticatedRoute><Logout /></AuthenticatedRoute>
                        }></Route>

                        <Route path = "*" element = {<Error />}></Route>

                    </Routes>
                    <Footer/>
                </BrowserRouter>
            </AuthProvider>
        </div>
    )
}