class Object_Post {
    constructor(id, user, descripcion, imagen) {
        this.id = id
        this.user = user
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.fechaHora = new Date();
        this.comentarios=[]
    }
  }
  
module.exports = Object_Post;