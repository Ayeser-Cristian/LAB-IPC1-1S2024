import React from "react";
import './Styles/Styles.css'
import { useCookies } from 'react-cookie';
import { useNavigate, Link } from "react-router-dom";

function NavBar() {

    const [cookies, setCookies, removeCookie] = useCookies(['usuario'])

    const navigate = useNavigate();

    const handleLogout = () => {
        removeCookie('usuario');
        navigate('/login');
    };

    return (
        <div className="container-navbar">
            <div className="left-container-navbar">
                <ul className="link-list">
                    <li className="link-list-item">
                        <Link className="link" to="/home"> Home </Link>
                    </li>
                    <li className="link-list-item">
                        <Link className="link" to="/createPost"> Create post </Link>
                    </li>
                    
                </ul>
            </div>
            <div className="right-container-navbar">
                <button className="btn btn-outline-info logout-btn" onClick={handleLogout}>
                    Logout
                </button>
            </div>
        </div>
    )
}

export default NavBar;
