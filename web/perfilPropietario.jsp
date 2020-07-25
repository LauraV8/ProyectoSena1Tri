<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="vista/css/alquiler.css">
    <link rel="shortcut icon" href="imagenes/logo.ico">
    <title>Perfil</title>
</head>

<body>
    <div class="Pagina">
        <header>
            <nav>
                <div class="Menu">
                    <a href="index.jsp"><img class="logo" src="vista/imagenes/logo.png" alt="vivo turismo"></a>
                    <a class="men" href="configuracion.jsp">configuracion</a>
                    <a class="men" href="index.jsp">Cerrar sesion</a>
                    <a class="men" href="perfilPropietario.jsp">Perfil</a>
                </div>
            </nav>
        </header>
        <div>
            <div class="perfil , flo">
                <img class="foto" src="vista/imagenes/perfil.webp" alt="foto">
                <br>
                <h2>Nombre Completo</h2>
                <br>
                <p>Carlos Alberto Cardenas Garcia</p>
                <br>
                <h2>Fecha de nacimiento</h2>
                <br>
                <p>10/07/1975</p>
                <br>
                <h2>Propiedades</h2>
                <br>
                <p>2</p>
            </div>
            <div class="config flo">
                    <div class="propiedad flo"> 
                        <img class="alto" src="vista/imagenes/reemplazar.JPG" alt="">
                        <img class="bajo flo" src="vista/imagenes/reemplazar.JPG" alt="">
                        <img class="bajo flo" src="vista/imagenes/reemplazar.JPG" alt="">
                    </div>
                    <div class="informacion flo">
                        <a class="edit" href="editar.html">Editar</a>
                        <h2>Nombre propiedad</h2>
                        <br>
                        <div class="onoffswitch">
                                <input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox" id="myonoffswitch" checked>
                                <label class="onoffswitch-label" for="myonoffswitch">
                                    <span class="onoffswitch-inner"></span>
                                    <span class="onoffswitch-switch"></span>
                                </label>
                            </div>
                        <h2>Lugar</h2>
                        <br>
                        <img class="trash" src="vista/imagenes/trash.png" alt="">
                        <h2>Descripción</h2>
                        <textarea name="texto" rows="4" cols="40"></textarea>
                    </div>
                    <div class="añadir flo">
                        <img  class="center cen" src="vista/imagenes/descarga.png" alt="">
                        <h1 class="center" >Añadir propiedad</h1>
                    </div>
            </div>
        </div>
    </div>
</body>

</html>