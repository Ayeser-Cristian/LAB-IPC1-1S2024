const { list_users } = require('../DataList/dataList')

function deleteUser(req, res) {
    try {

        /*
        Recibimos el siguiente JSON:
            {
                "carnet":"201915547"
            }
        */
        const carnetDelete = req.body.carnet //Obtenemos el carnet que nos mandan desde el JSON
        console.log(carnetDelete)
        //Buscamos al usuario por medio de su carnet y si encuentra en la lista, se nos retorna en que índice 
        //de la lista está, sino se encuentra nos retorna un -1
        const usuarioIndex = list_users.findIndex(x_user => x_user.carnet.toString() === carnetDelete.toString())
        console.log(usuarioIndex)
        if (usuarioIndex !== -1) {
            //Eliminamos al usuario de la lista usando "splice", indicandole el índice donde debe eliminar
            //y cuantos debe eliminar apartir de este punto, en este caso solo 1
            list_users.splice(usuarioIndex, 1)

            //Respondemos con un json indicando que se elimino de forma correcta
            res.json(
                { mensaje: 'Usuario eliminado correctamente.' }

            );
        } else {
            res.json(
                {
                    error: "Error al eliminar el usuario no existe"
                }
            )
        }

    } catch (error) {
        console.log(error)
        // Si ocurre algún error, enviar una respuesta como json diciendo que ocurrió un error
        return res.json(
            {
                error: "Ocurrió un error al eliminar al usuario"
            }
        )
    }
}

//Exportamos la función que creamos para usarlo en "routes.js"
module.exports = {
    deleteUser
}