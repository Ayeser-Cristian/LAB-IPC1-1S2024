import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';
import Login from '../Login'
import Administrador from '../Admin'

function Router() {

    return (
        <BrowserRouter>
            <Routes>
            <Route  path='/'  element={<Navigate to="/login"/>} />
                <Route  path='/login'  element={<Login/>} />
                <Route  path='/admin'  element={<Administrador/>} />
            </Routes>
        </BrowserRouter>
    )
}

export default Router;