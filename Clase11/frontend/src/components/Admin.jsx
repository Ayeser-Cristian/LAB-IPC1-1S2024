import React, { useState, useEffect } from "react";
import './Styles/Styles.css'
import { useCookies } from 'react-cookie';
import { Modal } from 'react-bootstrap'

import NavBarAdmin from "./NavBarAdmin";

function Administrador() {

    const [cookies, setCoookies] = useCookies(['usuario'])
    const [datosUser, setDatosUser] = useState(cookies.usuario)
    const [users, setUsers] = useState([])
    const [selectdUser, setSelectdUser] = useState(null)
    const [actualizarTabla, setActualizarTabla] = useState(false)

    //Para la carga del JSON
    const [selectedFile, setSelectedFile] = useState(null);

    useEffect(() => {

        fetch(`http://localhost:5000/GetAllUsers`, {
            method: "GET", // Utiliza el método POST
            headers: {
                "Content-Type": "application/json", // Establece el tipo de contenido de la solicitud como JSON
            },
        })
            .then((response) => response.json())
            .then((res) => {
                setUsers(res.usuarios)

            })
            .catch((error) => console.error(error))
    }, [actualizarTabla]);

    const viewUser = (user) => {
        console.log(user)
        setSelectdUser(user)
    }

    const viewUserClose = () => {
        setSelectdUser(null)
    }


    const deleteUser = (carnet_delete) => {

        const MyJson = {
            carnet: carnet_delete
        }

        fetch(`http://localhost:5000/eliminar`, {
            method: "DELETE", // Utiliza el método POST
            body: JSON.stringify(MyJson),
            headers: {
                "Content-Type": "application/json", // Establece el tipo de contenido de la solicitud como JSON
            },
        })
            .then((response) => response.json())
            .then((res) => {
                if (res.mensaje) {
                    alert(res.mensaje)
                    setActualizarTabla(!actualizarTabla)
                } else {
                    alert(res.error)
                }

            })
            .catch((error) => console.error(error))




    }
    //Cargar los datos al backend
    const cargarDatos= async ()=>{
        if(!selectedFile){
            alert("Por favor, seleccione un archivo JSON")
            return
        }

        const jsonData= await selectedFile.text()
        
        const userArray=JSON.parse(jsonData)

        fetch(`http://localhost:5000/CargaMasiva`, {
            method: "POST", // Utiliza el método POST
            body: JSON.stringify(userArray),
            headers: {
                "Content-Type": "application/json", 
            },
        })
            .then((response) => response.json())
            .then((res) => {
                if (res.mensaje) {
                    alert(res.mensaje)
                    setActualizarTabla(!actualizarTabla)
                } else {
                    alert(res.error)
                }

            })
            .catch((error) => console.error(error))


    }
    //Seleccionar el archivo
    const handleFileChange=(event)=>{
        setSelectedFile(event.target.files[0])
    }
    //Nota: Se modifico el style "admin-background" 
    return (
        <div>
           <NavBarAdmin/>
            {/*CARGA MASIVA */}
            <div className="admin-background">
            <input type="file" onChange={handleFileChange} accept=".json"/>

            <button onClick={cargarDatos} className="btn btn-warning">Cargar Archivo</button>
                <div className="center-container ">

                    <div className="table-container ">

                        <table className="table table-bordered text-center">
                            <thead>
                                <tr>
                                    <th >Carnet</th>
                                    <th >Nombre</th>
                                    <th >Edad</th>
                                    <th >Facultad</th>
                                    <th >Acciones</th>
                                </tr>
                            </thead>
                            <tbody >
                                {users.map(user_x => (
                                    <tr>
                                        <td>{user_x.carnet}</td>
                                        <td>{user_x.nombre}</td>
                                        <td>{user_x.edad}</td>
                                        <td>{user_x.facultad}</td>
                                        <td>
                                            <button className="btn btn-outline-danger" onClick={() => deleteUser(user_x.carnet)} >Eliminar</button>
                                            <button className="btn btn-outline-info" onClick={() => viewUser(user_x)}>Ver</button>
                                        </td>
                                    </tr>
                                )
                                )

                                }
                            </tbody>

                        </table>


                        {selectdUser && (
                            <Modal show={true} onHide={viewUserClose}>

                                <Modal.Header closeButton>
                                    <Modal.Title>Detalles del Usuario</Modal.Title>
                                </Modal.Header>
                                <Modal.Body>
                                    <p>Carnet: {selectdUser.carnet} </p>
                                    <p>Nombre: {selectdUser.nombre} </p>
                                    <p>Edad: {selectdUser.edad} </p>
                                    <p>Facultad: {selectdUser.facultad} </p>
                                </Modal.Body>

                                <Modal.Footer>
                                    <button variant="secondary" onClick={viewUserClose}>
                                        Cerrrar
                                    </button>
                                </Modal.Footer>
                            </Modal>

                        )


                        }
                    </div>
                </div>
            </div>
        </div>


    )

}

export default Administrador; 