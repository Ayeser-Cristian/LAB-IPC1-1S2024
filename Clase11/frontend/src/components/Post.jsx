import React, { useState } from "react";
import { useCookies } from 'react-cookie';
import './Styles/Styles.css';

import NavBar from './NavBar'


function Post() {

    const [cookies] = useCookies(['usuario']);
    const [datosUser, setDatosUser] = useState(cookies.usuario)

    const [descripcion, setDescripcion] = useState('');

    const [imagen, setImagen] = useState('');
    const [imagenURL, setImagenURL] = useState('');

    const handleDescripcionChange = (event) => {
        setDescripcion(event.target.value);
    };

    const handleImagenChange = (event) => {
        const reader = new FileReader();
        const file = event.target.files[0];

        reader.onloadend = () => {
            setImagen(reader.result);
            setImagenURL(reader.result);
        };

        if (file) {
            reader.readAsDataURL(file);
        }
    };

    const handleSubmit = (event) => {
        event.preventDefault();

        const dataJson = {
            carnet: datosUser.carnet,
            descripcion: descripcion,
            imagen: imagen
        }

        fetch(`http://localhost:5000/createPost`, {
            method: "POST",
            body: JSON.stringify(dataJson),
            headers: {
                "Content-Type": "application/json",
            },
        })
            .then((response) => response.json())
            .then((res) => {

                console.log(res)
                alert(res.mensaje)
                setImagenURL('');
            })
            .catch((error) => console.error(error))

    };

    return (
        <div>
            <NavBar />
            <div className="home-background">
                <div className="center-post-form">
                    <div className="post-form">
                        <h2>Crear Publicación</h2>
                        <form onSubmit={handleSubmit}>
                            <div className="form-group">
                                <label htmlFor="descripcion">Descripción:</label>
                                <textarea
                                    id="descripcion"
                                    value={descripcion}
                                    onChange={handleDescripcionChange}
                                    rows="4"
                                    required
                                ></textarea>
                            </div>
                            <div className="form-group">
                                <label htmlFor="imagen">Imagen:</label>

                                <input
                                    type="file"
                                    id="imagen"
                                    accept="image/*"
                                    onChange={handleImagenChange}

                                />
                            </div>

                            <div className="form-group">
                                {imagenURL && <img src={imagenURL} alt="Preview" style={{ maxWidth: '150px' }} />}
                            </div>

                            <button type="submit" className="btn btn-outline-success">Publicar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default Post;