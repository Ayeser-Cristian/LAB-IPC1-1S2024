const { list_users } = require('../DataList/dataList')
const Usuario = require('../objects/Usuario')

function SignUp(req, res) {

    try {
        //Obtenemos los atributos que nos mandan desde el frontend por medio de un JSON
        /* 
            Importante:
            Cuando nos manden un json desde el frontend, por ejemplo de esta forma:
            {
                "carnet":"201915547",
                "nombre": "Lionel Ronaldo",
                "edad":25,
                "facultad": "Ingeniería",
                "password":"HolaMundo1*"
            }
            Y deseamos obtener los atributos aquí en el backend de esta forma:
            const { carnet, nombre, edad, facultad, password } = req.body

            Lo que va dento de llaves para obtener los valores debe llamarse igual a como viene en el JSON

        */
        const { carnet, nombre, edad, facultad, password } = req.body //Aquí obtenemos el valor de cada atributo que nos mandan en el JSON
        // Verificar si el carnet ya está en uso
        const usuarioExiste = list_users.find(x_user => x_user.carnet === carnet)
        
        //Si el usuario existe se nos retorna el elemento donde esta guardado en la lista, sino existe se retorna un "null" o un "undefined" 
        if (usuarioExiste) {
            return res.json({ error: 'El carnet ya está registrado.' });
        }

         // Si el carnet no está en uso, crear una nueva instancia de Usuario con los datos proporcionados
        const newUser = new Usuario(carnet, nombre, edad, facultad, password)
        list_users.push(newUser)  // Agregar el nuevo usuario a la lista

        // Enviar una respuesta como json con el mensaje de confirmación
        return res.json({ mensaje: 'Usuario agregado correctamente :D' });

    } catch (error) {
        console.log(error)
        // Si ocurre algún error, enviar una respuesta como json diciendo que ocurrió un error
        return res.json(
            {
                error: "Ocurrió un error en el registro de Usuario"
            }
        )
    }
}

function GetAllUsers(req, res) {
    try {
        //Enviamos como respuesta en un json toda la lista de usuarios que tenemos (list_users)
        res.json(
            {
                usuarios: list_users
            }
        )
    } catch (error) {
        console.log(error)
        return res.json(
            {
                error: "Ocurrió un error al obtener todos los usuarios"
            }
        )
    }
}

function Login(req, res) {
    try {
        /*
        Recibimos el siguiente JSON:
            {
                "carnet":"201915547",
                "password":"HolaMundo1*"
            }
        */

        //Obtenemos los valores que nos mandan desde el JSON
        const carnet1 = req.body.carnet
        const password1 = req.body.password

        // Buscar el usuario en la lista por su carnet y contraseña 
        const usuarioEncontrado = list_users.find(x_user => x_user.carnet === carnet1 && x_user.password === password1)
        
        //Si las credenciales son correctas, se nos retorna el elemento donde esta guardado en la lista, sino existe se retorna un "null" o un "undefined" 
        if (usuarioEncontrado) {

            //Construimos un JSON retornando todos los datos del usuario, menos su contraseña
            const userFind={
                carnet: usuarioEncontrado.carnet,
                nombre:usuarioEncontrado.nombre,
                edad:usuarioEncontrado.edad,
                facultad:usuarioEncontrado.facultad
            }

            //Respondemos con un JSON, el cual lleva un booleano (encontrado) para indicar si las credenciales son correctas, además de los datos del usuario
            res.json(
                {
                    encontrado:true,
                    datos:userFind
                }
                
                )

        } else {
            //Entra a esta parte si al buscar al usuario se nos retorno un "null" o un "undefined" 
            //Respondemos con un JSON, el cual lleva un booleano (encontrado) para indicar si las credenciales son correctas y un mensaje de que las credenciales son incorrectas
            res.json(
                {   
                    encontrado:false,
                    error: "Carnet o contraseña incorrectos"
                }
            )
        }
    } catch (error) {
        console.log(error)
        // Si ocurre algún error, enviar una respuesta como json diciendo que ocurrió un error
        return res.json(
            {
                error: "Ocurrió un error en el login"
            }
        )
    }
}

//Exportamos todas las funciones que creamos para usarlos en "routes.js"
module.exports = {
    SignUp,
    GetAllUsers,
    Login
}