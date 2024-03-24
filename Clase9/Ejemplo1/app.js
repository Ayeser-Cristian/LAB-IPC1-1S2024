// Importar Express.js
const express = require('express')

const app=express()
//Get 
app.get("/saludo", (rep, res)=>{

    res.send("Hola Clase de IPC1 :D")
})
const port=5000

app.listen(port, ()=>{
    console.log(`Servidor Express escuchando en el puerto ${port}`)
})


