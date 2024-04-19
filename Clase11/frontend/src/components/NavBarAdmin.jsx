import React from "react";
import './Styles/Styles.css'
import { useNavigate, Link } from "react-router-dom";

function NavBarAdmin() {
    const navigate = useNavigate();

    const handleLogout = () => {
       
        navigate('/login');
    };

    return (
        <div className="container-navbar">
            <div className="left-container-navbar">
                <ul className="link-list">
                    <li className="link-list-item">
                        <Link className="link" to="/admin"> Tabla </Link>
                    </li>
                    <li className="link-list-item">
                        <Link className="link" to="/reports"> Reporte </Link>
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

export default NavBarAdmin;
