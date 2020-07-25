<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="vista/css/registro.css">
    <link rel="shortcut icon" href="vista/imagenes/logo.ico">
    <title>Registro</title>
</head>

<body>
    <div class="Pagina">
        <header>
            <nav>
                <div class="Menu">
                    <a href="index.jsp"><img class="logo" src="vista/imagenes/logo.png" alt="vivo turismo"></a>
                    <a class="men" href="añadirUsuario.jsp">Inicio sesión</a>
                    <a class="men" href="registrarUsuario.jsp">Registrar</a>

                </div>
            </nav>
        </header>
        <div class="jk">
                <div class="formulario">
                    <form action="indexUsuarioIniciado.jsp">
                        <p id="ma">Nombre:</p><input class="inp" type="text">
                        <p id="ma">Apellidos:</p><input  class="inp"type="text">
                        <p id="ma">Nombre de usuario:</p><input  class="inp"type="text">
                        <p id="ma">Tipo de Documento:</p><select class="inp" name="documento" id="">
                            <option value="">------------Seleccionar----------</option>
                            <option value="Cedula">Cédula de Ciudadanía</option>
                            <option value="extrangeria">Cédula de Extranjería</option>
                        </select>
                        <p id="ma">Número de Documento:</p><input  class="inp"type="text">
                        <p id="ma" >Rol:</p><select class="inp" name="documento" id="">
                                <option value="">------------Seleccionar----------</option>
                                <option value="Cedula">Usuario</option>
                                <option value="extrangeria">Propietario</option>
                            </select>
                        <p id="ma" >Teléfono:</p><input  class="inp"type="text">
                        <p id="ma">Contraseña:</p><input  class="inp"type="text">
                        <p id="ma" >Confirmar Contraseña:</p><input  class="inp"type="text">
                        <input class="boton" type="submit" value="Registrarse">
                    </form>
                </div>
                <img class="inicio" src="vista/imagenes/inicio_sesion.png" alt="inicio">
            </div>
        </div>
    </div>
</body>

</html>
