<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
    
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="vista/css/añadirPropiedad.css">
    <link rel="shortcut icon" href="vista/imagenes/logo.ico">
    
    <title>AñadirComentario</title>
    
</head>

<body>
    <div class="Pagina">
        <header>
            <nav>
                <div class="Menu">
                    <a href="index.jsp"><img class="logo" src="./vista/imagenes/logo.png" alt="vivo turismo"></a>
                        <a class="men" href="configuracion.html">Configuración</a>
                        <a class="men" href="index.jsp">Cerrar sesión</a>
                        <a class="men" href="perfilPropietario.jsp">Perfil</a>
                </div>
            </nav>
        </header>
        <div class="editar">
            <h2>Añadir comentario</h2>
            <form action="perfilPropietario.jsp">
                <textarea  class="ubi" name="descripcion" cols="30" rows="10" placeholder="Descripción" ></textarea>
                <p class="ubi">Calificación:</p>
                <select name="calificacion" class="tamaño">
                    <option value="">------- Seleccionar ---------</option>
                    <option value="1">1 🌟</option>
                    <option value="2">2 🌟🌟</option>
                    <option value="3">3 🌟🌟🌟</option>
                    <option value="4">4 🌟🌟🌟🌟</option>
                    <option value="5">5 🌟🌟🌟🌟🌟</option>
                </select>
                <input class="subir" type="submit" value="Añadir">
            </form>
        </div>
    </div>
    
</body>

</html>