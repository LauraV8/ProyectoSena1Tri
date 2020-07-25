<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
    
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="vista/css/añadirPropiedad.css">
    <link rel="shortcut icon" href="vista/imagenes/logo.ico">
    
    <title>Añadir  propiedad</title>
    
</head>

<body>
    <div class="Pagina">
        <header>
            <nav>
                <div class="Menu">
                        <a href="index.jsp"><img class="logo" src="vista/imagenes/logo.png" alt="vivo turismo"></a>
                        <a class="men" href="configuracion.html">Configuración</a>
                        <a class="men" href="index.jsp">Cerrar sesión</a>
                        <a class="men" href="perfilPropietario.jsp">Perfil</a>
                </div>
            </nav>
        </header>
        <div class="editar">
            <form action="perfilPropietario.jsp">
                <img class="añadir" src="vista/imagenes/mas_casa.png " alt="añadir">
                <input  class="ubica" type="submit" value="Subir">
                <textarea  class="ubi" name="descripcion" id="" cols="30" rows="10">Añadir descripción</textarea>
                <p class="ubi">Tipo inmueble:</p><select name="documento" class="tamaño">
                                <option value="">----------------------- Seleccionar --------------------</option>
                                <option value="finca">Finca</option>
                                <option value="Casa quinta">Casa quinta</option>
                                <option value="Condominio">Condominio</option>
                            </select>
                <p class="ubi">Ubicación</p><input type="text" class="tamaño">
            </form>
        </div>
    <div class="document">
        <p class="ubi">Cámara de comercio</p><input type="submit" class="boton" value="Subir">
        <p class="ubi">Certificado de tradición y libertad</p><input type="submit" class="boton" value="Subir">
        <p class="ubi">R.U.T</p><input type="submit" class="boton" value="Subir">
        <p class="ubi">R.N.T</p><input class="boton" type="submit" value="Subir">
    </div>
    
     <input class="subir" type="submit" value="Añadir">
    </div>
    
</body>

</html>