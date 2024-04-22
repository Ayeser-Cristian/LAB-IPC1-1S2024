const express = require('express')

const router = express.Router() // Creación de un  Express router

//Exportamos todos los "controllers" que creamos
const {hellowWorld} = require('../controllers/holamundo')
const {SignUp, GetAllUsers, Login, CargaMasiva}=require('../controllers/accesos')
const {UpdateUser}=require('../controllers/Update')
const {deleteUser}=require('../controllers/delete')
const {createPost, getAllPost, getReportBar} = require('../controllers/Post')

//Creamos las rutas para cada EndPoint con su respectivo controlador

//Get 
router.get('/saludar', hellowWorld)
router.get('/GetAllUsers', GetAllUsers)
router.get('/getAllPost', getAllPost)
router.get('/reportBar', getReportBar)
//Post
router.post('/registro', SignUp)
router.post('/Login', Login)
router.post('/createPost', createPost)
router.post('/CargaMasiva', CargaMasiva) //Carga masiva de usuarios

//PUT
router.put('/update', UpdateUser)

//DELETE
router.delete('/eliminar', deleteUser)

module.exports= router //Importamos el router para usarlo en "app.js"