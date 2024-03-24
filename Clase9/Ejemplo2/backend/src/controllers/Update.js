const { list_users } = require('../DataList/dataList')

function UpdateUser(req, res) {
    try {

        /*
        Recibimos el siguiente JSON:
            {
                "carnet":"201915547",
                "nombre": "Lionel Ronaldo",
                "edad":25,
                "facultad": "Ingeniería",
                "password":"HolaMundo1*"
            }
        */
        const { carnet, nombre, edad, facultad, password } = req.body //Obtenemos los valores que nos mandan desde el frontend

        //Buscamos al usuario por medio del carnet en la lista, si se encunetra nos retorna el índice, en caso contrario se retorna un -1
        const usuarioIndex = list_users.findIndex(x_user => x_user.carnet === carnet)
        
        if (usuarioIndex !== -1) {
            //Obtenemos al usuario que deseamos actualizar por medio del índice que obtuvimos anteriomente
            const usuarioActualizar= list_users[usuarioIndex]

            //Actualizamos los atributos de nuestro usuario por los valores que recibimos en el JSON
            usuarioActualizar.nombre=nombre
            usuarioActualizar.edad=edad
            usuarioActualizar.facultad=facultad
            usuarioActualizar.password=password

            //Respondemos con un json indicando que se actualizó de forma correcta
            res.json(
                {
                    mensanje: "Usuario actualizado correctamente"
                }
            )

        } else {
            //Respondemos con un json indicando que se no se loctro actualizar de forma correcta
            res.json(
                {
                    error: "Error al actualizar el Usuario no existe"
                }
            )
        }
    } catch (error) {
        console.log(error)
         // Si ocurre algún error, enviar una respuesta como json diciendo que ocurrió un error
        return res.json(
            {
                error: "Ocurrió un error al actualizar el usuario"
            }
        )
    }
}

//Exportamos la función que creamos para usarlo en "routes.js"
module.exports = {
    UpdateUser
}