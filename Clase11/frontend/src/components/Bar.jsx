import React, { useState, useEffect, useRef } from "react";
import Chart from 'chart.js/auto';


//Aquí estamos recibiendo la lista desde el Componete "Reportes"
//Esto se hace mediante Props
function ReporteBar({lista}) {

    
    const chartBarRef = useRef(null) // Creamos una referencia mutable para el elemento canvas

    

    useEffect(() => {

        if (lista.length === 0) return // Si la lista está vacía, no hacemos nada

        //Colores
        const colors = ["#D2F941", "#F96341", "#41F941", "#0D09F4", "#E609F4"]
        
        // Extraemos los nombres de usuario y la cantidad de posts de la lista de datos
        const labelsUser = lista.map(itemUser => itemUser.user +" "+itemUser.nombre) //["Luis Perez", "Jose Paz", "Carlos Morales", "Lionel Messi"]
        const dataPost = lista.map(itemUser => itemUser.post)

        //Configuración de la gráfica de barras
        const config = {
            type: "bar",  // Tipo de gráfica
            data: {
                labels: labelsUser,  // Nombres de usuario en el eje X
                datasets: [{
                    label: "Cantidad de Post Por Usuario", // Etiqueta de la serie de datos
                    data: dataPost, // Cantidad de posts en el eje Y
                    backgroundColor: colors.slice(0, dataPost.length), // Colores para las barras
                    borderColor: 'red', // Color del borde de las barras
                    borderWidth: 1 // Ancho del borde de las barras
                }]
            },
            options: {
                scales: {
                    y: {
                        beginAtZero: true  // Empezar el eje Y desde cero
                    }
                }
            }
        }

        // Creamos una instancia de Chart.js en el elemento canvas utilizando la configuración
        const myChart = new Chart(chartBarRef.current, config)

        // Devolvemos una función de limpieza que se ejecutará cuando el componente se desmonte
        return () => myChart.destroy()

    }, [lista]);




    return (
        <div>
            
            <canvas ref={chartBarRef} with="400" height="200"></canvas>
        </div>
    )
}


export default ReporteBar; 