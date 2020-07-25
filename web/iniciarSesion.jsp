<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="vista/css/inicioSesion.css">
    <link rel="shortcut icon" href="vista/imagenes/logo.ico">
    <title>Inicio sesión</title>
</head>

<body>
    <div class="Pagina">
        <header>
            <nav>
                <div class="Menu">
                    
                    <a href="index.jsp"><img class="logo" src="vista/imagenes/logo.png" alt="vivo turismo"></a>
                    <a class="men" href="index.jsp">inicio</a>
                    <a class="men" href="registrarUsuario.jsp">Registrar</a>

                </div>
            </nav>
        </header>
        <div class="jk">
            
                <div class="formulario">
                    <img class="inicio" src="vista/imagenes/inicio_sesion.png" alt="">
                    
                    <form action="indexUsuarioIniciado.jsp">
                        
                        Usuario:<input class="inp CUA" type="text">
                        <br>
                        Contraseña:<input  class="inp"type="password">
                        <br>
                        <input class="boton" type="submit" value="Iniciar sesión">
                        <input class="boton" type="submit" value="Cancelar">
                        
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>

</html>