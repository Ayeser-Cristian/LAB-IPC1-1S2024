import React, { useEffect, useRef, useState } from 'react';
import Chart from 'chart.js/auto';


function ReportePie() {

     // Definimos los datos de ejemplo de las publicaciones
    const [list_publicaciones, setList_publicaciones] = useState([
        { id_publicacion: "Publicación 1", likes: 5, fecha_hora: "12-12-2024" },
        { id_publicacion: "Publicación 2", likes: 7, fecha_hora: "12-12-2024" },
        { id_publicacion: "Publicación 3", likes: 3, fecha_hora: "12-12-2024" },
        { id_publicacion: "Publicación 4", likes: 10, fecha_hora: "12-12-2024" },
        { id_publicacion: "Publicación 5", likes: 12, fecha_hora: "12-12-2024" }
    ])
 
    const chartPieRef = useRef(null); // Creamos una referencia para el elemento canvas

    useEffect(() => {

         // Creamos los datos para la gráfica de pie

        const dataConfig = {
            labels: list_publicaciones.map(item => `${item.id_publicacion}\n${item.fecha_hora}`), // Etiquetas de las partes de la gráfica
            datasets: [{
                label: 'Likes por Publicación',
                data: list_publicaciones.map(item => item.likes), // Datos de likes
                backgroundColor: [
                    'red',
                    'blue',
                    'yellow',
                    'green',
                    'purple',
                ],
                hoverOffset: 5
            }]

        }
        
        // Configuramos la gráfica
        const config={
            type: "pie", // Tipo de gráfica
            data: dataConfig // Datos de la gráfica
        }
        
         // Creamos una instancia de la gráfica en el elemento canvas
        const myChart = new Chart(chartPieRef.current, config)

        return () => myChart.destroy()

    }, [])

    return (
        <div>
            <canvas ref={chartPieRef} with="400" height="100"></canvas>
        </div>
    )

}


export default ReportePie; 