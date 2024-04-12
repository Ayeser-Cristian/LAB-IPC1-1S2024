import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';
import Login from '../Login'
import Administrador from '../Admin'
import Home from '../Home'

import Post from '../Post'

function Router() {

    return (
        <BrowserRouter>
            <Routes>
                <Route path='/' element={<Navigate to="/login" />} />
                <Route path='/login' element={<Login />} />
                <Route path='/admin' element={<Administrador />} />
                <Route path='/home' element={<Home />} />
                <Route path='/createPost' element={<Post />} />
            </Routes>
        </BrowserRouter>
    )
}

export default Router;