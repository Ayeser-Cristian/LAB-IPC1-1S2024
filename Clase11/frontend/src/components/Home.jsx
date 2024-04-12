import React, { useState, useEffect } from "react";
import './Styles/Styles.css'
import { useCookies } from 'react-cookie';

import { useNavigate, Link } from "react-router-dom";

import NavBar from './NavBar'



function Home() {

    const [cookies, setCookies] = useCookies(['usuario'])
    const [datosUser, setDatosUser] = useState(cookies.usuario)
    const [listaObjetos, setListaObjetos] = useState([])

    useEffect(() => {

        fetch(`http://localhost:5000/getAllPost`, {
            method: "GET", // Utiliza el método POST
            headers: {
                "Content-Type": "application/json", // Establece el tipo de contenido de la solicitud como JSON
            },
        })
            .then((response) => response.json())
            .then((res) => {
                setListaObjetos(res.publicaciones)

            })
            .catch((error) => console.error(error))
    }, []);

    function viewIdPost(postId) {
        console.log("ID del post:", postId);
    }

    return (
        <div>
            <NavBar />

            <div className="home-background">
                <div className="card-container">
                    {listaObjetos.map(objeto => (
                        <div className="card" key={objeto.id}>
                            <div className="card-header">
                                <p>Usuario: {objeto.user}</p>
                                <p>Fecha: {new Date(objeto.fechaHora).toLocaleString()}</p>
                            </div>
                            <div className="card-center-img">
                                {objeto.imagen && <img src={objeto.imagen} className="card-img" alt="..." />}
                            </div>
                            <p className="card-description">{objeto.descripcion}</p>
                            <button onClick={() => viewIdPost(objeto.id)}>Comentarios</button>
                        </div>
                    ))}
                </div>
            </div>
        </div>
    )
}


export default Home;
