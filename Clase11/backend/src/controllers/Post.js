
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

module.exports = {
    createPost,
    getAllPost
}