
const { list_users, list_post } = require('../DataList/dataList')
const Object_Post = require('../objects/Post')

var id_publicacion = 0

function createPost(req, res) {

    try {
        const carnet = req.body.carnet
        const descripcion = req.body.descripcion
        const imagen = req.body.imagen

        id_publicacion = id_publicacion + 1
        const newPost = new Object_Post(id_publicacion, carnet, descripcion, imagen)
        list_post.push(newPost)
        res.json(
            { mensaje: 'Post creado exitosamente correctamente.' }

        );

    } catch (error) {
        console.log(error)

        return res.json(
            {
                error: "Ocurrió un error al eliminar al usuario"
            }
        )
    }
}


function getAllPost(req, res) {

    try {

        const posts_con_usuario = [];

        for (const post of list_post) {

            const usuario = list_users.find(user => user.carnet === post.user);



            if (usuario) {
                const post_con_usuario = {
                    id: post.id,
                    descripcion: post.descripcion,
                    imagen: post.imagen,
                    fechaHora: post.fechaHora,
                    user: usuario.nombre
                };

                posts_con_usuario.push(post_con_usuario);
            }
        }

        posts_con_usuario.reverse();
        res.json(
            { publicaciones: posts_con_usuario }
        );

    } catch (error) {
        return res.json(
            {
                error: "Ocurrió un error al eliminar al usuario"
            }
        )
    }
}



function getReportBar(req, res) {

    try {
        // Se inicializa un objeto vacío para almacenar el recuento de publicaciones por usuario
        const postCountByUser = {}

        // Se recorre la lista de publicaciones
        for (const post of list_post) {
            if (post.user in postCountByUser) {
                // Si el usuario ya está en el objeto postCountByUser, se incrementa el contador de publicaciones
                postCountByUser[post.user]++
            } else {
                // Si el usuario no está en el objeto, se agrega con un contador inicializado en 1
                postCountByUser[post.user] = 1
            }
        }

        
        // Se convierte el objeto postCountByUser a un array de objetos, donde cada objeto tiene el usuario y su cantidad de publicaciones
        const objects_userPost = Object.keys(postCountByUser).map(user => ({
            user,
            post: postCountByUser[user]
        }))

        /*objects_userPost = [
            {
                user: 202010026
                post:8
            },

            {
                user: 202010025
                post:5
            }
        ]
        */

        // Agrega el nombre del usuario a objects_userPost
        for (const obj of objects_userPost) {
            const usuario = list_users.find(user => user.carnet === obj.user);
            if (usuario) {
                obj.nombre = usuario.nombre;
            }
        }

        /*objects_userPost = [
            {
                user: 202010026
                post:8
                nombre: Luis Jose
            },

            {
                user: 202010025
                post:5
                nombre: Maria Lopez
            }
        ]
        */


        objects_userPost.sort((a, b) => b.post - a.post)  // Se ordena el array objects_userPost en orden descendente según la cantidad de publicaciones

        const topuserPost = objects_userPost.slice(0, 10) //Obtiene solo los primeros 10 elementos de la lista

        res.json({ topBar: topuserPost })



    } catch (error) {
        return res.json(
            {
                error: "Ocurrió un error al eliminar al usuario"
            }
        )
    }
}

module.exports = {
    createPost,
    getAllPost,
    getReportBar
}