// Importación de los módulos necesarios
const express = require('express') // Importa el framework Express para la creación de la aplicación web
const cors = require('cors') // Importa el módulo CORS para habilitar el intercambio de recursos entre diferentes orígenes

// Creación de la aplicación Express
const MyApp = express(); 

MyApp.use(express.json()) //para analizar los cuerpos de las solicitudes en formato JSON
MyApp.use(cors()) //para permitir solicitudes CORS (Cross-Origin Resource Sharing) esto desde el frontend

// Importación y uso de las rutas definidas en el archivo './routes/routes.js'
const Router= require('./routers/routes')
MyApp.use(Router)
//--------------

const port = 5000; //Puerto en el que la aplicación escuchará las solicitudes

// Inicio del servidor y escucha de solicitudes en el puerto especificado
MyApp.listen(port, () => {
    console.log(`The API is listening at http://localhost:${port}`);
  });
