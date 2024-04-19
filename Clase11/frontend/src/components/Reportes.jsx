import React, { useState, useEffect } from "react";
import ReporteBar from "./Bar";
import ReportePie from "./Pie";
import NavBarAdmin from "./NavBarAdmin";
function Reportes() {

    const [listaData, setListaData] = useState([]);

    /*
    { user: "Luis Perez", post: 5 },
    { user: "Jose Paz", post: 10 },
    { user: "Carlos Morales", post: 8 },
    { user: "Lionel Messi", post: 1 }
    */

    useEffect(() => {

        fetch(`http://localhost:5000/reportBar`, {
            method: "GET", // Utiliza el método POST
            headers: {
                "Content-Type": "application/json", // Establece el tipo de contenido de la solicitud como JSON
            },
        })
            .then((response) => response.json())
            .then((res) => {
                console.log(res)
                setListaData(res.topBar)
                console.log(listaData)

            })
    }, []);

    return (
        <div>
            <NavBarAdmin />
            <div className="admin-background">
                <div style={{ width: "30%", background: "white" }}>

                    {/* Aquí mandamos la lista por medio de Props al componente ReporteBar(que son parametros básicamente)*/}
                    <ReporteBar lista={listaData} />

                </div>

                <div style={{ width: "30%", background: "#FFEA9D" }}>
                    <ReportePie/>
                </div>

            </div>

        </div>
    )
}


export default Reportes; 