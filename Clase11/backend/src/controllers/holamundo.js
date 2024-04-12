
function hellowWorld(rep, res){

    res.json(
        {
        mensaje: 'Hi, this is my first API',
        }
   );
}


module.exports= {
    hellowWorld
}