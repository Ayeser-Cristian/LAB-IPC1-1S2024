## Requisitos:
- Tener instalado NodeJs 
  - Vídeo tutorial para instalar Nodejs:  <a href="https://youtu.be/v0x1Ku5Tgac?si=hjCcf9fNVRWJ4teH" target="_blank">Enlace Vídeo</a>
- Tenes instalado un Editor de Código (Se recomienda VisualCode)
  - Vídeo tutorial para instalar VsCode:  <a href="https://youtu.be/fw9QLJ46VGQ?si=zeiwcA26q-MywPyf" target="_blank">Enlace Vídeo</a>

- Una herramienta de Pruebas de API
  - Se recomienda instalar una extensión en VsCode como "Thunder Client" o "Postman".
  - Si se desea (no es necesario, con las extensiones es suficiente) se puede instalar la herramienta en su computadora, por ejemplo Postman: <a href="https://youtu.be/xjO9pltaPLQ?si=O9zKm-u_g9qN1vjO" target="_blank">Vídeo Instalar Postman</a>

## ¿Cómo levantar el Backend al momento de descagarlo?

- npm install : este comando descarga todas las dependecias necesarias para el proyecto (descaga la carpeta node_modules).
- npm start: este comando ejecuta el programa, es decir levanta la API (en el puerto 5000).


Nota: Para ejecutar los comandos anteriomente mencionados es necesario abrir una consola y estar dentro de la carpeta backend.

## Estructra de la API REST

### Estructura de Carpetas

- src

  - controllers
    - Aquí se encuentran todos los archivos js que realizan las acciones de las solicitudes HTTP.
  - DataList
    - Aquí se encuentra ```dataList.js``` en la cual se manejan las listas que se usarán para almacenar los datos en memoria.
  - objects
    - Aquí se encuentran las clases creadas, por ejemplo ```Usuario.js``` para guardar los datos de los usuarios que se registran.
  - routes
    - Aquí se encuentra ```routes.js``` en la cual se manejan las rutas de las solicitudes HTTP.
  - app.js - Es el archivo principal de la API REST, inicia la aplicación y esucha las solicitudes HTTP.
  
### Estructura de los JSON para cada solicitud HTTP

- /registro
  ```
    {
      "carnet":"201915547",
      "nombre": "Leo Ronaldo",
      "edad":25,
      "facultad": "Ingeniería",
      "password":"HolaMundo1*"

    }
  ```
- /Login
  ```
    {
      "carnet":"201915547",
      "password":"HolaMundo1*"
    }
  ```
- /update
  ```
    {
      "carnet":"201915547",
      "nombre": "Leo Messi",
      "edad":36,
      "facultad": "Ingeniería en Sistemas",
      "password":"HolaMundo1*"

    }
  ```
- /eliminar
  ```
    {
      "carnet":"201915547"
    }
  ```

## ¿Cómo Iniciar una API REST desde 0?

- Creamos nuestra carpeta, por ejemplo ```backend```.
- Dentro de la carpeta que creamos anteriomente en una consola ejecutamos el comando ```npm init -y```.
- Instalamos las dependecias necesarias:
  - ```npm install express```
  - ```npm install cors```
  - ```npm install nodemon``` (opcional)

- Ahora creamos un archivo llamado: ```.gitignore```
  - Dentro del archivo colocamos:
    ```
    node_modules/
    ```
  - Con este archivo evitamos que los ```node_modules``` se suban al repositorio, debido a que estos pesan demasiado y es una mala práctica subirlo al repositorio.
  - Por el mismo motivo que no subimos los ```node_modules``` al repositorio, es necesario ejecutar el comando ```npm install``` al momento de descargar/clonar un proyecto del repositorio.

- Si lo deseamos creamos la estructura de las carpetas anterimente mostradas o se implementa una propia estructura. 

- Si se instalo nodemon (npm install nodemon) y se seguío la misma estructura de las carpetas, realizar lo siguiente:
  - Ir a ```package.json```
  - En la parte donde dice ```scripts``` agregar lo siguiente ```"start": "nodemon src/app.js"```.
  - Ejemplo de cómo quedaría la estructura:
    ```
    "scripts": {
        "test": "echo \"Error: no test specified\" && exit 1",
        "start": "nodemon src/app.js"
    }
    ```
  - Pero... ¿Qué es nodemon?
    - Es una herramienta de desarrollo para Node.js que ayuda a automatizar el proceso de reiniciar la aplicación después de cada cambio en el código fuente. En lugar de tener que detener manualmente y reiniciar la aplicación cada vez que se hace un cambio en el código, nodemon monitorea los archivos del proyecto y reinicia automáticamente la aplicación cuando detecta cambios.

  - Con nodemon instalado, para levantar el proyecto debemos ejecutar el comando ```npm start```

## Nota: Se recomienda ver las clases del día 21 y 22 de marzo para comprende de mejor manera. 
